package com.baomihua.controller;

import java.util.List;
import java.util.Map;

import com.baomihua.utils.DateUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomihua.entity.BmhAwardLogEntity;
import com.baomihua.service.BmhAwardLogService;
import com.baomihua.utils.PageUtils;
import com.baomihua.utils.Query;
import com.baomihua.utils.R;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-10-06 19:00:51
 */
@RestController
@RequestMapping("bmhawardlog")
public class BmhAwardLogController {
	@Autowired
	private BmhAwardLogService bmhAwardLogService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("bmhawardlog:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<BmhAwardLogEntity> bmhAwardLogList = bmhAwardLogService.queryList(query);

		int total = bmhAwardLogService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(bmhAwardLogList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("bmhawardlog:info")
	public R info(@PathVariable("id") String id){
		BmhAwardLogEntity bmhAwardLog = bmhAwardLogService.queryObject(id);
		
		return R.ok().put("bmhAwardLog", bmhAwardLog);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("bmhawardlog:save")
	public R save(@RequestBody BmhAwardLogEntity bmhAwardLog){
		bmhAwardLogService.save(bmhAwardLog);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("bmhawardlog:update")
	public R update(@RequestBody BmhAwardLogEntity bmhAwardLog){
		bmhAwardLogService.update(bmhAwardLog);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("bmhawardlog:delete")
	public R delete(@RequestBody String[] ids){
		bmhAwardLogService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
