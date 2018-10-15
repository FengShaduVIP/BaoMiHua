package com.baomihua.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-10-06 19:00:51
 */
public class BmhAwardLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//中奖者名称
	private String userName;
	//手机号
	private String phoneNum;
	//奖品号码
	private String priceNum;
	//奖品名称
	private String priceName;
	//抽奖时间
	private Integer createTime;
	//抽奖表id
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
	 * 设置：中奖者名称
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：中奖者名称
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	/**
	 * 设置：奖品号码
	 */
	public void setPriceNum(String priceNum) {
		this.priceNum = priceNum;
	}
	/**
	 * 获取：奖品号码
	 */
	public String getPriceNum() {
		return priceNum;
	}
	/**
	 * 设置：奖品名称
	 */
	public void setPriceName(String priceName) {
		this.priceName = priceName;
	}
	/**
	 * 获取：奖品名称
	 */
	public String getPriceName() {
		return priceName;
	}
	/**
	 * 设置：抽奖时间
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：抽奖时间
	 */
	public Integer getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：抽奖表id
	 */
	public void setAwardId(String awardId) {
		this.awardId = awardId;
	}
	/**
	 * 获取：抽奖表id
	 */
	public String getAwardId() {
		return awardId;
	}

	@Override
	public String toString() {
		return "BmhAwardLogEntity{" +
				"id='" + id + '\'' +
				", userName='" + userName + '\'' +
				", phoneNum='" + phoneNum + '\'' +
				", priceNum='" + priceNum + '\'' +
				", priceName='" + priceName + '\'' +
				", createTime=" + createTime +
				", awardId='" + awardId + '\'' +
				'}';
	}
}
