package cn.kgc.shop.mapper;
import org.springframework.stereotype.Repository;
import cn.kgc.shop.model.GoodsEntity;

import java.util.List;

/**
 * 
 * @author lx
 *    GoodsMapper层
 * @date 2020-06-28 16:19:19
 */
@Repository
public interface GoodsMapper extends BaseMapper<GoodsEntity> {

    /**
     * 查询前两条热门商品信息
     * @return
     * @throws Exception
     */
    List<GoodsEntity> getHitGoods() throws Exception;



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
     * @param superType
     * @return
     * @throws Exception
     */
    List<GoodsEntity> getLeftHotGoods(Integer superType) throws Exception;


    /**
     * 商品名模糊查询
     * @param goodName
     * @return
     * @throws Exception
     */
    List<GoodsEntity> getGoodByGoodName(String goodName) throws Exception;

    /**
     * 查询分类后全部商品信息
     * @param superType
     * @return
     * @throws Exception
     */
    List<GoodsEntity> getAllGoodsByOne(Integer superType) throws Exception;
}
