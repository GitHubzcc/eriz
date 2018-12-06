package com.eriz.sys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 *     系统模块
 * </pre>
 * <small> 2018年12月5日 | eriz</small>
 */
@RequestMapping(value = "user")
@RestController
public class UserController {

    @RequestMapping(value = "/freemarker")
    public ModelAndView test(ModelAndView mv){
        mv.addObject("name","hello spring boot");
        mv.setViewName("freemarker");
        return mv;
    }
}
