package com.boots.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "projects_projectmember")
@Data//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor//ломбок аннотация: конструктор без аргуметов
public class ProjectMember {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String link_key;

    private Integer created_date;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="role_id", nullable=false)
    private ProjectRole role;

    @ManyToOne
    @JoinColumn(name="project_id", nullable=false)
    private Project project;


}
