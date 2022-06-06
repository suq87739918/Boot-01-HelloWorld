package com.atguigu.boot.Config;


import com.atguigu.boot.Bean.Car;
import com.atguigu.boot.Bean.Pet;
import com.atguigu.boot.Bean.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.regex.Matcher;

/**
 * 1.配置里面使用@Bean标注在方法上给容器注册组件时是单实例的，及在外部多次调用都调用的是容器中的单实例
 * 2.@Configuration(proxyBeanMethods = true)代理对象调用方法，SpringBoot总会检查被调用的组件是否在容器中，
 *      有就调用，没有就new一个，以保持组件单实例
 *      full: @Configuration(proxyBeanMethods = true)
 *      lite: @Configuration(proxyBeanMethods = false),此情况下每次代理都会产生一个新的对象
 * 3.@Import({User.class, Matcher.class})自动给容器中创建组件,
 * 4.条件装配：@ConditionalOnBean(name = "tom")在组件名称有tom的情况下，注入user01组件
 * 5.可以通过@ImportResource("")来指定导入Spring的配置文件，比如可以是@ImportResource("classpath:bean.xml")
 * 6.@EnableConfigurationProperties(Car.class) 开启Car的属性配置功能，同时把Car组件注册到容器中
 *      该方法和Config/MyConfig的方法选一种就可以！！！
 */
@ConditionalOnMissingBean(name = "tom")
@EnableConfigurationProperties(Car.class)
//@ConditionalOnBean(name = "tom")
@Import({User.class, Matcher.class})
@Configuration(proxyBeanMethods = true)  //告诉SpringBoot这是一个配置类文件，用于配置Bean
public class MyConfig {

    @Bean  //给容器添加组件，方法名为组件id,返回类型是组件类型，返回的值是容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan",18);
        //此处user组件依赖了pet组件，所以在@Configuration(proxyBeanMethods = true)情况下，zhangsan的宠物就是tomcat
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }
//    @Bean("tom")  //自定义组件名，在这里组件名是tom，而不是tomcatPet
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
