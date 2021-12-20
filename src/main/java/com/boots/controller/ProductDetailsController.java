package com.boots.controller;

import com.boots.entity.Item;
import com.boots.entity.Order;
import com.boots.entity.Product;
import com.boots.entity.User;
import com.boots.repository.ItemRepository;
import com.boots.repository.ProductRepository;
import com.boots.repository.UserRepository;
import com.boots.service.OrderService;
import com.boots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.Optional;


@Controller
public class ProductDetailsController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderService orderService;

    @GetMapping("/product/{product_id}")
    public String search_category(@PathVariable("product_id") Long productId, Principal principal, Model model) {
        Optional<Product> opProduct = productRepository.findById(productId);
        if (opProduct.isPresent()) {
            Product product = opProduct.get();
            User user = userRepository.findByUsername(principal.getName());
            Order order = orderService.getActiveOrder(user);

            model.addAttribute("is_in_order", orderService.isProductInOrder(product, order));
            model.addAttribute("product", product);
            model.addAttribute("items", itemRepository.findByProductId(product.getId()));

            return "items/product_details";
        } else {
            return "redirect:/search";
        }

    }

}
