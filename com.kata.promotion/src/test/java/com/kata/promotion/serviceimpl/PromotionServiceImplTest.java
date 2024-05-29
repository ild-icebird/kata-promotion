package com.kata.promotion.serviceimpl;

import com.kata.promotion.model.Product;
import com.kata.promotion.model.Promotion;
import com.kata.promotion.model.PromotionRequest;
import com.kata.promotion.serviceimpl.PromotionServiceImpl;
import com.kata.promotion.service.util.PromotionStrategyX;
import com.kata.promotion.service.util.PromotionStrategyY;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PromotionServiceImplTest {

    @InjectMocks
    private PromotionServiceImpl promotionService;

    @Mock
    private PromotionStrategyX promotionStrategyX;

    @Mock
    private PromotionStrategyY promotionStrategyY;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnPromotionsWhenValidRequestIsProvided() {
        PromotionRequest request = new PromotionRequest();
        request.setProducts(Arrays.asList(new Product("A"), new Product("D")));
        Promotion promotionX = new Promotion("X", 1);
        Promotion promotionY = new Promotion("Y", 1);

        Map<String, Long> productCount = request.getProducts().stream()
                .collect(Collectors.groupingBy(Product::getId, Collectors.counting()));

        when(promotionStrategyX.calculatePromotions(productCount)).thenReturn(Arrays.asList(promotionX));
        when(promotionStrategyY.calculatePromotions(productCount)).thenReturn(Arrays.asList(promotionY));

        List<Promotion> promotions = promotionService.calculatePromotions(request);

        assertEquals(2, promotions.size());
        assertEquals(promotionX, promotions.get(0));
        assertEquals(promotionY, promotions.get(1));
    }

    @Test
    public void shouldReturnEmptyListWhenNoPromotionsAreAvailable() {
        PromotionRequest request = new PromotionRequest();
        request.setProducts(Arrays.asList(new Product("A"), new Product("D")));
        Map<String, Long> productCount = request.getProducts().stream()
                .collect(Collectors.groupingBy(Product::getId, Collectors.counting()));
        when(promotionStrategyX.calculatePromotions(productCount)).thenReturn(Arrays.asList());
        when(promotionStrategyY.calculatePromotions(productCount)).thenReturn(Arrays.asList());

        List<Promotion> promotions = promotionService.calculatePromotions(request);

        assertEquals(2, promotions.size());
    }
}