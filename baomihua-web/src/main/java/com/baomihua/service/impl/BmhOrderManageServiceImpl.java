package com.baomihua.service.impl;

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
	@Autowired
	private BmhOrderManageDao bmhOrderManageDao;
	
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
				times = times-1;
				obj.setAwardTimes(times);
				bmhOrderManageDao.update(obj);
				map.put("data",true);
				map.put("priceNum",obj.getPriceNum());
				return map;
			}else{
				map.put("data",false);
				return map;
			}
		}else{
			map.put("data",false);
			return map;
		}
	}

}
