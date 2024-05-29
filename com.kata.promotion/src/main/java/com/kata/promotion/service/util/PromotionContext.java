package com.kata.promotion.service.util;

import java.util.List;
import java.util.Map;

import com.kata.promotion.model.Promotion;

public class PromotionContext {
    private PromotionStrategy strategy;

    public PromotionContext(PromotionStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PromotionStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Promotion> executeStrategy(Map<String, Long> productCount) {
        return strategy.calculatePromotions(productCount);
    }
}
