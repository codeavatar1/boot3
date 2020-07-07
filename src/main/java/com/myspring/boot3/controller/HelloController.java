package com.myspring.boot3.controller;
import org.springframework.web.bind.annotation.RestController;

//import com.myspring.boot3.EnableAutoConfiguration;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.autoconfigure.*;


@RestController
@EnableAutoConfiguration
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
