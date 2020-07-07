package cn.kgc.shop.model;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author lx
 *    Goods实体类
 * @date 2020-06-28 16:19:19
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class GoodsEntity implements Serializable{

	  private static final long serialVersionUID = 1L;
	
	/**
	* 商品id
	*/
	  private Long goodsId;
	/**
	* 类别id
	*/
	  private Integer typeId;
	/**
	* 商品名称
	*/
	  private String goodName;
	/**
	* 商品简介
	*/
	  private String introduce;
	/**
	* 定价
	*/
	  private Double price;
	/**
	* 现价
	*/
	  private Double nowPrice;
	/**
	* 图片文件
	*/
	  private String picture;
	/**
	 * 录入时间
	 */
      @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss" ,timezone = "GMT+8")
	  private Date inTime;
	/**
	* 是否新品，1为是，默认0
	*/
	  private Integer newGoods;
	/**
	* 是否特价，1为是，默认0
	*/
	  private Integer sale;
	/**
	* 点击次数
	*/
	  private Integer hit;

	/**
	 * 自己添加属性
	 * 类别名
	 */
	private String typeName;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
	   * 设置：类别id
	   */
	  public void setTypeId(Integer typeId) {
		  this.typeId = typeId;
	  }
	  /**
	   * 获取：类别id
	   */
	  public Integer getTypeId() {
	   	  return typeId;
	  }
	  /**
	   * 设置：商品名称
	   */
	  public void setGoodName(String goodName) {
		  this.goodName = goodName;
	  }
	  /**
	   * 获取：商品名称
	   */
	  public String getGoodName() {
	   	  return goodName;
	  }
	  /**
	   * 设置：商品简介
	   */
	  public void setIntroduce(String introduce) {
		  this.introduce = introduce;
	  }
	  /**
	   * 获取：商品简介
	   */
	  public String getIntroduce() {
	   	  return introduce;
	  }
	  /**
	   * 设置：定价
	   */
	  public void setPrice(Double price) {
		  this.price = price;
	  }
	  /**
	   * 获取：定价
	   */
	  public Double getPrice() {
	   	  return price;
	  }
	  /**
	   * 设置：现价
	   */
	  public void setNowPrice(Double nowPrice) {
		  this.nowPrice = nowPrice;
	  }
	  /**
	   * 获取：现价
	   */
	  public Double getNowPrice() {
	   	  return nowPrice;
	  }
	  /**
	   * 设置：图片文件
	   */
	  public void setPicture(String picture) {
		  this.picture = picture;
	  }
	  /**
	   * 获取：图片文件
	   */
	  public String getPicture() {
	   	  return picture;
	  }
	  /**
	   * 设置：录入时间
	   */
	  public void setInTime(Date inTime) {
		  this.inTime = inTime;
	  }
	  /**
	   * 获取：录入时间
	   */
	  public Date getInTime() {
	   	  return inTime;
	  }
	  /**
	   * 设置：是否新品，1为是，默认0
	   */
	  public void setNewGoods(Integer newGoods) {
		  this.newGoods = newGoods;
	  }
	  /**
	   * 获取：是否新品，1为是，默认0
	   */
	  public Integer getNewGoods() {
	   	  return newGoods;
	  }
	  /**
	   * 设置：是否特价，1为是，默认0
	   */
	  public void setSale(Integer sale) {
		  this.sale = sale;
	  }
	  /**
	   * 获取：是否特价，1为是，默认0
	   */
	  public Integer getSale() {
	   	  return sale;
	  }
	  /**
	   * 设置：点击次数
	   */
	  public void setHit(Integer hit) {
		  this.hit = hit;
	  }
	  /**
	   * 获取：点击次数
	   */
	  public Integer getHit() {
	   	  return hit;
	  }

	 
	  @Override
	  public String toString() {
		  return  ReflectionToStringBuilder.toString(this);
	  }

}
