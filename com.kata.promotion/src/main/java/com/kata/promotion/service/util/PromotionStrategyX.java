package com.kata.promotion.service.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import com.kata.promotion.model.Promotion;

public class PromotionStrategyX implements PromotionStrategy {

	public List<Promotion> calculatePromotions(Map<String, Long> productCount) {

		long countA = Optional.ofNullable(productCount.get("A")).orElse(0L);
		long countB = Optional.ofNullable(productCount.get("B")).orElse(0L);
		long countC = Optional.ofNullable(productCount.get("C")).orElse(0L);
		long countBC = Stream.of(countB, countC).mapToLong(Long::longValue).sum();
		long countD = Optional.ofNullable(productCount.get("D")).orElse(0L);

		int discountX = 0;
		if (countA == 1) {
			discountX = (int) Math.max(countD, countBC);
		}

		List<Promotion> list=new LinkedList<>();
		list.add(new Promotion("X", discountX));

		return list;

	}

}