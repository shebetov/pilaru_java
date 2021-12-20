package com.boots.controller;

import com.boots.entity.*;
import com.boots.repository.*;
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
public class ApiAddProductToOrderController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductToOrderRepository productToOrderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StageRepository stageRepository;
    @Autowired
    private OrderService orderService;

    @PostMapping("/api/add_product_to_order")
    public String add_product_to_order(@RequestParam(value="product_id") Long productId, Principal principal, Model model) {
        User user = userRepository.findByUsername(principal.getName());
        Order order = orderService.getActiveOrder(user);

        Optional<Product> opProduct = productRepository.findById(productId);
        if (!opProduct.isPresent()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "У данного продукта нет предложений");
        }
        Product product = opProduct.get();

        ProductToOrder pto = new ProductToOrder();
        pto.setOrder(order);
        pto.setProduct(product);
        pto.setQuantity(1);
        pto.setStage(stageRepository.findById(1L).get());
        productToOrderRepository.save(pto);
        return "{\"result\":\"ok\"}";
    }

}
