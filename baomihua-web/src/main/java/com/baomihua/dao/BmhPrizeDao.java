package com.baomihua.dao;

import com.baomihua.entity.BmhPrizeEntity;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-10-02 17:16:52
 */
public interface BmhPrizeDao extends BaseDao<BmhPrizeEntity> {

    List<BmhPrizeEntity> queryAwardList();
}
