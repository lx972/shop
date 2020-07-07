package cn.kgc.shop.utils;

import java.io.Serializable;

/**
 * cn.kgc.shop.utils
 *
 * @Author Administrator
 * @date 16:51
 */
public class Good implements Serializable {
    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 商品名称
     */
    private String goodName;

    /**
     * 图片文件
     */
    private String picture;

    /**
     * 现价
     */
    private Double nowPrice;

    /**
     * 数量
     */
    private Integer count;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Double getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(Double nowPrice) {
        this.nowPrice = nowPrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodsId=" + goodsId +
                ", goodName='" + goodName + '\'' +
                ", picture='" + picture + '\'' +
                ", nowPrice=" + nowPrice +
                ", count=" + count +
                '}';
    }
}
