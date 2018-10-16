package com.baomihua.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018/10/16 21:40:16
 */
public class BmhAwardRuleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//排序
	private Integer sort;
	//规则内容
	private String context;
	//
	private Integer createTime;
	//所有者
	private String createUser;
	//
	private Integer updateTime;
	//抽奖id
	private String awardId;

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
	 * 设置：规则内容
	 */
	public void setContext(String context) {
		this.context = context;
	}
	/**
	 * 获取：规则内容
	 */
	public String getContext() {
		return context;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Integer getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：所有者
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：所有者
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Integer getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：抽奖id
	 */
	public void setAwardId(String awardId) {
		this.awardId = awardId;
	}
	/**
	 * 获取：抽奖id
	 */
	public String getAwardId() {
		return awardId;
	}
}
