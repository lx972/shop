package cn.kgc.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import cn.kgc.shop.model.ManagerEntity;
 
/**
 * 
 * @author lx
 *   Manager控制器
 * @date 2020-06-28 16:19:18
 */
@Controller
@RequestMapping("/manager")
public class ManagerController extends BaseController<ManagerEntity>{
	
	/**
	 * 页面jsp
	 */
	@RequestMapping("/page")
	public String page(){
		return "manager";
	}

    /**
     * 页面html
     */
    @RequestMapping("/html")
    public String html(){
        return "redirect:/html/manager.html";
    }
}
