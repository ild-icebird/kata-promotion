package com.kata.promotion.service.util;

import java.util.List;
import java.util.Map;

import com.kata.promotion.model.Promotion;

public interface PromotionStrategy {
	List<Promotion> calculatePromotions(Map<String, Long> productCount);
}