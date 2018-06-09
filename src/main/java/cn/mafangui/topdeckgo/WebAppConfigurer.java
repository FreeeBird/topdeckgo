package cn.mafangui.topdeckgo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedOrigins("*")
                //rest集中请求方式
                .allowedMethods("GET", "POST")
                .allowCredentials(false).maxAge(3600);
    }
}
