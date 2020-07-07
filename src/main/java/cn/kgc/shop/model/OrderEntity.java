package cn.kgc.shop.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author lx
 *    Order实体类
 * @date 2020-06-28 16:19:19
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class OrderEntity implements Serializable{

	  private static final long serialVersionUID = 1L;
	
	/**
	* 订单编号
	*/
	  private Long orderId;
	/**
	* 品种数
	*/
	  private Integer bNumber;
	/**
	* 用户名
	*/
	  private String userName;
	/**
	* 收货人
	*/
	  private String recevieName;
	/**
	* 收货地址
	*/
	  private String address;
	/**
	* 联系电话
	*/
	  private String tel;
	/**
	 * 订单日期
	 */
      @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss" ,timezone = "GMT+8")
	  private Date orderDate;
	/**
	* 备注
	*/
	  private String bz;

	/**
	 * 订单详情
	 */
	private List<OrderDetailEntity> detailList;

	public List<OrderDetailEntity> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<OrderDetailEntity> detailList) {
		this.detailList = detailList;
	}

	/**
	   * 设置：订单编号
	   */
	  public void setOrderId(Long orderId) {
		  this.orderId = orderId;
	  }
	  /**
	   * 获取：订单编号
	   */
	  public Long getOrderId() {
	   	  return orderId;
	  }
	  /**
	   * 设置：品种数
	   */
	  public void setBNumber(Integer bNumber) {
		  this.bNumber = bNumber;
	  }
	  /**
	   * 获取：品种数
	   */
	  public Integer getBNumber() {
	   	  return bNumber;
	  }
	  /**
	   * 设置：用户名
	   */
	  public void setUserName(String userName) {
		  this.userName = userName;
	  }
	  /**
	   * 获取：用户名
	   */
	  public String getUserName() {
	   	  return userName;
	  }
	  /**
	   * 设置：收货人
	   */
	  public void setRecevieName(String recevieName) {
		  this.recevieName = recevieName;
	  }
	  /**
	   * 获取：收货人
	   */
	  public String getRecevieName() {
	   	  return recevieName;
	  }
	  /**
	   * 设置：收货地址
	   */
	  public void setAddress(String address) {
		  this.address = address;
	  }
	  /**
	   * 获取：收货地址
	   */
	  public String getAddress() {
	   	  return address;
	  }
	  /**
	   * 设置：联系电话
	   */
	  public void setTel(String tel) {
		  this.tel = tel;
	  }
	  /**
	   * 获取：联系电话
	   */
	  public String getTel() {
	   	  return tel;
	  }
	  /**
	   * 设置：订单日期
	   */
	  public void setOrderDate(Date orderDate) {
		  this.orderDate = orderDate;
	  }
	  /**
	   * 获取：订单日期
	   */
	  public Date getOrderDate() {
	   	  return orderDate;
	  }
	  /**
	   * 设置：备注
	   */
	  public void setBz(String bz) {
		  this.bz = bz;
	  }
	  /**
	   * 获取：备注
	   */
	  public String getBz() {
	   	  return bz;
	  }

	 
	  @Override
	  public String toString() {
		  return  ReflectionToStringBuilder.toString(this);
	  }

}
