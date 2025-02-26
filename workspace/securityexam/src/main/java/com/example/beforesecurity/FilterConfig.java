package com.example.beforesecurity;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig { //디테일하게 등록하고 싶을 때
    @Bean
    public FilterRegistrationBean<JiyunFilter> JiyunFilter(RegistrationBean registrationBean) {
        FilterRegistrationBean<JiyunFilter> jiyunFilterFilterRegistrationBean = new FilterRegistrationBean<>();
        jiyunFilterFilterRegistrationBean.setFilter(new JiyunFilter());
        jiyunFilterFilterRegistrationBean.addUrlPatterns("/*"); //특정한 url
        jiyunFilterFilterRegistrationBean.setOrder(2);
        return jiyunFilterFilterRegistrationBean;
    }
}
