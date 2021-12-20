package com.boots.controller;

import com.boots.entity.*;
import com.boots.repository.ProductToOrderRepository;
import com.boots.repository.StageRepository;
import com.boots.repository.UserRepository;
import com.boots.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;


@Controller
public class OrderViewController {

    @Autowired
    private ProductToOrderRepository productToOrderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private StageRepository stageRepository;

    @GetMapping("/order")
    public String order_view(Principal principal, Model model) {
        User user = userRepository.findByUsername(principal.getName());
        Order order = orderService.getActiveOrder(user);
        List<ProductToOrder> ptos = productToOrderRepository.findByOrderId(order.getId());

        model.addAttribute("order", order);
        model.addAttribute("ptos", ptos);
        model.addAttribute("stages", stageRepository.findAll());

        return "orders/order_view";
    }

}
