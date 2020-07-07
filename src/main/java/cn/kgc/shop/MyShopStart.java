package cn.kgc.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * cn.kgc.shop
 *
 * @Author Administrator
 * @date 15:45
 */

@SpringBootApplication
@MapperScan("cn.kgc.shop.mapper")
public class MyShopStart {
    public static void main(String[] args) {
        SpringApplication.run(MyShopStart.class,args);
    }
}
