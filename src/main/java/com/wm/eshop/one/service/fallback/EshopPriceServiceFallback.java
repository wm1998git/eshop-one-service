package com.wm.eshop.one.service.fallback;

import org.springframework.stereotype.Component;

import com.wm.eshop.one.service.EshopPriceService;

@Component
public class EshopPriceServiceFallback implements EshopPriceService {

	public String findByProductId(Long productId) {
		return "降级价格数据";
	}

}
