package com.wm.eshop.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
// 将本应用作为一个微服务注册到Eureka Server上去
@EnableEurekaClient
// feign声明式的服务调用，类似于rpc风格的服务调用，【这种风格非常好且常用】，因它默认集成了ribbon做负载均衡，且默认集成了eureka做服务发现
@EnableFeignClients

//使用Hystrix dashboard做可视化分布式系统监控
@EnableHystrixDashboard
//使用Hystrix的短路器
@EnableCircuitBreaker
public class EshopOneServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshopOneServiceApplication.class, args);
	}

}