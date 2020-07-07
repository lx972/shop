package cn.kgc.shop.model;

import java.io.Serializable;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author lx
 *    Manager实体类
 * @date 2020-06-28 16:19:18
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ManagerEntity implements Serializable{

	  private static final long serialVersionUID = 1L;
	
	/**
	* id号
	*/
	  private Integer id;
	/**
	* 管理员名称
	*/
	  private String manager;
	/**
	* 密码
	*/
	  private String pwd;

	  /**
	   * 设置：id号
	   */
	  public void setId(Integer id) {
		  this.id = id;
	  }
	  /**
	   * 获取：id号
	   */
	  public Integer getId() {
	   	  return id;
	  }
	  /**
	   * 设置：管理员名称
	   */
	  public void setManager(String manager) {
		  this.manager = manager;
	  }
	  /**
	   * 获取：管理员名称
	   */
	  public String getManager() {
	   	  return manager;
	  }
	  /**
	   * 设置：密码
	   */
	  public void setPwd(String pwd) {
		  this.pwd = pwd;
	  }
	  /**
	   * 获取：密码
	   */
	  public String getPwd() {
	   	  return pwd;
	  }

	 
	  @Override
	  public String toString() {
		  return  ReflectionToStringBuilder.toString(this);
	  }

}
