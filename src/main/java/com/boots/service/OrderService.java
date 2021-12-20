package com.boots.service;

import com.boots.entity.*;
import com.boots.repository.ItemRepository;
import com.boots.repository.ProductToOrderRepository;
import com.boots.repository.OrderRepository;
import com.boots.repository.ProjectMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductToOrderRepository productToOrderRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ProjectMemberRepository projectMemberRepository;

    public boolean isProductInOrder(Product product, Order order){
        List<ProductToOrder> productToOrders = productToOrderRepository.findByProductIdAndOrderId(product.getId(), order.getId());
        return productToOrders.isEmpty();
    }

    public Optional<Item> findFirstProductItem(Long productId) {
        List<Item> items = itemRepository.findByProductId(productId);
        if (items.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(items.get(items.size() - 1));
    }

    public Order getActiveOrder(User user) {
        List<ProjectMember> pms = projectMemberRepository.findByUserId(user.getId());

        if (pms.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "У вас нет активного проекта");
        }

        ProjectMember pm = pms.get(pms.size() - 1);
        List<Order> project_orders = orderRepository.findByProjectId(pm.getProject().getId());

        Order order;
        if (project_orders.isEmpty()) {
            order = new Order();
            order.setCreated_date(0);
            order.setProject(pm.getProject());
            orderRepository.save(order);
        } else {
            order = project_orders.get(project_orders.size() - 1);
        }
        return order;
    }

}
