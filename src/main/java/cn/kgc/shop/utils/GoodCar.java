package cn.kgc.shop.utils;

import java.io.Serializable;
import java.util.List;

/**
 * cn.kgc.shop.utils
 *
 * @Author Administrator
 * @date 16:55
 */
public class GoodCar implements Serializable {
    private List<Good> cars;

    public List<Good> getCars() {
        return cars;
    }

    public void setCars(List<Good> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "GoodCar{" +
                "cars=" + cars +
                '}';
    }
}
