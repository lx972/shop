package cn.kgc.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import cn.kgc.shop.model.SupertypeEntity;
 
/**
 * 
 * @author lx
 *   Supertype控制器
 * @date 2020-06-28 16:19:19
 */
@Controller
@RequestMapping("/supertype")
public class SupertypeController extends BaseController<SupertypeEntity>{
	
	/**
	 * 页面jsp
	 */
	@RequestMapping("/page")
	public String page(){
		return "supertype";
	}

    /**
     * 页面html
     */
    @RequestMapping("/html")
    public String html(){
        return "redirect:/html/supertype.html";
    }
}
