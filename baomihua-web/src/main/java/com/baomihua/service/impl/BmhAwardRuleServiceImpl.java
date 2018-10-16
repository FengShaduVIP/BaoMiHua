package com.baomihua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomihua.dao.BmhAwardRuleDao;
import com.baomihua.entity.BmhAwardRuleEntity;
import com.baomihua.service.BmhAwardRuleService;



@Service("bmhAwardRuleService")
public class BmhAwardRuleServiceImpl implements BmhAwardRuleService {
	@Autowired
	private BmhAwardRuleDao bmhAwardRuleDao;
	
	@Override
	public BmhAwardRuleEntity queryObject(String id){
		return bmhAwardRuleDao.queryObject(id);
	}
	
	@Override
	public List<BmhAwardRuleEntity> queryList(Map<String, Object> map){
		return bmhAwardRuleDao.queryList(map);
	}

	@Override
	public List<Map<String,Object>> queryRuleList(String awardId) {
		return bmhAwardRuleDao.queryRuleList(awardId);
	}

	@Override
	public int queryTotal(Map<String, Object> map){
		return bmhAwardRuleDao.queryTotal(map);
	}
	
	@Override
	public void save(BmhAwardRuleEntity bmhAwardRule){
		bmhAwardRuleDao.save(bmhAwardRule);
	}
	
	@Override
	public void update(BmhAwardRuleEntity bmhAwardRule){
		bmhAwardRuleDao.update(bmhAwardRule);
	}
	
	@Override
	public void delete(String id){
		bmhAwardRuleDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		bmhAwardRuleDao.deleteBatch(ids);
	}
	
}
