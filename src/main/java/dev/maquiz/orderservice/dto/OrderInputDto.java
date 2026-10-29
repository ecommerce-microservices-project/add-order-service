package dev.maquiz.orderservice.dto;

import java.util.List;

public class OrderInputDto {
  private List<OrderItemDto> items;

    public OrderInputDto() {
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }
}




