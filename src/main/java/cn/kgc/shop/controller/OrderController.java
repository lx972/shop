package cn.kgc.shop.controller;

import cn.kgc.shop.model.GoodsEntity;
import cn.kgc.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import cn.kgc.shop.model.OrderEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author lx
 *   Order控制器
 * @date 2020-06-28 16:19:19
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController<OrderEntity>{

	@Autowired
	private OrderService orderService;

	/**
	 * 生成订单
	 * @param orderEntity
	 * @param session
	 * @return
	 */
	@RequestMapping("/addGoodOrder")
	@ResponseBody
	public Map<String,Object> addGoodOrder(OrderEntity orderEntity, HttpSession session){
		try {
			String s = orderService.addGoodOrder(orderEntity, session);
			return putMsgToJsonString(SUCCESSCODE,s,FAILCOUNT,null);
		} catch (Exception e) {
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}
	}


	/**
	 * 查询订单信息
	 * @param session
	 * @return
	 */
	@RequestMapping("/selectOrderInfo")
	@ResponseBody
	public Map<String,Object> selectOrderInfo( HttpSession session){
		try {
			map = orderService.selectOrderInfo(session);
			map.put("code",SUCCESSCODE);
			map.put("msg",SUCCESS);
			map.put("count",FAILCOUNT);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}
	}



}
