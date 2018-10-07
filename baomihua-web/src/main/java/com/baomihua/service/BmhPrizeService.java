package com.baomihua.service;

import com.baomihua.entity.BmhPrizeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-10-02 17:16:52
 */
public interface BmhPrizeService {
	
	BmhPrizeEntity queryObject(String id);
	
	List<BmhPrizeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BmhPrizeEntity bmhPrize);
	
	void update(BmhPrizeEntity bmhPrize);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    List<BmhPrizeEntity> queryAwardList();
}
