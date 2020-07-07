package cn.kgc.shop.service.impl;

import cn.kgc.shop.mapper.OrderDetailMapper;
import cn.kgc.shop.model.MemberEntity;
import cn.kgc.shop.model.OrderDetailEntity;
import cn.kgc.shop.utils.Good;
import cn.kgc.shop.utils.GoodCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.kgc.shop.model.OrderEntity;
import cn.kgc.shop.service.OrderService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author lx
 *    Order业务层实现类
 * @date 2020-06-28 16:19:19
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl extends BaseServiceImpl<OrderEntity> implements OrderService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private OrderDetailMapper orderDetailMapper;
    /**
     * 生成订单
     * @param orderEntity
     * @param session
     * @return
     * @throws Exception
     */
    @Override
    public String addGoodOrder(OrderEntity orderEntity, HttpSession session) throws Exception {
        //登录用户
        MemberEntity loginUser = (MemberEntity) session.getAttribute("loginUser");
        if (redisTemplate.hasKey(loginUser.getMemberId() + "_" + loginUser.getUserName())){
            orderEntity.setUserName(loginUser.getUserName());
            orderEntity.setOrderDate(new Date());
            ValueOperations vo = redisTemplate.opsForValue();
            GoodCar o = (GoodCar) vo.get(loginUser.getMemberId() + "_" + loginUser.getUserName());
            List<Good> cars = o.getCars();
            orderEntity.setBNumber(cars.size());
            System.out.println(orderEntity);
            baseMapper.insert(orderEntity);
            OrderDetailEntity orderDetailEntity=new OrderDetailEntity();
            for (Good good : cars) {
                orderDetailEntity.setOrderId(orderEntity.getOrderId());
                orderDetailEntity.setGoodsId(good.getGoodsId());
                orderDetailEntity.setNumber(good.getCount());
                orderDetailEntity.setPrice(good.getNowPrice()*good.getCount());
                orderDetailEntity.setId(null);
               orderDetailMapper.insert(orderDetailEntity);
            }
            return SUCCESS;
        }else {
            return FAIL;
        }

    }

    /**
     * 查询订单信息
     * @param session
     * @return
     * @throws Exception
     */
    @Override
    public Map<String,Object> selectOrderInfo(HttpSession session) throws Exception {
        Map<String,Object> map=new HashMap<>();
        //登录用户
        MemberEntity loginUser = (MemberEntity) session.getAttribute("loginUser");
        OrderEntity orderEntity=new OrderEntity();
        orderEntity.setUserName(loginUser.getUserName());
        List<OrderEntity> orderList = baseMapper.queryListByPramas(orderEntity);
        System.out.println(orderList);
        map.put("data",orderList);
        return map;
    }
}
