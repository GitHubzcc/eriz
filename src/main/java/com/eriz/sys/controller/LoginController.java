package com.eriz.sys.controller;

import com.eriz.common.annotation.Log;
import com.eriz.common.base.SysController;
import com.eriz.common.domain.TreeDo;
import com.eriz.common.util.MD5Utils;
import com.eriz.common.util.Result;
import com.eriz.sys.domain.MenuDo;
import com.eriz.sys.domain.UserDo;
import com.eriz.sys.service.MenuService;
import com.eriz.sys.service.RoleService;
import com.eriz.sys.service.UserService;
import com.google.code.kaptcha.Producer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;


/**
 * 登录控制
 * 2018年12月18日 | eriz
 */
@Controller
public class LoginController extends SysController {

    @Resource
    private MenuService menuService;

    @Resource
    private Producer producer;

    @GetMapping(value = {"login", "/"})
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();//取出当前验证主体
        if (subject != null) {
            subject.logout();//不为空，执行一次logout的操作，将session全部清空
        }
        return "login";
    }

    @RequestMapping(value = "/main")
    public String main() {
        return "main";
    }

    @ResponseBody
    @RequestMapping(value = "getUser")
    public List<TreeDo<MenuDo>> user() {
        return menuService.findListByUserId(1L);
    }

    @ResponseBody
    @Log("登陆")
    @PostMapping(value = "loginFrom")
    public Result loginFrom(String username, String password, String kaptcha) {
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        token.setRememberMe(true);//记住我是可选项，但只有会话缓存到redis等持久存储才能真正记住
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return Result.success();
        } catch (AuthenticationException e) {
            return Result.build(-1, e.getMessage(), null);
        }
    }

    /**
     * 登录验证码
     */
    @RequestMapping("kaptcha")
    public void captcha(HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = producer.createText();
        BufferedImage image = producer.createImage(text);
        // session
        //WebUtil.setSession(Const.CAPTCHA_CODE, text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    @RequestMapping(value = "/index")
    public String root(Model model) {
        List<TreeDo<MenuDo>> list = menuService.findListByUserId(1L);
        UserDo userDo = getUser();
        model.addAttribute("menus", list);
        model.addAttribute("user", userDo);
        //FileDO fileDO = fileService.selectById(getUser().getPicId());
        model.addAttribute("picUrl", "/img/avator.jpg");
        return "index";
    }
}
