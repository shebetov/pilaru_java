package com.boots.controller;

import com.boots.entity.Item;
import com.boots.entity.ItemCategory;
import com.boots.repository.ItemCategoryRepository;
import com.boots.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Optional;


@Controller
public class SearchController {

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/search")
    public String search(Model model) {
        model.addAttribute("category_name", "Все категории");
        model.addAttribute("categories", itemCategoryRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        return "items/search";
    }

    @GetMapping("/search/{category_id}")
    public String search_category(@PathVariable("category_id") Long category_id, Model model) {
        Optional<ItemCategory> opCategory = itemCategoryRepository.findById(category_id);
        if (opCategory.isPresent()) {
            ItemCategory category = opCategory.get();
            model.addAttribute("category_name", category.getName());
            model.addAttribute("products", productRepository.findByCategoryId(category.getId()));
            return "items/search";
        } else {
            return "redirect:/search";
        }

    }

}
