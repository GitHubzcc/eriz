package com.eriz.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/freemarker")
public class freemarkerTest {

    @RequestMapping(value = "/test")
    public ModelAndView freemarker(ModelAndView mv) {
        mv.addObject("name", "hello eriz");
        mv.setViewName("freemarker");
        return mv;
    }
}
