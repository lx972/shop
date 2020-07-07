package cn.kgc.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import cn.kgc.shop.model.SubtypeEntity;
 
/**
 * 
 * @author lx
 *   Subtype控制器
 * @date 2020-06-28 16:19:19
 */
@Controller
@RequestMapping("/subtype")
public class SubtypeController extends BaseController<SubtypeEntity>{
	
	/**
	 * 页面jsp
	 */
	@RequestMapping("/page")
	public String page(){
		return "subtype";
	}

    /**
     * 页面html
     */
    @RequestMapping("/html")
    public String html(){
        return "redirect:/html/subtype.html";
    }
}
