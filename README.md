# SpringBoot
1.什么是SpringBoot
  SpringBoot是Spring项目中的一个子工程，与我们所熟知的Spring-framework 同属于spring的产品

2.Takes an opinionated view of building production-ready Spring applications. 
  Spring Boot favors convention over configuration and is designed to get you up and running as quickly as possible.
  
  翻译:用一些固定的方式来构建生产级别的spring应用。SpringBoot 推崇约定大于配置的方式以便于你能够尽可能快速的启动并运行程序。
  其实人们把SpringBoot称为搭建程序的`脚手架`。其最主要作用就是帮我们快速的构建庞大的spring项目，并且尽可能的减少一切xml配置，
  做到开箱即用，迅速上手，让我们关注与业务而非配置。
  
3.为什么要学习SpringBoot
  SpringBoot简化了基于Spring的应用开发
  
4.SpringBoot主要目标是：
  - 为所有 Spring 的开发者提供一个非常快速的、广泛接受的入门体验
  - 开箱即用（启动器starter-其实就是SpringBoot提供的一个jar包），但通过自己设置参数（.properties），即可快速摆脱这种方式。
  - 提供了一些大型项目中常见的非功能性特性，如内嵌服务器、安全、指标，健康检测、外部化配置等
  - 绝对没有代码生成，也无需 XML 配置。
  
5. 快速入门
  5.1 导入坐标到pom.xml
    <!-- 先添加父工程坐标-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.4.RELEASE</version>
    </parent>
    
    <dependencies>
        <!-- 配置启动器-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
  5.2 主方法启动
    @SpringBootApplication
    public class BootDemo {
      public static void main(String[] args) {
        SpringApplication.run(BootDemo.class, args);
       }
    }

6. SpringBoot的属性注入
	6.1 普遍注入(普适性)
	1.将jdbc.properties名称改为application.properties
	2.在类上通过@ConfigurationProperties注解声明当前JdbcProperties类为属性读取类
		`prefix="jdbc"`读取属性文件中，前缀为jdbc的值
	3.声明有@Bean的方法参数注入 JdbcConfig中使用这个属性 @EnableConfigurationProperties(JdbcProperties.class)
	4.@Autowired注入
	5.构造函数注入

	6.2 更优雅的注入(自嗨式)
	我们直接把`@ConfigurationProperties(prefix = "jdbc")`声明在需要使用的`@Bean`的方法上，
	然后SpringBoot就会自动调用这个Bean（此处是DataSource）的set方法，然后完成注入。使用的前提是：**该类必须有对应属性的set方法！**

7. Yaml配置文件
	application.yaml 或 application.yml 替代 application.properties
	更加方便 简洁

8. 自动配置原理
	8.1 @SpringBootApplication
		其底层源码主要注解有:
			@SpringBootConfiguration
			@EnableAutoConfiguration
			@ComponentScan
	8.2 @SpringBootConfiguration
		配置注解
	8.3 @EnableAutoConfiguration
		启动自动配置
	8.4 @ComponentScan
		扫描配置:默认扫描的包是该类所在包及其子包。因此，**一般启动类会放在一个比较前的包目录中。**

9. 总结

SpringBoot为我们提供了默认配置，而默认配置生效的条件一般有两个：

- 你引入了相关依赖
- 你自己没有配置

1）启动器

所以，我们如果不想配置，只需要引入依赖即可，而依赖版本我们也不用操心，因为只要引入了SpringBoot提供的stater（启动器），就会自动管理依赖及版本了。

因此，玩SpringBoot的第一件事情，就是找启动器，SpringBoot提供了大量的默认启动器，参考资料中提供的《SpringBoot启动器.txt》

2）全局配置

另外，SpringBoot的默认配置，都会读取默认属性，而这些属性可以通过自定义`application.properties`文件来进行覆盖。这样虽然使用的还是默认配置，但是配置中的值改成了我们自定义的。

因此，玩SpringBoot的第二件事情，就是通过`application.properties`来覆盖默认属性值，形成自定义配置。我们需要知道SpringBoot的默认属性key，非常多，参考资料提供的：《SpringBoot全局属性.md》

10. SpringBoot实践
	10.1 整合SpringMVC (在application.yml里操作)
		修改端口: 
		server:
			port: 8088
		拦截路径:
		  servlet:
			path: "*.do"
		日志级别(输出日志):
		logging:
		  level:
			com.jiaming: debug
			org.springframework: debug

11. 配置拦截器
	11.1 首先定义一个拦截器
		@Slf4j //日志注解 以后可以直接使用注解 不用下面那句话了
		public class MyInterceptor implements HandlerInterceptor {
			//记日志 导入 org.slf4j.Logger 包
			//private static final Logger log = LoggerFactory.getLogger(MyInterceptor.class);
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
				//使用 log
				log.debug("preHandle method is running");
				return true;
			}
			@Override
			public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
				log.debug("postHandle method is running");
			}
			@Override
			public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
				log.debug("afterCompletion method is running");
			}
		}
	11.2 定义配置类，注册拦截器
		@Configuration
		public class MvcConfig implements WebMvcConfigurer {
			//添加拦截器
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
			}
		}

12. 整合数据库连接池和数据库驱动
	12.1 配置连接池(两个可以选择使用)
		配置一下启动器SpringBoot有默认连接池HiKariCP
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>
		
		<!-- Druid连接池 启动器 Druid官方提供的启动器--> 
		<dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>druid-spring-boot-starter</artifactId>
			<version>1.1.6</version>
		</dependency>
	
	12.2 配置数据库驱动
		<dependency>
		    <groupId>mysql</groupId>
		    <artifactId>mysql-connector-java</artifactId>
        	</dependency>
	
	12.3 配置application.yml文件

13. 整合mybatis
	13.1 mybatis启动器
	<!--mybatis -->
	<dependency>
		<groupId>org.mybatis.spring.boot</groupId>
		<artifactId>mybatis-spring-boot-starter</artifactId>
		<version>1.3.2</version>
	</dependency>
	
	13.2 配置application.yml文件
	mybatis:
	configuration:
	map-underscore-to-camel-case: true      //驼峰命名
	type-aliases-package: com.jiaming.pojo  //别名
	
	配置到启动类里
	@MapperScan("com.jiaming.mapper") //扫描mapper接口
	
14. 通用mapper
	14.1 引入启动器
	<!-- 通用mapper -->
	<dependency>
		<groupId>tk.mybatis</groupId>
		<artifactId>mapper-spring-boot-starter</artifactId>
		<version>2.0.2</version>
	</dependency>
	14.2 注意事项
	它自动引入Mybatis 和 jdbc数据库连接池 上面的坐标可以删掉
	在启动类中@MapperScan("com.jiaming.mapper") //扫描mapper接口 不能导入Mybatis注解包了 使用通用的 tk.mybatis...包
	application.yml文件 注释掉驼峰
	#驼峰 通用mapper 也引入了
	#configuration:
    	#map-underscore-to-camel-case: true

15. 引入Test
	 <!-- 引入一个 test 启动器-->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-test</artifactId>
	</dependency>
	测试: 快捷键 创建一个UserMapperTest 测试类
	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class UserMapperTest {

		@Autowired
		private  UserMapper userMapper;

		@Test
		public void testQuery(){
			User user = userMapper.selectByPrimaryKey(1L);
			System.out.println("user = "+ user);
		}
	}

16. 事务的使用
    引入Jdbc 也就是把事务配置好了
    直接使用就好 @Transactional注解
    @Transactional //开启事务
    public void insertUser(User user){
	userMapper.insert(user);
    }
	
