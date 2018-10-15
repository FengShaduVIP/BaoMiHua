package com.baomihua.service.impl;

import com.baomihua.entity.BmhAwardLogEntity;
import com.baomihua.entity.BmhPrizeEntity;
import com.baomihua.service.BmhAwardLogService;
import com.baomihua.service.BmhPrizeService;
import com.baomihua.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomihua.dao.BmhOrderManageDao;
import com.baomihua.entity.BmhOrderManageEntity;
import com.baomihua.service.BmhOrderManageService;



@Service("bmhOrderManageService")
public class BmhOrderManageServiceImpl implements BmhOrderManageService {

	private static final Logger logger = LoggerFactory.getLogger(BmhOrderManageServiceImpl.class);
	@Autowired
	private BmhOrderManageDao bmhOrderManageDao;
	@Autowired
	private BmhPrizeService bmhPrizeService;
	@Autowired
	private BmhAwardLogService bmhAwardLogService;
	
	@Override
	public BmhOrderManageEntity queryObject(String id){
		return bmhOrderManageDao.queryObject(id);
	}
	
	@Override
	public List<BmhOrderManageEntity> queryList(Map<String, Object> map){
		return bmhOrderManageDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return bmhOrderManageDao.queryTotal(map);
	}
	
	@Override
	public void save(BmhOrderManageEntity bmhOrderManage){
		bmhOrderManageDao.save(bmhOrderManage);
	}
	
	@Override
	public void update(BmhOrderManageEntity bmhOrderManage){
		bmhOrderManageDao.update(bmhOrderManage);
	}
	
	@Override
	public void delete(String id){
		bmhOrderManageDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		bmhOrderManageDao.deleteBatch(ids);
	}

	@Override
	public Map<String, Object> checkAeardTimes(String phoneNum) {
		Map<String,Object> map = new HashMap();
		List<BmhOrderManageEntity> list = bmhOrderManageDao.queryListByPhoneNum(phoneNum);
		if(list!=null&&list.size()>0){
			BmhOrderManageEntity obj = list.get(0);
			int times = obj.getAwardTimes();
			if(times>0){
				BmhAwardLogEntity logObj = new BmhAwardLogEntity();
				logObj.setAwardId(obj.getId());
				logObj.setCreateTime(DateUtils.getNowTimestamp());
				logObj.setPhoneNum(phoneNum);
				logObj.setPriceNum(obj.getPriceNum());
				BmhPrizeEntity priceObj = bmhPrizeService.queryObjectByNum(obj.getPriceNum());
				if(priceObj!=null){
					logObj.setPriceName(priceObj.getName());
				}
				logObj.setUserName(obj.getVipName());
				bmhAwardLogService.save(logObj);
				logger.info("保存抽奖记录成功----"+logObj.toString());
				map.put("times",times);
				map.put("data",true);
				map.put("priceNum",obj.getPriceNum());
				obj.setAwardTimes(times-1);
				bmhOrderManageDao.update(obj);
				logger.info("减去抽奖次数成功："+obj.toString());
				return map;
			}else{
				logger.info("该手机号码抽奖次数为0 ："+phoneNum);
				map.put("times",0);
				map.put("data",true);
				return map;
			}
		}else{
			logger.info("该手机号码没有参与过抽奖活动："+phoneNum);
			map.put("data",false);
			return map;
		}
	}

}
