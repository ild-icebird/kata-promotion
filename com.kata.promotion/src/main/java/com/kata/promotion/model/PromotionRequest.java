package com.kata.promotion.model;

import java.util.List;
import java.util.Objects;

public class PromotionRequest {
    private List<Product> products;
    private String clientType;
	public PromotionRequest(List<Product> products, String clientType) {
		super();
		this.products = products;
		this.clientType = clientType;
	}
	public PromotionRequest() {
	
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	@Override
	public String toString() {
		return "PromotionRequest{" +
				"products=" + products +
				", clientType='" + clientType + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PromotionRequest that)) return false;
        return Objects.equals(products, that.products) && Objects.equals(clientType, that.clientType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(products, clientType);
	}
}