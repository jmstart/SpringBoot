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

	





