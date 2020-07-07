package cn.kgc.shop.mapper;
import org.springframework.stereotype.Repository;
import cn.kgc.shop.model.OrderDetailEntity;

import java.util.List;

/**
 * 
 * @author lx
 *    OrderDetailMapper层
 * @date 2020-06-28 16:19:18
 */
@Repository
public interface OrderDetailMapper extends BaseMapper<OrderDetailEntity> {


    /**
     * 根据订单编号查询订单信息
     * @param orderId
     * @return
     * @throws Exception
     */
    List<OrderDetailEntity> queryOrderDetailListByOrderId(Integer orderId)throws Exception;
	
}
