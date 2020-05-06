# SpringBoot

一、SpringBoot简介

  1.1 Spring框架优缺点分析
    
   1.1.1 Spring的优点分析
   
      Spring是Java企业版（Java Enterprise Edition，JEE，也称J2EE）的轻量级代替品。无需开发重量级的Enterprise JavaBean（EJB）,
    Spring为企业级Java开发提供了一种相对简单的方法，通过依赖注入和面向切面编程，用简单的Java对象（Plain Old Java Object，POJO）实现了EJB的功能。
    
   1.1.2 Spring的缺点分析
    
      虽然Spring的组件代码是轻量级的，但它的"配置"却是重量级的。
      一开始，Spring用XML配置，而且是很多XML配置。Spring 2.5引入了基于注解的组件扫描,
      这消除了大量针对应用程序自身组件的显式XML配置。Spring 3.0引入了基于Java的配置，这是一种类型安全的可重构配置方式，可以代替XML。
      所有这些配置都代表了开发时的损耗。因为在思考Spring特性配置和解决业务问题之间需要进行思维切换，所以编写配置挤占了编写应用程序逻辑的时间。
      和所有框架一样，Spring实用，但与此同时它要求的回报也不少。
      除此之外，项目的依赖管理也是一件耗时耗力的事情。
      在环境搭建时，需要分析要导入哪些库的坐标，而且还需要分析导入与之有依赖关系的其他库的坐标，一旦选错了依赖的版本，
      随之而来的不兼容问题就会严重阻碍项目的开发进度。

  1.2 SpringBoot框架的概述
    
   1.2.1 SpringBoot解决上述Spring的缺点
   
    SpringBoot对上述Spring的缺点进行的改善和优化，基于约定优于配置的思想，可以让开发人员不必在配置与逻辑业务之间进行思维的切换，
    全身心的投入到逻辑业务的代码编写中，从而大大提高了开发的效率，一定程度上缩短了项目周期。
    
   1.2.2 SpringBoot的特点
   
    a:为基于Spring的开发提供更快的入门体验
    b:开箱即用，没有代码生成，也无需XML配置。同时也可以修改默认值来满足特定的需求
    c:提供了一些大型项目中常见的非功能性特性，如嵌入式服务器、安全、指标，健康检测、外部配置等
    d:SpringBoot不是对Spring功能上的增强，而是提供了一种快速使用Spring的方式
    
   1.2.3 SpringBoot的核心功能
   
    a:起步依赖
      起步依赖本质上是一个Maven项目对象模型（Project Object Model，POM），定义了对其他库的传递依赖，这些东西加在一起即支持某项功能。
    简单的说，起步依赖就是将具备某种功能的坐标打包到一起，并提供一些默认的功能。

    b:自动配置
      SpringBoot的自动配置是一个运行时（更准确地说，是应用程序启动时）的过程，考虑了众多因素，才决定Spring配置应该用哪个，不该用哪个。
    该过程是Spring自动完成的。

二、SpringBoot快速入门

   2.1 添加SpringBoot的起步依赖
    
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.1.RELEASE</version>
    </parent>
    
   2.2 SpringBoot要集成SpringMVC进行Controller的开发，所以项目要导入web的启动依赖
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

   2.3 编写SpringBoot引导类
    
   要通过SpringBoot提供的引导类起步SpringBoot才可以进行访问

    package com.jiaming;

    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;

    @SpringBootApplication
    public class MySpringBootApplication {

        public static void main(String[] args) {
            SpringApplication.run(MySpringBootApplication.class);
        }
    }
    
   2.4 SpringBoot工程热部署
  
       我们在开发中反复修改类、页面等资源，每次修改后都是需要重新启动才生效，这样每次启动都很麻烦，浪费了大量的时间，
    我们可以在修改代码后不重启就能生效，在 pom.xml 中添加如下配置就可以实现这样的功能，我们称之为热部署。
    
    <!--热部署配置-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
    </dependency>
   

