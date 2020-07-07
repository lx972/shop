package cn.kgc.shop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.kgc.shop.model.SupertypeEntity;
import cn.kgc.shop.service.SupertypeService;

/**
 * 
 * @author lx
 *    Supertype业务层实现类
 * @date 2020-06-28 16:19:19
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SupertypeServiceImpl extends BaseServiceImpl<SupertypeEntity> implements SupertypeService {
	
}
