package com.bernardomecabo.financial_control_system.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private long categoryId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User user;

    @Column(name = "nome", nullable = false)
    private String categoryName;

    @Column(name = "tipo", nullable = false)
    private String categoryType;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime categoryCreationDate;

    public Category(){}

    public Category(User user, String name, String type){
        this.user = user;
        this.categoryName = name;
        this.categoryType = type;
        this.categoryCreationDate = LocalDateTime.now();
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public LocalDateTime getCreationTime() {
        return categoryCreationDate;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.categoryCreationDate = creationTime;
    }
}
