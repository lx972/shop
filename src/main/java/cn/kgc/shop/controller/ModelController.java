package cn.kgc.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author lx
 *   页面跳转控制器
 * @date 2020-01-05 15:52:54
 */
@Controller
@RequestMapping("/model")
public class ModelController {
	
	/**
	 * 去登陆页面
	 */
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "front/login";
	}

	/**
	 * 去注册页面
	 */
	@RequestMapping("/toRegister")
	public String toRegister(){
		return "front/register";
	}

	/**
	 * 去首页
	 */
	@RequestMapping("/toIndex")
	public String toIndex(){
		return "front/index";
	}


	/**
	 * 去购物车页面
	 */
	@RequestMapping("/toGoodCar")
	public String toGoodCar(){
		return "front/good-car";
	}


	/**
	 * 去订单页面
	 */
	@RequestMapping("/toOrder")
	public String toOrder(){
		return "front/order";
	}

	/**
	 * 去修改用户信息页面
	 */
	@RequestMapping("/toModifyMember")
	public String toModifyMember(){
		return "front/modifyMember";
	}


	/**
	 * 去搜索结果页面
	 */
	@RequestMapping("/toSearchResult")
	public String toSearchResult(String goodName, HttpServletRequest request){
		request.setAttribute("goodName",goodName);
		return "front/search_result";
	}

	/**
	 * 去商品分类列表页面
	 */
	@RequestMapping("/toGoodList")
	public String toGoodList(String superType, HttpServletRequest request){
		request.setAttribute("superType",superType);
		return "front/goodList";
	}


	/**
	 * 去商品详情页面
	 */
	@RequestMapping("/toGoodDetail")
	public String toGoodDetail(Long goodsId, HttpServletRequest request){
		request.setAttribute("goodsId",goodsId);
		return "front/goodDetail";
	}


}
