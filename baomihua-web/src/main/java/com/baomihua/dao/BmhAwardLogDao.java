package com.baomihua.dao;

import com.baomihua.entity.BmhAwardLogEntity;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-10-06 19:00:51
 */
public interface BmhAwardLogDao extends BaseDao<BmhAwardLogEntity> {

    List<BmhAwardLogEntity> queryAwardLoglist();
}
