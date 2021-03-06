package com.myspring.boot3.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private static final String template = "Hello, %s!";
    

    @RequestMapping("/home")
    public String home(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.println("Home  Controller entry");
        return "Hello";
    }
}
