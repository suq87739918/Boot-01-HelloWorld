package com.atguigu.boot;

import com.atguigu.boot.Bean.Pet;
import com.atguigu.boot.Bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.regex.Matcher;

@SpringBootConfiguration
@SpringBootApplication //这是一个springboot应用    @SpringBootApplication(scanBasePackages = "")可以改变包扫描位置
public class MainApplication {
    public static void main(String[] args){
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class,args);

        //查看容器中的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names){
            System.out.println(name);
        }

//        //从容器中获取组件
//        Pet pet01 = run.getBean("tom",Pet.class);
//        Pet pet02 = run.getBean("tom",Pet.class);
//        System.out.println("组件是否一样:" + (pet01 == pet02));
//
//        User user01 = run.getBean("user01", User.class);
//        Pet tom = run.getBean("tom", Pet.class);
//        System.out.println("在依赖组件情况下，user01的宠物是否是pet组件的tom:" + (user01.getPet() == tom));
//
//        //获取组件名称
//        String[] beanNameForType = run.getBeanNamesForType(User.class);
//        System.out.println("====================================");//分隔符
//        for (String s : beanNameForType){
//            System.out.println(s);
//        }
//        Matcher bean1999 = run.getBean(Matcher.class);
//        System.out.println(bean1999);
        boolean tom = run.containsBean("tom"); //检查是否含有tom这个组件
        System.out.println("容器中是否含有tom组件：" + tom);
        boolean user01 = run.containsBean("user01");
        System.out.println("容器中是否含有user01组件：" + user01);

    }
}

