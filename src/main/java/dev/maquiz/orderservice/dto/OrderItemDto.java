package dev.maquiz.orderservice.dto;

import java.math.BigDecimal;

public class OrderItemDto {
    int productId;
    int quantity;
    BigDecimal price;

    public OrderItemDto() {
    }

    public OrderItemDto(int productId, int quantity, BigDecimal price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
