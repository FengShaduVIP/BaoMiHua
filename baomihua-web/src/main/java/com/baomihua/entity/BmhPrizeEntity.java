package com.baomihua.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-10-02 17:16:52
 */
public class BmhPrizeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//奖品名称
	private String name;
	//奖品图片地址
	private String picUrl;
	//排序
	private Integer sort;
	//创建人
	private String userId;
	//创建人名称
	private String userName;
	//创建时间
	private Integer createTime;
	//是否已删除（1：删除 0：未删除）
	private Integer isDel;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：奖品名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：奖品名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：奖品图片地址
	 */
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	/**
	 * 获取：奖品图片地址
	 */
	public String getPicUrl() {
		return picUrl;
	}
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：创建人
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：创建人
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：创建人名称
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：创建人名称
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Integer getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：是否已删除（1：删除 0：未删除）
	 */
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	/**
	 * 获取：是否已删除（1：删除 0：未删除）
	 */
	public Integer getIsDel() {
		return isDel;
	}
}
