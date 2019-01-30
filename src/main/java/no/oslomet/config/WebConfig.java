package no.oslomet.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
@EnableWebMvc
@ComponentScan("no.oslomet")
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver(){
        // create view resolver object
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        //set view class
        resolver.setViewClass(JstlView.class);
        // set prefix and suffix
        resolver.setPrefix("/view/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

}
