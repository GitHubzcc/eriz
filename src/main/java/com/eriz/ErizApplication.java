package com.eriz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月5日 | eriz</small>
 */
@MapperScan("com.eriz.*.dao")
@SpringBootApplication
public class ErizApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErizApplication.class, args);
    }
}
