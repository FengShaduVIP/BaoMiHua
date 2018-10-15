package com.baomihua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomihua.dao.BmhPrizeDao;
import com.baomihua.entity.BmhPrizeEntity;
import com.baomihua.service.BmhPrizeService;



@Service("bmhPrizeService")
public class BmhPrizeServiceImpl implements BmhPrizeService {
	@Autowired
	private BmhPrizeDao bmhPrizeDao;
	
	@Override
	public BmhPrizeEntity queryObject(String id){
		return bmhPrizeDao.queryObject(id);
	}

	@Override
	public BmhPrizeEntity queryObjectByNum(String priceNum) {
		return bmhPrizeDao.queryObjectByNum(priceNum);
	}

	@Override
	public List<BmhPrizeEntity> queryList(Map<String, Object> map){
		return bmhPrizeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return bmhPrizeDao.queryTotal(map);
	}
	
	@Override
	public void save(BmhPrizeEntity bmhPrize){
		bmhPrizeDao.save(bmhPrize);
	}
	
	@Override
	public void update(BmhPrizeEntity bmhPrize){
		bmhPrizeDao.update(bmhPrize);
	}
	
	@Override
	public void delete(String id){
		bmhPrizeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		bmhPrizeDao.deleteBatch(ids);
	}

	@Override
	public List<BmhPrizeEntity> queryAwardList() {
		return bmhPrizeDao.queryAwardList();
	}

}
