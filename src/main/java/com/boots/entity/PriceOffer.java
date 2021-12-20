package com.boots.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders_priceoffer")
@Data//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor//ломбок аннотация: конструктор без аргуметов
public class PriceOffer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Integer for_quantity;

    private Double price_per_unit;

    private Integer created_date;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item item;

}
