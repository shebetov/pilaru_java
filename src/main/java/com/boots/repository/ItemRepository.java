package com.boots.repository;

import com.boots.entity.Item;
import com.boots.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value="SELECT x FROM Item x WHERE x.product.id = :productId")
    List<Item> findByProductId(Long productId);
}
