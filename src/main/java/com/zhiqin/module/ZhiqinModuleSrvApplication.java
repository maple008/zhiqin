package com.zhiqin.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ZhiqinModuleSrvApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(ZhiqinModuleSrvApplication.class, args);
    }

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
        messageBundle.setBasenames("classpath:validation");
        messageBundle.setDefaultEncoding("UTF-8");
        return messageBundle;
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container) -> {
            ErrorPage error401 = new ErrorPage(HttpStatus.UNAUTHORIZED, "/web/error");
            ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND, "/web/error");
            ErrorPage error500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/web/error");
            container.addErrorPages(error401, error404, error500);
        };
    }
}
