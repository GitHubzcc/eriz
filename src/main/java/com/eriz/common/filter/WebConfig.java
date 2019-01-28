package com.eriz.common.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 系统web请求配置
 *
 * @author eriz
 * @date 2019年1月24日
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置系统过滤器
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public FilterRegistrationBean filterRegister() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new BaseFilter());
        // 过滤拦截器
        frBean.addUrlPatterns("/sys/user/*");
        return frBean;
    }

    /**
     * 配置系统过滤器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BaseInterceptor()).addPathPatterns("/sys/user/*");
    }
}
