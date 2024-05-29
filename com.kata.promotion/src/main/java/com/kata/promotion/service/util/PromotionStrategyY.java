package com.kata.promotion.service.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.kata.promotion.model.Promotion;

public class PromotionStrategyY implements PromotionStrategy {
	public List<Promotion> calculatePromotions(Map<String, Long> productCount) {

		long countA = Optional.ofNullable(productCount.get("A")).orElse(0L);
		long countD = Optional.ofNullable(productCount.get("D")).orElse(0L);

		int discountY = 0;
		if (countA == 1 && countD == 1) {
			discountY = 1;
		}

		List<Promotion> list=new LinkedList<>();
		list.add(new Promotion("Y", discountY));

		return list;
	}
}