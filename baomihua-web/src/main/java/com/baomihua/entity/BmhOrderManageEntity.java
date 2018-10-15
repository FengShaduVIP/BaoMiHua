package com.baomihua.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-10-04 14:08:32
 */
public class BmhOrderManageEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//快递商家
	private String orderTyp;
	//快递单号
	private String orderNum;
	//客户姓名
	private String vipName;
	//手机号
	private String phoneNum;
	//客户省份
	private String province;
	//客户城市
	private String city;
	//创建人
	private String createUser;
	//创建时间
	private Integer createTime;
	//抽奖次数
	private Integer awardTimes;
	//中奖号码
	private  String priceNum;
	//是否已删除
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
	 * 设置：快递商家
	 */
	public void setOrderTyp(String orderTyp) {
		this.orderTyp = orderTyp;
	}
	/**
	 * 获取：快递商家
	 */
	public String getOrderTyp() {
		return orderTyp;
	}
	/**
	 * 设置：快递单号
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：快递单号
	 */
	public String getOrderNum() {
		return orderNum;
	}
	/**
	 * 设置：客户姓名
	 */
	public void setVipName(String vipName) {
		this.vipName = vipName;
	}
	/**
	 * 获取：客户姓名
	 */
	public String getVipName() {
		return vipName;
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
	 * 设置：客户省份
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：客户省份
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：客户城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：客户城市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
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
	 * 设置：抽奖次数
	 */
	public void setAwardTimes(Integer awardTimes) {
		this.awardTimes = awardTimes;
	}
	/**
	 * 获取：抽奖次数
	 */
	public Integer getAwardTimes() {
		return awardTimes;
	}

	public String getPriceNum() {
		return priceNum;
	}

	public void setPriceNum(String priceNum) {
		this.priceNum = priceNum;
	}

	/**
	 * 设置：是否已删除
	 */
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	/**
	 * 获取：是否已删除
	 */
	public Integer getIsDel() {
		return isDel;
	}

	@Override
	public String toString() {
		return "BmhOrderManageEntity{" +
				"id='" + id + '\'' +
				", orderTyp='" + orderTyp + '\'' +
				", orderNum='" + orderNum + '\'' +
				", vipName='" + vipName + '\'' +
				", phoneNum='" + phoneNum + '\'' +
				", province='" + province + '\'' +
				", city='" + city + '\'' +
				", createUser='" + createUser + '\'' +
				", createTime=" + createTime +
				", awardTimes=" + awardTimes +
				", priceNum='" + priceNum + '\'' +
				", isDel=" + isDel +
				'}';
	}
}
