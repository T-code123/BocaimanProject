package cn.bocaiman;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <b>菠菜侠旅游租赁平台-订单管理- Consumer 启动器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@EnableSwagger2
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class OrderConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(OrderConsumerStarter.class, args);
	}
}
