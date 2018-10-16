package com.baomihua.service;

import com.baomihua.entity.BmhAwardRuleEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018/10/16 21:40:16
 */
public interface BmhAwardRuleService {
	
	BmhAwardRuleEntity queryObject(String id);
	
	List<BmhAwardRuleEntity> queryList(Map<String, Object> map);

	List<Map<String,Object>> queryRuleList(String awardId);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BmhAwardRuleEntity bmhAwardRule);
	
	void update(BmhAwardRuleEntity bmhAwardRule);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
