package com.bernardomecabo.financial_control_system.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private long userId;

    @Column(name = "nome_usuario",length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "email",length = 100, nullable = false, unique = true)
    private String userEmail;

    @Column(name = "senha",length = 50, nullable = false)
    private String userPassword;

    @Column(name = "criado_em",nullable = false)
    private LocalDateTime userCreationDate;

    public User(){}

    public User(String username, String userEmail,String userPassword){
        this.username = username;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userCreationDate = LocalDateTime.now();
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public LocalDateTime getUserCreationDate() {
        return userCreationDate;
    }

    public void setUserCreationDate(LocalDateTime userCreationDate) {
        this.userCreationDate = userCreationDate;
    }
}
