package com.gluuten.configuration;

import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import javax.servlet.annotation.WebServlet;
import org.hibernate.jpa.*;


/**
 * Created by yusufaslan on 1.06.2017.
 */

public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Bean
        // TODO: Enables h2 console - only for development environment
    ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebdavServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}