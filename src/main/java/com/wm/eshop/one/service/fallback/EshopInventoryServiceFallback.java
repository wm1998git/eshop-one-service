package com.wm.eshop.one.service.fallback;

import org.springframework.stereotype.Component;
import com.wm.eshop.one.service.EshopInventoryService;

@Component
public class EshopInventoryServiceFallback implements EshopInventoryService {
	
	public String findByProductId(Long productId) {
		return "降级库存数据";
	}

}
