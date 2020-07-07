package cn.kgc.shop.controller;

import cn.kgc.shop.service.BaseService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * @author lx
 *    基础控制器层
 * @param <T>
 */
public class BaseController<T> {

	protected Map<String,Object> map = new HashMap<String,Object>();

	protected List<T> list = new ArrayList<T>();

	/**
	 * 访问数据成功的常量
	 */
	protected static final Integer SUCCESSCODE = 0;

	/**
	 * 访问数据失败的常量
	 */
	protected static final Integer FAILCODE = 200;

	/**
	 * 访问数据失败的数据条数
	 */
	protected static final Integer FAILCOUNT = 0;


	/**
	 * 操作成功的常量
	 */
	protected static final String SUCCESS = "success";

	/**
	 * 操作失败的常量
	 */
	protected static final String FAIL = "fail";

	/**
	 * 操作异常的常量
	 */
	protected static final String ERROR = "error";

	/**
	 * 基础业务层对象
	 */
	@Autowired
	protected BaseService<T> baseService;
	/**
	 *
	 * @param code  1 成功  0 失败
	 * @param msg   消息内容
	 * @param count 最大条数
	 * @param data  具体内容
	 * @return
	 */
	public Map<String,Object> putMsgToJsonString(int code,String msg,long count ,Object data){
		map.put("code", code);
		map.put("msg", msg);
		map.put("count", count);
		map.put("data", data);
		return map;
	}



	/**
	 * 根据条件查询数据总条数
	 */
	@RequestMapping("/getTotalByPramas")
	@ResponseBody
	public Map<String, Object> getTotalByPramas(T t){
		try {
			Long totalByPramas = baseService.getTotalByPramas(t);
			return putMsgToJsonString(SUCCESSCODE,SUCCESS,totalByPramas,null);
		} catch (Exception e) {
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}
	}



	/**
	 * 加载（分页） 根据是否存在条件加载
	 */
	@RequestMapping("/listByPramas")
	@ResponseBody
	public Map<String, Object> listByPramas(Integer page,Integer limit,T t){
		try {
			map = baseService.findListByPramas(page, limit, t);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}
	}



	/**
	 * 根据条件条件加载所有
	 */
	@RequestMapping("/allByPramas")
	@ResponseBody
	public Map<String, Object> allByPramas(T t){
		try {
			List<T> allByPramas = baseService.findManyByPramas(t);
			return putMsgToJsonString(SUCCESSCODE,SUCCESS,FAILCOUNT,allByPramas);
		} catch (Exception e) {
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}
	}

	/**
	 * 加载（分页） 根据是否存在条件加载
	 */
	@RequestMapping("/pageByPramas")
	@ResponseBody
	public PageInfo<T> pageByPramas(Integer page, Integer limit, T t){
		try {
			return baseService.findPageByPramas(page,limit,t);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 根据条件查询单个结果
	 * 
	 */
	@RequestMapping("/loadObjectByPramas")
	@ResponseBody
	public Map<String, Object> loadObjectByPramas(T t){
		try {
			T objectByPramas = baseService.findObjectByPramas(t);
			return putMsgToJsonString(SUCCESSCODE,SUCCESS,FAILCOUNT,objectByPramas);
		} catch (Exception e) {
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}	
	} 
	
	/**
	 * 根据条件删除
	 * 
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(T t){
		try {
			String remove = baseService.remove(t);
			return putMsgToJsonString(SUCCESSCODE,remove,FAILCOUNT,null);
		} catch (Exception e) {
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}
	}
	
	/**
	 * 批量删除
	 */
	@RequestMapping("/deletes")
	@ResponseBody
	public Map<String, Object> deletes(Integer[] ids){
		try {
			String s = baseService.removeBatch(ids);
			return putMsgToJsonString(SUCCESSCODE,s,FAILCOUNT,null);
		} catch (Exception e) {
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}
		
	}
	
	/**
	 * 添加
	 */
	 @RequestMapping("/saveT")
	 @ResponseBody
	 public Map<String, Object> saveT(T entity){
		try {
			String save = baseService.save(entity);
			return putMsgToJsonString(SUCCESSCODE,save,FAILCOUNT,null);
		} catch (Exception e) {
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}	 
	 }
	 
	 /**
	 * 修改
	 */
	 @RequestMapping("/updT")
	 @ResponseBody
	 public Map<String, Object> updT(T entity){
		try {
			String upd = baseService.upd(entity);
			return putMsgToJsonString(SUCCESSCODE,upd,FAILCOUNT,null);
		} catch (Exception e) {
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}	 
	 }
	
}
