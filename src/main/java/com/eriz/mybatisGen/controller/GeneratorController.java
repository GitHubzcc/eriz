package com.eriz.mybatisGen.controller;

import com.eriz.common.domain.ConfigDo;
import com.eriz.common.service.ConfigService;
import com.eriz.common.util.Result;
import com.eriz.mybatisGen.service.GeneratorService;
import com.eriz.mybatisGen.type.EnumGen;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 代码生成
 * </pre>
 * <small> 2018年12月6日 | eriz</small>
 */
@RequestMapping("common/generator")
@Controller
@ApiIgnore
public class GeneratorController {
    String prefix = "common/generator";
    @Autowired
    private GeneratorService generatorService;
    @Autowired
    private ConfigService configService;

    /**
     * code page
     */
    @GetMapping("/")
    public String list() {
        return "common/generator/list";
    }

    /**
     * code data page
     */
    @ResponseBody
    @PostMapping(value = "/list")
    public Result tableList() {
        List<Map<String, Object>> list = generatorService.list();
        return Result.build(0, "操作成功", list);
    }

    /**
     * strategy edit
     */
    @GetMapping(value = "/strategyEdit")
    public String strategyEdit(Model model) {
        List<ConfigDo> list = configService.findListByKvType(EnumGen.KvType.mapping.getValue());
        List<ConfigDo> list2 = configService.findListByKvType(EnumGen.KvType.base.getValue());
        HashMap<String, String> map = new HashMap<>();
        for (ConfigDo config : list2) {
            map.put(config.getK(), config.getV());
        }

        model.addAttribute("list", list);
        model.addAttribute("property", map);
        return "common/generator/edit";
    }

    @ResponseBody
    @PostMapping(value = "/update")
    public Result update(@RequestParam Map<String, String> map) {
        configService.updateKV(map);
        return Result.success();
    }

    /**
     * generator code
     *
     * @param response  response
     * @param tableName table name
     */
    @RequestMapping("/code/{tableName}")
    public void code(HttpServletResponse response,
                     @PathVariable("tableName") String tableName) throws IOException {
        String[] tableNames = new String[]{tableName};
        byte[] data = generatorService.generatorCode(tableNames);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"code.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }
}
