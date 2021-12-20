package com.boots.repository;

import com.boots.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value="SELECT x FROM Product x WHERE x.category.id = :categoryId")
    List<Product> findByCategoryId(Long categoryId);
}
