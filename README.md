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
    
    ```xml
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.1.RELEASE</version>
    </parent>
    ```
   2.2 SpringBoot要集成SpringMVC进行Controller的开发，所以项目要导入web的启动依赖
    
    ```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
    ```
   2.3 编写SpringBoot引导类
    
   要通过SpringBoot提供的引导类起步SpringBoot才可以进行访问

    ```java
    package com.jiaming;

    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;

    @SpringBootApplication
    public class MySpringBootApplication {

        public static void main(String[] args) {
            SpringApplication.run(MySpringBootApplication.class);
        }
    }
    ```
   2.4 SpringBoot工程热部署
  
       我们在开发中反复修改类、页面等资源，每次修改后都是需要重新启动才生效，这样每次启动都很麻烦，浪费了大量的时间，
    我们可以在修改代码后不重启就能生效，在 pom.xml 中添加如下配置就可以实现这样的功能，我们称之为热部署。
    ```xml
    <!--热部署配置-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
    </dependency>
    ```

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

四. SpringBoot与整合其他技术

   4.1 SpringBoot整合Mybatis
    
      添加Mybatis的起步依赖
      ```xml
      <!--mybatis起步依赖-->
      <dependency>
          <groupId>org.mybatis.spring.boot</groupId>
          <artifactId>mybatis-spring-boot-starter</artifactId>
          <version>1.1.1</version>
      </dependency>
      ```
     添加数据库驱动坐标
     ```xml
     <!-- MySQL连接驱动 -->
     <dependency>
         <groupId>mysql</groupId>
         <artifactId>mysql-connector-java</artifactId>
     </dependency>
     ```
   4.2 SpringBoot整合Junit
    
    添加Junit的起步依赖
    ```xml
    <!--测试的起步依赖-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    ```
  
  4.3 SpringBoot整合SpringDataJPA

    添加Spring Data JPA的起步依赖
    ```xml
    <!-- springBoot JPA的起步依赖 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    ```
    添加数据库驱动依赖
    
  4.4 SpringBoot整合Redis
    
    添加redis的起步依赖

    ```xml
    <!-- 配置使用redis启动器 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
    ```
    
五.













