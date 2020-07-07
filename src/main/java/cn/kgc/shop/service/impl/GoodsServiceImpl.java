package cn.kgc.shop.service.impl;

import cn.kgc.shop.mapper.GoodsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.kgc.shop.model.GoodsEntity;
import cn.kgc.shop.service.GoodsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author lx
 *    Goods业务层实现类
 * @date 2020-06-28 16:19:19
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsServiceImpl extends BaseServiceImpl<GoodsEntity> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 查询热门商品信息
     * @return
     * @throws Exception
     */
    @Override
    public List<GoodsEntity> getHitGoods() throws Exception {
        List<GoodsEntity>  hitGoods = goodsMapper.getHitGoods();
        return hitGoods;
    }


    /**
     * 查询前12条最新商品信息
     * @return
     * @throws Exception
     */
    @Override
    public List<GoodsEntity> getNewGoods() throws Exception {
        return goodsMapper.getNewGoods();
    }


    /**
     * 查询前12条最新打折商品信息
     * @return
     * @throws Exception
     */
    @Override
    public List<GoodsEntity> getSaleGoods() throws Exception {
        return goodsMapper.getSaleGoods();
    }


    /**
     * 查询分类后的热门商品信息
     * @param superType
     * @return
     * @throws Exception
     */
    @Override
    public List<GoodsEntity> getLeftHotGoods(Integer superType) throws Exception {
        if (superType!=null){
            return goodsMapper.getLeftHotGoods(superType);
        }else {
            return goodsMapper.getHitGoods();
        }

    }


    /**
     * 商品名模糊分页查询
     * @param page
     * @param limit
     * @param goodName
     * @return
     * @throws Exception
     */
    @Override
    public Map<String,Object> getGoodByGoodName(Integer page, Integer limit, String goodName) throws Exception {
        Map<String,Object> map=new HashMap<>();
        PageHelper.startPage(page,limit);
        PageInfo<GoodsEntity> pageInfo = new PageInfo<>(goodsMapper.getGoodByGoodName(goodName));
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        //页数
        map.put("pages",pageInfo.getPages());
        return map;
    }

    /**
     * 查询分类后全部商品信息
     * @param page
     * @param limit
     * @param superType
     * @return
     * @throws Exception
     */
    @Override
    public Map<String,Object> getAllGoodsByOne(Integer page, Integer limit, Integer superType) throws Exception {
        Map<String,Object> map=new HashMap<>();
        PageHelper.startPage(page,limit);
        PageInfo<GoodsEntity> pageInfo = new PageInfo<>(goodsMapper.getAllGoodsByOne(superType));
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        //页数
        map.put("pages",pageInfo.getPages());
        return map;
    }
}
