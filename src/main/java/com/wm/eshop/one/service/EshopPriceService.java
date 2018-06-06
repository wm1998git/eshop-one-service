package com.wm.eshop.one.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wm.eshop.one.service.fallback.EshopPriceServiceFallback;

/** 使用Feign的客户端调用远程微服务接口，同时可作为微服务客户端的负载均衡 */
// "eshop-price-service"：远程RPC微服务名称。（这里应该使用Hystrix的降级策略：fallback = XXXServiceFallback.class），此注解会自动注入到Spring容器
@FeignClient(value = "eshop-price-service", fallback = EshopPriceServiceFallback.class)
public interface EshopPriceService {

	/** 远程调用eshop-price-service微服务对应的IP地址机器上的/product/findByProductId接口服务，获取【商品-价格】原子数据的变更消息 */
	// 注解为eshop-price-service工程的Control里的某个方法提供的RPC接口服务
	@RequestMapping(value = "/product-price/findByProductId", method = RequestMethod.GET)
	String findByProductId(@RequestParam(value = "productId") Long productId);

}