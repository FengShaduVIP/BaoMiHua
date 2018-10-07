package com.baomihua.service;

import com.baomihua.entity.BmhAwardLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-10-06 19:00:51
 */
public interface BmhAwardLogService {
	
	BmhAwardLogEntity queryObject(String id);
	
	List<BmhAwardLogEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BmhAwardLogEntity bmhAwardLog);
	
	void update(BmhAwardLogEntity bmhAwardLog);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    List<BmhAwardLogEntity> queryAwardLoglist();
}
