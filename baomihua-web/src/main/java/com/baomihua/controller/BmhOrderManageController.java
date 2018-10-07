package com.baomihua.controller;

import java.util.List;
import java.util.Map;

import com.baomihua.entity.SysUserEntity;
import com.baomihua.utils.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomihua.entity.BmhOrderManageEntity;
import com.baomihua.service.BmhOrderManageService;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-10-04 14:02:20
 */
@RestController
@RequestMapping("bmhordermanage")
public class BmhOrderManageController {
	@Autowired
	private BmhOrderManageService bmhOrderManageService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("bmhordermanage:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<BmhOrderManageEntity> bmhOrderManageList = bmhOrderManageService.queryList(query);
		int total = bmhOrderManageService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(bmhOrderManageList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("bmhordermanage:info")
	public R info(@PathVariable("id") String id){
		BmhOrderManageEntity bmhOrderManage = bmhOrderManageService.queryObject(id);
		
		return R.ok().put("bmhOrderManage", bmhOrderManage);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("bmhordermanage:save")
	public R save(@RequestBody BmhOrderManageEntity bmhOrderManage){
		SysUserEntity user =  ShiroUtils.getUserEntity();
		bmhOrderManage.setIsDel(0);
		bmhOrderManage.setCreateUser(user.getUsername());
		bmhOrderManage.setCreateTime(UploadUtils.getNowTimestamp());
		bmhOrderManageService.save(bmhOrderManage);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("bmhordermanage:update")
	public R update(@RequestBody BmhOrderManageEntity bmhOrderManage){
		SysUserEntity user =  ShiroUtils.getUserEntity();
		bmhOrderManage.setIsDel(0);
		bmhOrderManage.setCreateUser(user.getUsername());
		bmhOrderManage.setCreateTime(UploadUtils.getNowTimestamp());
		bmhOrderManageService.update(bmhOrderManage);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("bmhordermanage:delete")
	public R delete(@RequestBody String[] ids){
		bmhOrderManageService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
