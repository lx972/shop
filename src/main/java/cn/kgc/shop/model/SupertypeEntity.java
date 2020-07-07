package cn.kgc.shop.model;

import java.io.Serializable;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author lx
 *    Supertype实体类
 * @date 2020-06-28 16:19:19
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class SupertypeEntity implements Serializable{

	  private static final long serialVersionUID = 1L;
	
	/**
	* id号
	*/
	  private Integer superId;
	/**
	* 分类名称
	*/
	  private String typeName;

	  /**
	   * 设置：id号
	   */
	  public void setSuperId(Integer superId) {
		  this.superId = superId;
	  }
	  /**
	   * 获取：id号
	   */
	  public Integer getSuperId() {
	   	  return superId;
	  }
	  /**
	   * 设置：分类名称
	   */
	  public void setTypeName(String typeName) {
		  this.typeName = typeName;
	  }
	  /**
	   * 获取：分类名称
	   */
	  public String getTypeName() {
	   	  return typeName;
	  }

	 
	  @Override
	  public String toString() {
		  return  ReflectionToStringBuilder.toString(this);
	  }

}
