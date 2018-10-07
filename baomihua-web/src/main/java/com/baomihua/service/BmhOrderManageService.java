package com.baomihua.service;

import com.baomihua.entity.BmhOrderManageEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-10-04 14:02:20
 */
public interface BmhOrderManageService {
	
	BmhOrderManageEntity queryObject(String id);
	
	List<BmhOrderManageEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BmhOrderManageEntity bmhOrderManage);
	
	void update(BmhOrderManageEntity bmhOrderManage);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    Map<String, Object> checkAeardTimes(String phoneNum);
}
