package com.boots.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders_order")
@Data//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor//ломбок аннотация: конструктор без аргуметов
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Integer created_date;

    @ManyToOne
    @JoinColumn(name="project_id", nullable=false)
    private Project project;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<OrderState> states;

}
