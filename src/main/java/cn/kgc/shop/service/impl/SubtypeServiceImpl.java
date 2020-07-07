package cn.kgc.shop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.kgc.shop.model.SubtypeEntity;
import cn.kgc.shop.service.SubtypeService;

/**
 * 
 * @author lx
 *    Subtype业务层实现类
 * @date 2020-06-28 16:19:19
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SubtypeServiceImpl extends BaseServiceImpl<SubtypeEntity> implements SubtypeService {
	
}
