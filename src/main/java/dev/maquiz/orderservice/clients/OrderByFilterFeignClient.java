package dev.maquiz.orderservice.clients;


import dev.maquiz.orderservice.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "OrdersByFilter")
public interface OrderByFilterFeignClient {
    @GetMapping("/orders/{order_id}")
    Optional<Order> findOrderByIdFromClient(@PathVariable int order_id);
}
