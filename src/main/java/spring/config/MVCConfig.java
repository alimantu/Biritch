package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Class is analogue mvc-config.xml
 */
@Configuration
@EnableWebMvc
@ComponentScan("spring.config")
public class MVCConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*registry.addResourceHandler("/views*//**").addResourceLocations("/WEB-INF/views/");
        registry.addResourceHandler("/js*//**").addResourceLocations("/WEB-INF/js/");*/
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/img/");
        /*registry.addResourceHandler("/webjars*//**").addResourceLocations("/webjars/");*/
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
