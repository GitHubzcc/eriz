package com.eriz;

import com.eriz.common.util.SpringContextHolder;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;

/**
 * <pre>
 * </pre>
 * <small> 2018年12月5日 | eriz</small>
 */
@MapperScan("com.eriz.*.dao")
@SpringBootApplication
public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        init();
    }

    public static void init() {
        ServerProperties serverProperties = SpringContextHolder.getApplicationContext().getBean(ServerProperties.class);

        log.info("run http://localhost:" + serverProperties.getPort());
    }
}
