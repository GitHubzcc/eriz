package com.eriz.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ErizApplication {

    @RequestMapping("/index")
    String index(){
        return "Hello Spring Boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(ErizApplication.class, args);
    }
}
