package com.boots.repository;

import com.boots.entity.Item;
import com.boots.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value="SELECT x FROM Order x WHERE x.project.id = :projectId")
    List<Order> findByProjectId(Long projectId);
}
