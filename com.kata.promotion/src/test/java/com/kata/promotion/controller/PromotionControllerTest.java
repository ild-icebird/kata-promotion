package com.kata.promotion.controller;

import com.kata.promotion.controller.PromotionController;
import com.kata.promotion.model.Promotion;
import com.kata.promotion.model.PromotionRequest;
import com.kata.promotion.service.PromotionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PromotionControllerTest {

    @InjectMocks
    private PromotionController promotionController;

    @Mock
    private PromotionService promotionService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return promotions when valid request is provided")
    public void shouldReturnPromotionsWhenValidRequestIsProvided() {
        PromotionRequest request = new PromotionRequest();
        Promotion promotion = new Promotion("X", 1);
        when(promotionService.calculatePromotions(request)).thenReturn(Collections.singletonList(promotion));

        ResponseEntity<List<Promotion>> response = promotionController.calculatePromotions(request);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals(promotion, response.getBody().get(0));
    }

    @Test
    @DisplayName("Should return empty list when no promotions are available")
    public void shouldReturnEmptyListWhenNoPromotionsAreAvailable() {
        PromotionRequest request = new PromotionRequest();
        when(promotionService.calculatePromotions(request)).thenReturn(Collections.emptyList());

        ResponseEntity<List<Promotion>> response = promotionController.calculatePromotions(request);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, response.getBody().size());
    }
}