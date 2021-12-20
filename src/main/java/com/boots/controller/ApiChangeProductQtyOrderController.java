package com.boots.controller;

import com.boots.entity.Order;
import com.boots.entity.Product;
import com.boots.entity.ProductToOrder;
import com.boots.entity.User;
import com.boots.repository.ProductRepository;
import com.boots.repository.ProductToOrderRepository;
import com.boots.repository.StageRepository;
import com.boots.repository.UserRepository;
import com.boots.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.Optional;


@RestController
public class ApiChangeProductQtyOrderController {

    @Autowired
    private ProductToOrderRepository productToOrderRepository;

    @PostMapping("/api/change_product_qty_in_order")
    public String add_product_to_order(@RequestParam(value="pto_id") Long ptoId, @RequestParam(value="quantity") Integer quantity, Principal principal, Model model) {
        Optional<ProductToOrder> opPto = productToOrderRepository.findById(ptoId);
        if (!opPto.isPresent()) {
            return "{\"result\":\"ok\"}";
        }
        ProductToOrder pto = opPto.get();
        pto.setQuantity(quantity);
        productToOrderRepository.save(pto);
        return "{\"result\":\"ok\"}";
    }

}
