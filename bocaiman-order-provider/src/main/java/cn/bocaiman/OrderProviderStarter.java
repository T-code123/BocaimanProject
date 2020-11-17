package cn.bocaiman;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>菠菜侠旅游租赁平台-订单管理- Provider 启动器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@EnableEurekaClient
@MapperScan("cn.bocaiman.dao")
@SpringBootApplication
public class OrderProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(OrderProviderStarter.class, args);
	}
}
