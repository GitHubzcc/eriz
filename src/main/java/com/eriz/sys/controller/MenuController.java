package com.eriz.sys.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eriz.common.base.BaseController;
import com.eriz.common.util.JsonUtil;
import com.eriz.common.util.Result;
import com.eriz.sys.domain.MenuDo;
import com.eriz.sys.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 系统菜单
 * 2018年12月16日 eriz
 */
@RequestMapping(value = "sys/menu")
@Controller
@ApiIgnore
public class MenuController extends BaseController {

    @Resource
    MenuService menuService;


    /**
     * 菜单首页
     */
    @GetMapping(value = "/")
    public String list() {
        return "sys/menu/lists";
    }

    /**
     * 菜单tableTree
     *
     * @param keyValue 角色id
     * @return String
     */
    @ResponseBody
    @GetMapping(value = "menuTreeJson")
    public String tableTree(Long keyValue) {
//        List<Map<String, Object>> list = menuService.menuTree(keyValue);
        List<MenuDo> list = menuService.selectList(null);
        return JsonUtil.getInstance().toJson(list);
    }

    /**
     * add/edit
     */
    @RequestMapping(value = "add")
    public String save(Model model, Long keyValue, Long pId) {
        //编辑
        if (keyValue != null && pId == null) {
            MenuDo menuDo = menuService.selectById(keyValue);
            if (menuDo != null && menuDo.getParentId() != null && menuDo.getParentId() != 0) {
                model.addAttribute("pName", menuService.selectById(menuDo.getParentId()).getName());
                model.addAttribute("pId", menuDo.getParentId());
            } else if (menuDo != null && menuDo.getParentId() == null || 0 == menuDo.getParentId()) {
                model.addAttribute("pName", "根目录");
            }
            model.addAttribute("menu", menuDo);
        } else if (keyValue == null && pId != null) {
            //添加下级菜单
            MenuDo menuDo = menuService.selectById(pId);
            model.addAttribute("pName", menuDo.getName());
            model.addAttribute("pId", pId);
        } else {
            //添加根级目录
            model.addAttribute("pName", "根目录");
        }
        return "sys/menu/add";
    }

    /**
     * add/edit save
     */
    @ResponseBody
    @PostMapping(value = "save")
    public Result save(MenuDo menuDo) {
        return menuService.insert(menuDo) ? Result.success() : Result.fail();
    }

    /**
     * 删除
     */
    @ResponseBody
    @PostMapping(value = "remove")
    public Result remove(Long id) {
        List<MenuDo> list = menuService.selectList(new EntityWrapper<MenuDo>().eq("parentId", id));
        if (list != null && list.size() > 0) {
            return Result.build(-1, "该菜单目录下有子菜单，删除失败!", null);
        } else {
            menuService.deleteById(id);
            return Result.success();
        }
    }


    /**
     * 菜单树
     *
     * @param keyValue 角色id
     * @return list
     */
    @ResponseBody
    @GetMapping(value = "menuTree")
    public List<Map<String, Object>> menuTree(Long keyValue) {
        return menuService.menuTree(keyValue);
    }

    /**
     * 菜单树结构
     */
    @RequestMapping(value = "treeView")
    public String treeView() {
        return "sys/dept/deptTree";
    }
}
