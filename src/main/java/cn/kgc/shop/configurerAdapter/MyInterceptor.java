package cn.kgc.shop.configurerAdapter;

import cn.kgc.shop.interceptor.MainInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * cn.kgc.shop.configurerAdapter
 *
 * @Author Administrator
 * @date 16:49
 */
@Configuration
public class MyInterceptor extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MainInterceptor())
                .addPathPatterns("/model/**")
                .excludePathPatterns("/model/toLogin")
                .excludePathPatterns("/model/toIndex")
                .excludePathPatterns("/model/toGoodDetail")
                .excludePathPatterns("/model/toGoodList")
                .excludePathPatterns("/model/toRegister")
                .addPathPatterns("/goods/findGoodCar")
                .addPathPatterns("/goods/clearCar");
    }
}
