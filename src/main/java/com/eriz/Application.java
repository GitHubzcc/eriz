package com.eriz;

import com.eriz.common.util.SpringContextHolder;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <pre>
 * </pre>
 * @author  2018年12月5日 | eriz
 */
@MapperScan("com.eriz.*.dao")
@SpringBootApplication
@EnableSwagger2
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
