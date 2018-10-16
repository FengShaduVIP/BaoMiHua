package com.baomihua.dao;

import com.baomihua.entity.BmhAwardRuleEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018/10/16 21:40:16
 */
public interface BmhAwardRuleDao extends BaseDao<BmhAwardRuleEntity> {

    List<Map<String,Object>> queryRuleList(String awardId);
	
}
