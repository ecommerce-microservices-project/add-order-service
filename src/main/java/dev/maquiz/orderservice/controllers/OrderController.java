package dev.maquiz.orderservice.controllers;

import dev.maquiz.orderservice.dao.OrderItemRepository;
import dev.maquiz.orderservice.dao.OrderRepository;
import dev.maquiz.orderservice.dto.OrderInputDto;
import dev.maquiz.orderservice.entity.Order;
import dev.maquiz.orderservice.entity.OrderItem;
import dev.maquiz.orderservice.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderRepository repo;

    @Autowired
    OrderItemRepository orderItemRepository;

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody OrderInputDto orderInputDto ){
        //Save Order
       Order order = new Order();
       order.setStatus(OrderStatus.CREATED);
       order.setCreatedAt(LocalDateTime.now());
       Order savedOrder = repo.save(order);

       //Save order items
        ArrayList<OrderItem> orderItemsList = new ArrayList<>();

        orderInputDto.getItems().forEach(item->{
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setProductId(item.getProductId());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(item.getPrice());
            OrderItem savedOrderItem = orderItemRepository.save(orderItem);
            orderItemsList.add(savedOrderItem);
        });

        savedOrder.setItems(orderItemsList);

       return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
}
