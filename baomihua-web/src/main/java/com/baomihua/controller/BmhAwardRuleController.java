package com.baomihua.controller;

import java.util.List;
import java.util.Map;

import com.aliyun.oss.common.utils.DateUtil;
import com.baomihua.utils.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomihua.entity.BmhAwardRuleEntity;
import com.baomihua.service.BmhAwardRuleService;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018/10/16 21:40:16
 */
@RestController
@RequestMapping("bmhawardrule")
public class BmhAwardRuleController {
	@Autowired
	private BmhAwardRuleService bmhAwardRuleService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("bmhawardrule:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<BmhAwardRuleEntity> bmhAwardRuleList = bmhAwardRuleService.queryList(query);
		int total = bmhAwardRuleService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(bmhAwardRuleList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("bmhawardrule:info")
	public R info(@PathVariable("id") String id){
		BmhAwardRuleEntity bmhAwardRule = bmhAwardRuleService.queryObject(id);
		
		return R.ok().put("bmhAwardRule", bmhAwardRule);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("bmhawardrule:save")
	public R save(@RequestBody BmhAwardRuleEntity bmhAwardRule){
		bmhAwardRule.setCreateUser(ShiroUtils.getUserId()+"");
		bmhAwardRule.setCreateTime(DateUtils.getNowTimestamp());
		bmhAwardRule.setUpdateTime(DateUtils.getNowTimestamp());
		bmhAwardRuleService.save(bmhAwardRule);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("bmhawardrule:update")
	public R update(@RequestBody BmhAwardRuleEntity bmhAwardRule){
		bmhAwardRule.setUpdateTime(DateUtils.getNowTimestamp());
		bmhAwardRuleService.update(bmhAwardRule);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("bmhawardrule:delete")
	public R delete(@RequestBody String[] ids){
		bmhAwardRuleService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
