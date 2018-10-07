package com.baomihua.dao;

import com.baomihua.entity.BmhOrderManageEntity;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-10-04 14:08:32
 */
public interface BmhOrderManageDao extends BaseDao<BmhOrderManageEntity> {

    List<BmhOrderManageEntity> queryListByPhoneNum(String phoneNum);
}
