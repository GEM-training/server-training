package com.gem.nhom1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by vanhop on 1/18/16.
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.gem.nhom1")
public class MvcConfig extends WebMvcConfigurerAdapter{

    @Bean
    public ViewResolver viewResolver(){

        InternalResourceViewResolver internal = new InternalResourceViewResolver();
        internal.setViewClass(JstlView.class);
        internal.setPrefix("/WEB-INF/views/");
        internal.setSuffix(".jsp");
        return internal;

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }
}
