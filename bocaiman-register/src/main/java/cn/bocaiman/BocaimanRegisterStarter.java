package cn.bocaiman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <b>菠菜侠旅游租赁平台-注册中心启动器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@EnableEurekaServer
@SpringBootApplication
public class BocaimanRegisterStarter {
	public static void main(String[] args) {
		SpringApplication.run(BocaimanRegisterStarter.class, args);
	}
}
