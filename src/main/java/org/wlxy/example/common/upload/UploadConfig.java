package org.wlxy.example.common.upload;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @program: example
 * @ClassName UploadConfig
 * @description:
 * @author: Gorgeous
 * @create: 2019-10-25 11:29
 */

/**
 * @Description: 自定义资源映射
 *     设置虚拟路径，访问绝对路径下资源
 */
@Configuration
@ComponentScan
public class UploadConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("file:///"+"D:/img/");
    }
}
