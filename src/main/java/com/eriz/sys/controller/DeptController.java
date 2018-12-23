package com.eriz.sys.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eriz.common.base.SysController;
import com.eriz.common.util.JsonUtil;
import com.eriz.common.util.Result;
import com.eriz.sys.domain.DeptDo;
import com.eriz.sys.domain.MenuDo;
import com.eriz.sys.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 部门
 * 2018年12月13日 eriz
 */
@RequestMapping(value = "sys/dept")
@Controller
public class DeptController extends SysController {

    @Resource
    private DeptService deptService;

    /**
     * 部门页面
     */
    @GetMapping(value = "/")
    public String list() {
        return "sys/dept/lists";
    }

    /**
     * 部门 tableTree
     *
     * @return String
     */
    @ResponseBody
    @GetMapping(value = "deptTreeJson")
    public String tableTree(String keyValue) {
        List<DeptDo> dos = deptService.selectList(new EntityWrapper<DeptDo>().like("name",keyValue));
        return JsonUtil.getInstance().toJson(dos);
    }

    /**
     * add/edit 页面
     */
    @RequestMapping(value = "add")
    public String save(Model model, Long keyValue, Long pId) {
        //编辑
        if (keyValue != null && pId == null) {
            DeptDo deptDo = deptService.selectById(keyValue);
            if (deptDo != null && deptDo.getParentId() != null && deptDo.getParentId() != 0) {
                model.addAttribute("pName", deptService.selectById(deptDo.getParentId()).getName());
                model.addAttribute("pId", deptDo.getParentId());
            } else if (deptDo != null && deptDo.getParentId() == null || 0 == deptDo.getParentId()) {
                model.addAttribute("pName", "根目录");
            }
            model.addAttribute("dept", deptDo);
        } else if (keyValue == null && pId != null) {
            //添加下级菜单
            DeptDo deptDo = deptService.selectById(pId);
            model.addAttribute("pName", deptDo.getName());
            model.addAttribute("pId", pId);
        } else {
            //添加根级目录
            model.addAttribute("pName", "根目录");
        }
        return "sys/dept/add";
    }

    /**
     * add/edit save
     */
    @ResponseBody
    @PostMapping(value = "save")
    public Result save(DeptDo deptDo) {
        return deptService.insert(deptDo) ? Result.success() : Result.fail();
    }

    /**
     * 删除
     */
    @ResponseBody
    @PostMapping(value = "remove")
    public Result remove(Long id) {
        List<DeptDo> list = deptService.selectList(new EntityWrapper<DeptDo>().eq("parentId", id));
        if (list != null && list.size() > 0) {
            return Result.build(-1, "该部门目录下有子部门，删除失败!", null);
        } else {
            deptService.deleteById(id);
            return Result.success();
        }
    }


    /**
     * tree页面
     */
    @RequestMapping(value = "treeView")
    public String treeView() {
        return "sys/dept/deptTree";
    }

    /**
     * 部门树
     *
     * @return list
     */
    @ResponseBody
    @GetMapping(value = "deptTree")
    public List<Map<String, Object>> menuTree() {
        return deptService.deptTree();
    }


}
