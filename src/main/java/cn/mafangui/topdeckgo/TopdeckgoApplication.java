package cn.mafangui.topdeckgo;

import org.jboss.logging.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("cn.mafangui.topdeckgo.dao")
public class TopdeckgoApplication {
	public static void main(String[] args) {
		SpringApplication.run(TopdeckgoApplication.class, args);
	}
}
