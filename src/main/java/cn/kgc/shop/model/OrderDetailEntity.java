package cn.kgc.shop.model;

import java.io.Serializable;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author lx
 *    OrderDetail实体类
 * @date 2020-06-28 16:19:18
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class OrderDetailEntity implements Serializable{

	  private static final long serialVersionUID = 1L;
	
	/**
	* id号
	*/
	  private Long id;
	/**
	* 订单id
	*/
	  private Long orderId;
	/**
	* 商品id
	*/
	  private Long goodsId;
	/**
	* 价格
	*/
	  private Double price;
	/**
	* 数量
	*/
	  private Integer number;

	/**
	 * 自己添加的
	 * 商品名称
	 */
	private String goodName;

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	/**
	   * 设置：id号
	   */
	  public void setId(Long id) {
		  this.id = id;
	  }
	  /**
	   * 获取：id号
	   */
	  public Long getId() {
	   	  return id;
	  }
	  /**
	   * 设置：订单id
	   */
	  public void setOrderId(Long orderId) {
		  this.orderId = orderId;
	  }
	  /**
	   * 获取：订单id
	   */
	  public Long getOrderId() {
	   	  return orderId;
	  }
	  /**
	   * 设置：商品id
	   */
	  public void setGoodsId(Long goodsId) {
		  this.goodsId = goodsId;
	  }
	  /**
	   * 获取：商品id
	   */
	  public Long getGoodsId() {
	   	  return goodsId;
	  }
	  /**
	   * 设置：价格
	   */
	  public void setPrice(Double price) {
		  this.price = price;
	  }
	  /**
	   * 获取：价格
	   */
	  public Double getPrice() {
	   	  return price;
	  }
	  /**
	   * 设置：数量
	   */
	  public void setNumber(Integer number) {
		  this.number = number;
	  }
	  /**
	   * 获取：数量
	   */
	  public Integer getNumber() {
	   	  return number;
	  }

	 
	  @Override
	  public String toString() {
		  return  ReflectionToStringBuilder.toString(this);
	  }

}
