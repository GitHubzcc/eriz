package com.eriz.sys.controller;

import com.eriz.common.domain.TreeDo;
import com.eriz.sys.domain.MenuDo;
import com.eriz.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/main")
    public String main(){
        return "main";
    }


    @RequestMapping(value = "common/sysDict")
    public String dis(){
        return "login";
    }

    @RequestMapping("/hello")
    public String helloHtml(Model model) {
        List<TreeDo<MenuDo>> list = menuService.findListByUserId(1L);

        list.stream().forEach(kv -> System.out.println(kv.getText()));
        //map.put("hello", "欢迎进入HTML页面");
        //mv.setViewName("login");
        model.addAttribute("menus", list);
        model.addAttribute("name", "name");
        model.addAttribute("username", "username");
        //FileDO fileDO = fileService.selectById(getUser().getPicId());
        model.addAttribute("picUrl", "http://wx.qlogo.cn/mmopen/A7sq8BD8oewx50myY72SwetEVkBXbXDvT5jj6ytorRxqyGwtBu1XTnWGohGXhdTtTwh6VSAbUEUSWpibddJDChg/0");
        return "index";
    }
}
