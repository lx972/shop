package cn.kgc.shop.service;

import cn.kgc.shop.model.GoodsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author lx
 *    Goods业务层接口
 * @date 2020-06-28 16:19:19
 */
public interface GoodsService extends BaseService<GoodsEntity>{

    /**
     * 查询热门商品信息
     * @return
     * @throws Exception
     */
    List<GoodsEntity> getHitGoods()throws Exception;


    /**
     * 查询前12条最新商品信息
     * @return
     * @throws Exception
     */
    List<GoodsEntity> getNewGoods() throws Exception;


    /**
     * 查询前12条最新打折商品信息
     * @return
     * @throws Exception
     */
    List<GoodsEntity> getSaleGoods() throws Exception;



    /**
     * 查询分类后的热门商品信息
     * @return
     * @throws Exception
     */
    List<GoodsEntity> getLeftHotGoods(Integer superType) throws Exception;


    /**
     * 商品名模糊分页查询
     * @return
     * @throws Exception
     */
    Map<String,Object> getGoodByGoodName(Integer page,Integer limit,String goodName) throws Exception;


    /**
     * 查询分类后全部商品信息
     * @return
     * @throws Exception
     */
    Map<String,Object> getAllGoodsByOne(Integer page,Integer limit,Integer superType) throws Exception;


}
