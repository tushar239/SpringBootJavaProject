package spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import spring.rest.jsonview.ArguementResolvers.CustomUserArgumentResolver;
import spring.rest.jsonview.HandlerInterceptors.CustomHandlerInterceptor;

import java.util.List;

/**
 * @author Tushar Chokshi @ 4/29/15.
 */
@EnableWebMvc
@Configuration
@ComponentScan
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new CustomHandlerInterceptor());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new CustomUserArgumentResolver());
    }


}
