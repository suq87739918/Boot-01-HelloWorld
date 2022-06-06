package com.atguigu.boot.Controller;

import com.atguigu.boot.Bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld_Controller {

    @Autowired   //自动注入
    Car car;
    @RequestMapping("/car")
    public Car car(){
        return car;
    }
    @RequestMapping("/hello")
    public String handle01(){
        return "Hello World!";
    }
}
