package com.boots.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "items_suppliercontact")
@Data//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor//ломбок аннотация: конструктор без аргуметов
public class SupplierContact {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String email;

    private Boolean is_selected;

    @ManyToOne
    @JoinColumn(name="supplier_id", nullable=false)
    private Supplier supplier;

}
