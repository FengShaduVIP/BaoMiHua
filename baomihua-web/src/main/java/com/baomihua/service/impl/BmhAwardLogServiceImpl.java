package com.baomihua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomihua.dao.BmhAwardLogDao;
import com.baomihua.entity.BmhAwardLogEntity;
import com.baomihua.service.BmhAwardLogService;



@Service("bmhAwardLogService")
public class BmhAwardLogServiceImpl implements BmhAwardLogService {
	@Autowired
	private BmhAwardLogDao bmhAwardLogDao;
	
	@Override
	public BmhAwardLogEntity queryObject(String id){
		return bmhAwardLogDao.queryObject(id);
	}
	
	@Override
	public List<BmhAwardLogEntity> queryList(Map<String, Object> map){
		return bmhAwardLogDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return bmhAwardLogDao.queryTotal(map);
	}
	
	@Override
	public void save(BmhAwardLogEntity bmhAwardLog){
		bmhAwardLogDao.save(bmhAwardLog);
	}
	
	@Override
	public void update(BmhAwardLogEntity bmhAwardLog){
		bmhAwardLogDao.update(bmhAwardLog);
	}
	
	@Override
	public void delete(String id){
		bmhAwardLogDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		bmhAwardLogDao.deleteBatch(ids);
	}

	@Override
	public List<BmhAwardLogEntity> queryAwardLoglist() {
		return bmhAwardLogDao.queryAwardLoglist();
	}

}
