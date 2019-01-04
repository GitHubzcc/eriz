package com.eriz.module.controller;


import java.util.Arrays;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.eriz.common.annotation.Log;
import com.eriz.common.base.SysController;
import com.eriz.module.domain.ModuleBookDO;
import com.eriz.module.service.ModuleBookService;
import com.eriz.common.util.Result;

/**
 * 
 * <pre>
 * 图书表
 * </pre>
 * <small> 2019-01-04 10:36:42 | eriz</small>
 */
@Controller
@RequestMapping("/eriz/moduleBook")
public class ModuleBookController extends SysController {
	@Autowired
	private ModuleBookService moduleBookService;
	
	@GetMapping(value = "/")
	@RequiresPermissions("eriz:moduleBook:moduleBook")
	public String ModuleBook(){
	    return "eriz/moduleBook/moduleBook";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("eriz:moduleBook:moduleBook")
	public Result list(ModuleBookDO moduleBookDTO){
        Wrapper<ModuleBookDO> wrapper = new EntityWrapper<ModuleBookDO>().orderBy("id", false);
        Page<ModuleBookDO> page = moduleBookService.selectPage(getPage(ModuleBookDO.class), wrapper);
        return Result.success(0, "success", page.getTotal(), page.getRecords());
	}
	
	@GetMapping("/add")
	@RequiresPermissions("eriz:moduleBook:add")
    public String add(){
	    return "eriz/moduleBook/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("eriz:moduleBook:edit")
    public String edit(@PathVariable("id") Long id,Model model){
		ModuleBookDO moduleBook = moduleBookService.selectById(id);
		model.addAttribute("moduleBook", moduleBook);
	    return "eriz/moduleBook/edit";
	}
	
	@Log("添加图书表")
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("eriz:moduleBook:add")
	public Result save( ModuleBookDO moduleBook){
		moduleBookService.insert(moduleBook);
        return Result.success();
	}
	
	@Log("修改图书表")
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("eriz:moduleBook:edit")
	public Result<String>  update( ModuleBookDO moduleBook){
		boolean update = moduleBookService.updateById(moduleBook);
		return update ? Result.success() : Result.fail();
	}
	
	@Log("删除图书表")
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("eriz:moduleBook:remove")
	public Result  remove( Long id){
		moduleBookService.deleteById(id);
        return Result.success();
	}
	
	@Log("批量删除图书表")
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("eriz:moduleBook:batchRemove")
	public Result  remove(@RequestParam("ids[]") Long[] ids){
		moduleBookService.deleteBatchIds(Arrays.asList(ids));
		return Result.success();
	}
	
}