三. SpringBoot的配置文件

   3.1 SpringBoot配置文件类型和作用
      
      SpringBoot是基于约定的，所以很多配置都有默认值，但如果想使用自己的配置替换默认配置的话，
      就可以使用application.properties application.yml（application.yaml）进行配置。
      SpringBoot默认会从Resources目录下加载application.properties或application.yml（application.yaml）文件，
      其中，application.properties文件是键值对类型的文件，之前一直在使用，除了properties文件外，SpringBoot还可以使用yml文件进行配置。

   3.2 yml配置文件简介
      
      YML文件格式是YAML (YAML Aint Markup Language)编写的文件格式，YAML是一种直观的能够被电脑识别的的数据数据序列化格式，并且容易被人类阅读，
      容易和脚本语言交互的，可以被支持YAML库的不同的编程语言程序导入。
      比如： C/C++, Ruby, Python, Java, Perl, C#, PHP等。YML文件是以数据为核心的，比传统的xml方式更加简洁。
      YML文件的扩展名可以使用.yml或者.yaml。

四. SpringBoot整合其他技术

   4.1 SpringBoot整合Mybatis
    
      添加Mybatis的起步依赖
      
      <!--mybatis起步依赖-->
      <dependency>
          <groupId>org.mybatis.spring.boot</groupId>
          <artifactId>mybatis-spring-boot-starter</artifactId>
          <version>1.1.1</version>
      </dependency>
      
     添加数据库驱动坐标
     
     <!-- MySQL连接驱动 -->
     <dependency>
         <groupId>mysql</groupId>
         <artifactId>mysql-connector-java</artifactId>
     </dependency>
     
   4.2 SpringBoot整合Junit
    
    添加Junit的起步依赖
    
    <!--测试的起步依赖-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    
  
  4.3 SpringBoot整合SpringDataJPA

    添加Spring Data JPA的起步依赖
    
    <!-- springBoot JPA的起步依赖 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    添加数据库驱动依赖
    
  4.4 SpringBoot整合Redis
    
    添加redis的起步依赖
    
    <!-- 配置使用redis启动器 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
    
五. SpringBoot日志

  5.1 日志框架
    
    市面上的日志框架:

    JUL、JCL、Jboss-logging、logback、log4j、log4j2、slf4j....

    SpringBoot选则的日志框架:
    
    日志的抽象层(门面): SLF4J
    日志实现: Logback
 
    Spring框架默认是用JCL,SpringBoot选用SLF4j和logback

  5.2 SLF4J的使用
  
    如何在系统中使用SLF4j:
   https://www.slf4j.org
    
    开发的时候，日志记录方法的调用，不应该来直接调用日志的实现类，而是调用日志抽象层里面的方法；
    给系统里面导入slf4j的jar和logback的实现jar

   ```java
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;

    public class HelloWorld {
      public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HelloWorld.class);
        logger.info("Hello World");
      }
    }
   ```
   
  5.3 日志的统一
    
    如何让系统中所有的日志都统一到slf4j:

    1、将系统中其他日志框架先排除出去

    2、用中间包来替换原有的日志框架

    3、我们导入slf4j其他的实现
  
    SpringBoot能自动适配所有的日志，而且底层使用slf4j+logback的方式记录日志，引入其他框架的时候，只需要把这个框架依赖的日志框架排除掉即可

  5.4 日志的配置
  
     日志输出格式：
    		%d表示日期时间，
    		%thread表示线程名，
    		%-5level：级别从左显示5个字符宽度
    		%logger{50} 表示logger名字最长50个字符，否则按照句点分割。 
    		%msg：日志消息，
    		%n是换行符
        -->
        %d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n
        SpringBoot修改日志的默认配置
     
    ```properties
     logging.level.com.atguigu=trace

     #logging.path=
     # 不指定路径在当前项目下生成springboot.log日志
     # 可以指定完整的路径；
     #logging.file=D:/springboot.log

     # 在当前磁盘的根路径下创建spring文件夹和里面的log文件夹；使用 spring.log 作为默认文件
     logging.path=/spring/log

     #  在控制台输出的日志的格式
     logging.pattern.console=%d{yyyy-MM-dd} [%thread] %-5level %logger{50} - %msg%n
     # 指定文件中日志输出的格式
     logging.pattern.file=%d{yyyy-MM-dd} === [%thread] === %-5level === %logger{50} ==== %msg%n
    ```
   
  5.5 指定配置
  
    logback.xml：直接就被日志框架识别了

    logback-spring.xml：日志框架就不直接加载日志的配置项，由SpringBoot解析日志配置，可以使用SpringBoot的高级Profile功能
    
   ```xml
    <springProfile name="staging">
        <!-- configuration to be enabled when the "staging" profile is active -->
        可以指定某段配置只在某个环境下生效
    </springProfile>
   ```
    例如：
    
   ```xml
    <appender name="stdout" class="ch.qos.logback.core.ConsoleAppender">
      <!--
      日志输出格式：
      %d表示日期时间，
      %thread表示线程名，
      %-5level：级别从左显示5个字符宽度
      %logger{50} 表示logger名字最长50个字符，否则按照句点分割。 
      %msg：日志消息，
      %n是换行符
      -->
        <layout class="ch.qos.logback.classic.PatternLayout">
            <springProfile name="dev">
                <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} ----> [%thread] ---> %-5level %logger{50} - %msg%n</pattern>
            </springProfile>
            <springProfile name="!dev">
                <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} ==== [%thread] ==== %-5level %logger{50} - %msg%n</pattern>
            </springProfile>
        </layout>
    </appender>
   ```

