package com.lance.demo.spring.web.config;

import com.lance.demo.spring.web.handler.WebInterceptorHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by perdonare on 2017/3/9.
 */
@EnableWebMvc
@Configuration
@ComponentScan("com.lance.demo.spring")
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new WebInterceptorHandler());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true).useJaf(false)
                .favorParameter(true).parameterName("mediaType")
                .ignoreAcceptHeader(false).
                defaultContentType(MediaType.APPLICATION_JSON).
                // mediaType("xml", MediaType.APPLICATION_XML).
                mediaType("json", MediaType.APPLICATION_JSON);
    }

 /*   @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter jmc = new MappingJackson2HttpMessageConverter();
        jmc.setPrettyPrint(true);
        converters.add(jmc);
        Jaxb2RootElementHttpMessageConverter j2 = new Jaxb2RootElementHttpMessageConverter();
        converters.add(j2);
    }*/
}
