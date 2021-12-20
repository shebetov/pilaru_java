package com.boots.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "items_producttoorder")
@Data//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor//ломбок аннотация: конструктор без аргуметов
public class ProductToOrder {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="stage_id", nullable=false)
    private Stage stage;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order order;

}
