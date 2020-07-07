package cn.kgc.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import cn.kgc.shop.model.OrderDetailEntity;
 
/**
 * 
 * @author lx
 *   OrderDetail控制器
 * @date 2020-06-28 16:19:18
 */
@Controller
@RequestMapping("/orderdetail")
public class OrderDetailController extends BaseController<OrderDetailEntity>{
	
	/**
	 * 页面jsp
	 */
	@RequestMapping("/page")
	public String page(){
		return "orderdetail";
	}

    /**
     * 页面html
     */
    @RequestMapping("/html")
    public String html(){
        return "redirect:/html/orderdetail.html";
    }
}