六. SpringBoot之Web开发

 6.1 SpringBoot对静态资源的映射规则
    
    SpringBoot源码:
    
    java:
      @ConfigurationProperties(prefix = "spring.resources", ignoreUnknownFields = false)
      public class ResourceProperties implements ResourceLoaderAware {
      //可以设置和静态资源有关的参数，缓存时间等
    
    java:
      WebMvcAuotConfiguration：
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
          if (!this.resourceProperties.isAddMappings()) {
            logger.debug("Default resource handling disabled");
            return;
          }
          Integer cachePeriod = this.resourceProperties.getCachePeriod();
          if (!registry.hasMappingForPattern("/webjars/**")) {
            customizeResourceHandlerRegistration(
                registry.addResourceHandler("/webjars/**")
                    .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/")
                .setCachePeriod(cachePeriod));
          }
          String staticPathPattern = this.mvcProperties.getStaticPathPattern();
                //静态资源文件夹映射
          if (!registry.hasMappingForPattern(staticPathPattern)) {
            customizeResourceHandlerRegistration(
                registry.addResourceHandler(staticPathPattern)
                    .addResourceLocations(
                        this.resourceProperties.getStaticLocations())
                .setCachePeriod(cachePeriod));
          }
        }

        //配置欢迎页映射
        @Bean
        public WelcomePageHandlerMapping welcomePageHandlerMapping(
            ResourceProperties resourceProperties) {
          return new WelcomePageHandlerMapping(resourceProperties.getWelcomePage(),
              this.mvcProperties.getStaticPathPattern());
        }

        //配置自己喜欢的图标
        @Configuration
        @ConditionalOnProperty(value = "spring.mvc.favicon.enabled", matchIfMissing = true)
        public static class FaviconConfiguration {

          private final ResourceProperties resourceProperties;

          public FaviconConfiguration(ResourceProperties resourceProperties) {
            this.resourceProperties = resourceProperties;
          }

          @Bean
          public SimpleUrlHandlerMapping faviconHandlerMapping() {
            SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
            mapping.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
                    //所有  **/favicon.ico 
            mapping.setUrlMap(Collections.singletonMap("**/favicon.ico",
                faviconRequestHandler()));
            return mapping;
          }

          @Bean
          public ResourceHttpRequestHandler faviconRequestHandler() {
            ResourceHttpRequestHandler requestHandler = new ResourceHttpRequestHandler();
            requestHandler
                .setLocations(this.resourceProperties.getFaviconLocations());
            return requestHandler;
          }

        }
    
    webjars：以jar包的方式引入静态资源
    
    所有 /webjars/** ，都去 classpath:/META-INF/resources/webjars/ 找资源
    
    xml:
      <!--引入jquery-webjar-->在访问的时候只需要写webjars下面资源的名称即可
      <dependency>
        <groupId>org.webjars</groupId>
        <artifactId>jquery</artifactId>
        <version>3.3.1</version>
      </dependency>
    
 6.2 静态资源
    
    访问当前项目的任何资源，都去（静态资源的文件夹）找映射  
    
    "classpath:/META-INF/resources/", 
    "classpath:/resources/",
    "classpath:/static/", 
    "classpath:/public/" 
    "/"：当前项目的根路径
    
七. 模板引擎

 7.1 Thymeleaf
    
    模板引擎的种类: JSP、Velocity、Freemarker、Thymeleaf  
    
    SpringBoot推荐的Thymeleaf

    语法更简单，功能更强大
    
    引入:
    
    xml:
      <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
      </dependency>
      
      切换thymeleaf版本:
      
      <properties>
          <thymeleaf.version>3.0.9.RELEASE</thymeleaf.version>
          <!-- 布局功能的支持程序  thymeleaf3主程序  layout2以上版本 -->
          <!-- thymeleaf2  layout1-->
          <thymeleaf-layout-dialect.version>2.2.2</thymeleaf-layout-dialect.version>
       </properties>
   
 7.2 Thymeleaf使用
    
    java:
      @ConfigurationProperties(prefix = "spring.thymeleaf")
      public class ThymeleafProperties {

        private static final Charset DEFAULT_ENCODING = Charset.forName("UTF-8");

        private static final MimeType DEFAULT_CONTENT_TYPE = MimeType.valueOf("text/html");

        public static final String DEFAULT_PREFIX = "classpath:/templates/";

        public static final String DEFAULT_SUFFIX = ".html";
     
    只要我们把HTML页面放在classpath:/templates/,thymeleaf就能自动渲染
    
    使用：

    1、导入thymeleaf的名称空间
    
    xml:
      <html lang="en" xmlns:th="http://www.thymeleaf.org">
    
    2、使用thymeleaf语法；

   ```html
      <!DOCTYPE html>
      <html lang="en" xmlns:th="http://www.thymeleaf.org">
      <head>
          <meta charset="UTF-8">
          <title>Title</title>
      </head>
      <body>
          <h1>测试Thymeleaf</h1>
          <!--取数据-->
          <div th:text="${name}"></div>
          <hr/>
      </body>
      </html>
   ```
八. SpringMVC自动配置

  8.1  SpringMVC auto-configuration
    
    SpringBoot 自动配置好了SpringMVC
    
    以下是SpringBoot对SpringMVC的默认配置:**==(WebMvcAutoConfiguration)源码==**

    - Inclusion of `ContentNegotiatingViewResolver` and `BeanNameViewResolver` beans.
      - 自动配置了ViewResolver（视图解析器：根据方法的返回值得到视图对象（View），视图对象决定如何渲染（转发？重定向？））
      - ContentNegotiatingViewResolver：组合所有的视图解析器的；
      - ==如何定制：我们可以自己给容器中添加一个视图解析器；自动的将其组合进来；==

    - Support for serving static resources, including support for WebJars (see below).静态资源文件夹路径,webjars

    - Static `index.html` support. 静态首页访问

    - Custom `Favicon` support (see below).  favicon.ico

    - 自动注册了 of `Converter`, `GenericConverter`, `Formatter` beans.

      - Converter：转换器；  public String hello(User user)：类型转换使用Converter
      - `Formatter`  格式化器；  2017.12.17===Date；
    
    
    既保留了所有的自动配置，也能用我们扩展的配置；

   ```java
      //使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
      @Configuration
      public class MyMvcConfig extends WebMvcConfigurerAdapter {

          @Override
          public void addViewControllers(ViewControllerRegistry registry) {
             // super.addViewControllers(registry);
              //浏览器发送 /action 请求来到 success
              registry.addViewController("/action").setViewName("success");
          }
      }
   ```
    
    其他关于SpringBoot Web的操作可以看我的案例: SpringBoot_Web_Restful_CRUD工程
    
    
    
  
    
    
    
    
    
    
    
    
    
    
