package cn.kgc.shop.model;

import java.io.Serializable;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author lx
 *    Subtype实体类
 * @date 2020-06-28 16:19:19
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class SubtypeEntity implements Serializable{

	  private static final long serialVersionUID = 1L;
	
	/**
	* id号
	*/
	  private Integer subId;
	/**
	* 父类id号
	*/
	  private Integer superType;
	/**
	* 分类名称
	*/
	  private String typeName;

	  /**
	   * 设置：id号
	   */
	  public void setSubId(Integer subId) {
		  this.subId = subId;
	  }
	  /**
	   * 获取：id号
	   */
	  public Integer getSubId() {
	   	  return subId;
	  }
	  /**
	   * 设置：父类id号
	   */
	  public void setSuperType(Integer superType) {
		  this.superType = superType;
	  }
	  /**
	   * 获取：父类id号
	   */
	  public Integer getSuperType() {
	   	  return superType;
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
