package cn.kgc.shop.service;

import cn.kgc.shop.model.OrderEntity;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 
 * @author lx
 *    Order业务层接口
 * @date 2020-06-28 16:19:19
 */
public interface OrderService extends BaseService<OrderEntity>{


    /**
     * 生成订单
     * @param orderEntity
     * @param session
     * @return
     * @throws Exception
     */
    String addGoodOrder(OrderEntity orderEntity, HttpSession session)throws Exception;


    /**
     * 查询订单信息
     * @param session
     * @return
     * @throws Exception
     */
    Map<String,Object> selectOrderInfo(HttpSession session) throws Exception;
	
}
