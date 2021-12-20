package com.boots.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "items_item")
@Data//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor//ломбок аннотация: конструктор без аргуметов
public class Item {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer created_date;

    @ManyToOne
    @JoinColumn(name="supplier_id", nullable=false)
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;


}
