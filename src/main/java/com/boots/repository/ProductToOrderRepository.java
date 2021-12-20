package com.boots.repository;

import com.boots.entity.ProductToOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductToOrderRepository extends JpaRepository<ProductToOrder, Long> {

    @Query(value="SELECT x FROM ProductToOrder x WHERE x.product.id = :productId AND x.order.id = :orderId")
    List<ProductToOrder> findByProductIdAndOrderId(Long productId, Long orderId);

    @Query(value="SELECT x FROM ProductToOrder x WHERE x.order.id = :orderId")
    List<ProductToOrder> findByOrderId(Long orderId);
}
