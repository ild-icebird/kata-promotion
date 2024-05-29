package com.kata.promotion.serviceimpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kata.promotion.model.Product;
import com.kata.promotion.model.Promotion;
import com.kata.promotion.model.PromotionRequest;
import com.kata.promotion.service.PromotionService;
import com.kata.promotion.service.util.PromotionContext;
import com.kata.promotion.service.util.PromotionStrategyX;
import com.kata.promotion.service.util.PromotionStrategyY;

@Service
public class PromotionServiceImpl implements PromotionService{

	public List<Promotion> calculatePromotions(PromotionRequest request) {
		List<Product> products = request.getProducts();
		Map<String, Long> productCount = products.stream()
				.collect(Collectors.groupingBy(Product::getId, Collectors.counting()));

		PromotionContext context = new PromotionContext(new PromotionStrategyX());
		List<Promotion> promotions = context.executeStrategy(productCount);

		context.setStrategy(new PromotionStrategyY());
		promotions.addAll(context.executeStrategy(productCount));

		return promotions;
	}
}
