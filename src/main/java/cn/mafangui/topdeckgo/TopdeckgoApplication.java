package cn.mafangui.topdeckgo;

import org.jboss.logging.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@SpringBootApplication
@MapperScan("cn.mafangui.topdeckgo.dao")
@EnableScheduling
public class TopdeckgoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopdeckgoApplication.class, args);
	}
}
