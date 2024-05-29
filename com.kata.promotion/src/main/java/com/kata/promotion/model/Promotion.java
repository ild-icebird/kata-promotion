package com.kata.promotion.model;

import java.util.Objects;

public class Promotion {
    private String id;
    private int quantity;

    public Promotion(String id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

	public Promotion() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Promotion{" +
				"id='" + id + '\'' +
				", quantity=" + quantity +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Promotion promotion)) return false;
        return quantity == promotion.quantity && Objects.equals(id, promotion.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, quantity);
	}
}