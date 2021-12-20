package com.boots.repository;

import com.boots.entity.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Long> {

    ItemCategory findByName(String name);
}
