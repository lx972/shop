package cn.kgc.shop.configurerAdapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * cn.kgc.shop.configurerAdapter
 *
 * @Author Administrator
 * @date 17:40
 */
@Configuration
public class ToIndex extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("front/index");
    }
}
