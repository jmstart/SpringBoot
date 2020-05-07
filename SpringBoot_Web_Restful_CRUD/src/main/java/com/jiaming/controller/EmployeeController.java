package com.jiaming.controller;

import com.jiaming.dao.DepartmentDao;
import com.jiaming.dao.EmployeeDao;
import com.jiaming.entities.Department;
import com.jiaming.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author jmstart
 * @create 2020-05-03 10:27
 *
 * 员工Controller
 */
@Controller
public class EmployeeController {

    //注入EmployeeDao
    @Autowired
    private EmployeeDao employeeDao;
    //注入
    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 查询员工列表
     * @return 列表页面
     */
    @GetMapping("/emps")
    public String list(Model model) {
        //查询
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps", employees);
        //返回到列表页面
        return "emp/list";
    }

    /**
     * 添加:
     * 来到添加员工页面
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //查出所有部门,回显到页面
        Collection<Department> departments = departmentDao.getDepartments();
        //放到Request域中
        model.addAttribute("depts",departments);
        //返回到添加页面
        return "emp/add";
    }

    /**
     * 添加员工
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        //添加员工
        employeeDao.save(employee);
        //来到员工显示页面
        return "redirect:/emps";
    }

    /**
     * 修改:
     * 来到修改员工信息页面
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
        //根据 id查询员工信息
        Employee employee = employeeDao.get(id);
        //回显数据,保存到域中
        model.addAttribute("emp", employee);
        //查出所有部门,回显
        Collection<Department> departments = departmentDao.getDepartments();
        //放到Request域中
        model.addAttribute("depts",departments);
        //回到修改页面,复用了add.html页面,修改添加二合一
        return "emp/add";
    }

    /**
     * 修改员工信息
     * @return
     */
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        //保存修改后的员工信息
        employeeDao.save(employee);
        //回到员工列表页面
        return "redirect:/emps";
    }

    /**
     * 员工删除
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }


}
