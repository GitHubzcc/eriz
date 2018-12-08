package com.eriz.mybatisGen.controller;

import com.eriz.common.service.ConfigService;
import com.eriz.mybatisGen.service.GeneratorService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <pre>
 * 代码生成
 * </pre>
 * <small> 2018年12月6日 | eriz</small>
 */
@RequestMapping("/common/generator")
@Controller
public class GeneratorController {
    String prefix = "common/generator";
    @Autowired
    GeneratorService generatorService;
    @Autowired
    ConfigService configService;

    
    @RequestMapping("/code/{tableName}")
    public void code(HttpServletRequest request, HttpServletResponse response,
            @PathVariable("tableName") String tableName) throws IOException {
        System.out.println(tableName+"--------");
        tableName = "sys_user";
        String[] tableNames = new String[] { tableName };
        byte[] data = generatorService.generatorCode(tableNames);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"code.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }
}
