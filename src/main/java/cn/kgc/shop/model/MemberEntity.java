package cn.kgc.shop.model;

import java.io.Serializable;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author lx
 *    Member实体类
 * @date 2020-06-28 16:19:19
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class MemberEntity implements Serializable{

	  private static final long serialVersionUID = 1L;
	
	/**
	* 会员ID属性
	*/
	  private Integer memberId;
	/**
	* 账户属性
	*/
	  private String userName;
	/**
	* 真实姓名属性
	*/
	  private String trueName;
	/**
	* 密码属性
	*/
	  private String pwd;
	/**
	* 所在城市属性
	*/
	  private String city;
	/**
	* 地址属性
	*/
	  private String address;
	/**
	* 邮编属性
	*/
	  private String postCode;
	/**
	* 证件号码属性
	*/
	  private String cardNo;
	/**
	* 证件类型属性
	*/
	  private String cardType;
	/**
	* 
	*/
	  private Integer grade;
	/**
	* 
	*/
	  private Double amount;
	/**
	* 联系电话属性
	*/
	  private String tel;
	/**
	* 邮箱属性
	*/
	  private String email;
	/**
	* 
	*/
	  private Integer freeze;

	  /**
	   * 设置：会员ID属性
	   */
	  public void setMemberId(Integer memberId) {
		  this.memberId = memberId;
	  }
	  /**
	   * 获取：会员ID属性
	   */
	  public Integer getMemberId() {
	   	  return memberId;
	  }
	  /**
	   * 设置：账户属性
	   */
	  public void setUserName(String userName) {
		  this.userName = userName;
	  }
	  /**
	   * 获取：账户属性
	   */
	  public String getUserName() {
	   	  return userName;
	  }
	  /**
	   * 设置：真实姓名属性
	   */
	  public void setTrueName(String trueName) {
		  this.trueName = trueName;
	  }
	  /**
	   * 获取：真实姓名属性
	   */
	  public String getTrueName() {
	   	  return trueName;
	  }
	  /**
	   * 设置：密码属性
	   */
	  public void setPwd(String pwd) {
		  this.pwd = pwd;
	  }
	  /**
	   * 获取：密码属性
	   */
	  public String getPwd() {
	   	  return pwd;
	  }
	  /**
	   * 设置：所在城市属性
	   */
	  public void setCity(String city) {
		  this.city = city;
	  }
	  /**
	   * 获取：所在城市属性
	   */
	  public String getCity() {
	   	  return city;
	  }
	  /**
	   * 设置：地址属性
	   */
	  public void setAddress(String address) {
		  this.address = address;
	  }
	  /**
	   * 获取：地址属性
	   */
	  public String getAddress() {
	   	  return address;
	  }
	  /**
	   * 设置：邮编属性
	   */
	  public void setPostCode(String postCode) {
		  this.postCode = postCode;
	  }
	  /**
	   * 获取：邮编属性
	   */
	  public String getPostCode() {
	   	  return postCode;
	  }
	  /**
	   * 设置：证件号码属性
	   */
	  public void setCardNo(String cardNo) {
		  this.cardNo = cardNo;
	  }
	  /**
	   * 获取：证件号码属性
	   */
	  public String getCardNo() {
	   	  return cardNo;
	  }
	  /**
	   * 设置：证件类型属性
	   */
	  public void setCardType(String cardType) {
		  this.cardType = cardType;
	  }
	  /**
	   * 获取：证件类型属性
	   */
	  public String getCardType() {
	   	  return cardType;
	  }
	  /**
	   * 设置：
	   */
	  public void setGrade(Integer grade) {
		  this.grade = grade;
	  }
	  /**
	   * 获取：
	   */
	  public Integer getGrade() {
	   	  return grade;
	  }
	  /**
	   * 设置：
	   */
	  public void setAmount(Double amount) {
		  this.amount = amount;
	  }
	  /**
	   * 获取：
	   */
	  public Double getAmount() {
	   	  return amount;
	  }
	  /**
	   * 设置：联系电话属性
	   */
	  public void setTel(String tel) {
		  this.tel = tel;
	  }
	  /**
	   * 获取：联系电话属性
	   */
	  public String getTel() {
	   	  return tel;
	  }
	  /**
	   * 设置：邮箱属性
	   */
	  public void setEmail(String email) {
		  this.email = email;
	  }
	  /**
	   * 获取：邮箱属性
	   */
	  public String getEmail() {
	   	  return email;
	  }
	  /**
	   * 设置：
	   */
	  public void setFreeze(Integer freeze) {
		  this.freeze = freeze;
	  }
	  /**
	   * 获取：
	   */
	  public Integer getFreeze() {
	   	  return freeze;
	  }

	 
	  @Override
	  public String toString() {
		  return  ReflectionToStringBuilder.toString(this);
	  }

}
