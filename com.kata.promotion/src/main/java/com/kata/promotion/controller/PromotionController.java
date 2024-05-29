package com.kata.promotion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kata.promotion.model.Promotion;
import com.kata.promotion.model.PromotionRequest;
import com.kata.promotion.service.PromotionService;

@RestController
@RequestMapping("/api/v1/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @PostMapping
    public ResponseEntity<List<Promotion>> calculatePromotions(@RequestBody PromotionRequest request) {
        return ResponseEntity.ok(promotionService.calculatePromotions(request));
    }
}
