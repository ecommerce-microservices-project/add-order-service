package dev.maquiz.orderservice.clients;

import dev.maquiz.orderservice.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

//@FeignClient(name = "get-products-by-filter-service")
public interface ProductByFilterClient {
    @GetMapping("/products/{product_id}")
    Optional<Product> findProductByIdFromClient(@PathVariable int product_id);
}
