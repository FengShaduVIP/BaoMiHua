package com.baomihua.controller;

import java.util.List;
import java.util.Map;

import com.baomihua.entity.SysUserEntity;
import com.baomihua.entity.UserEntity;
import com.baomihua.utils.*;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomihua.entity.BmhPrizeEntity;
import com.baomihua.service.BmhPrizeService;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-10-02 17:16:52
 */
@RestController
@RequestMapping("bmhprize")
public class BmhPrizeController {

	private static Logger logger = Logger.getLogger(BmhPrizeController.class);
	@Autowired
	private BmhPrizeService bmhPrizeService;


	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("bmhprize:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BmhPrizeEntity> bmhPrizeList = bmhPrizeService.queryList(query);
		String servicePath = "";
		for (int i=0;i<bmhPrizeList.size();i++){
			BmhPrizeEntity obj = bmhPrizeList.get(i);
			String picUrl = servicePath + obj.getPicUrl();
			obj.setPicUrl(picUrl);
		}
		int total = bmhPrizeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(bmhPrizeList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("bmhprize:info")
	public R info(@PathVariable("id") String id){
		BmhPrizeEntity bmhPrize = bmhPrizeService.queryObject(id);
		
		return R.ok().put("bmhPrize", bmhPrize);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("bmhprize:save")
	public R save(HttpServletRequest request){
		SysUserEntity user = ShiroUtils.getUserEntity();
		try {
			BmhPrizeEntity bmhPrize = new BmhPrizeEntity();
			bmhPrize.setCreateTime(DateUtils.getNowTimestamp());
			bmhPrize.setName(request.getParameter("name"));
			bmhPrize.setSort(Integer.parseInt(request.getParameter("sort")+""));
			bmhPrize.setIsDel(Integer.parseInt(request.getParameter("isDel")+""));
			bmhPrize.setUserId(user.getUserId()+"");
			bmhPrize.setUserId(user.getUsername());
			String filePath = "upload/img/pricePic";
			String picUrl = ImageUploadUtil.upload(request,filePath);
			bmhPrize.setPicUrl(filePath+"/"+picUrl);
			bmhPrizeService.save(bmhPrize);
		}catch (Exception e){
			e.printStackTrace();
		}

		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("bmhprize:update")
	public R update(@RequestBody BmhPrizeEntity bmhPrize){
		bmhPrizeService.update(bmhPrize);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("bmhprize:delete")
	public R delete(@RequestBody String[] ids){
		bmhPrizeService.deleteBatch(ids);
		return R.ok();
	}
	
}
