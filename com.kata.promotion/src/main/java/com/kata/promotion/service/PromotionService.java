package com.kata.promotion.service;

import java.util.List;

import com.kata.promotion.model.Promotion;
import com.kata.promotion.model.PromotionRequest;

public interface PromotionService {
	public List<Promotion> calculatePromotions(PromotionRequest request);
}
