package cn.kgc.shop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.kgc.shop.model.OrderDetailEntity;
import cn.kgc.shop.service.OrderDetailService;

/**
 * 
 * @author lx
 *    OrderDetail业务层实现类
 * @date 2020-06-28 16:19:18
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetailEntity> implements OrderDetailService {
	
}
