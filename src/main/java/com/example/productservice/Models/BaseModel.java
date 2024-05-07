package com.example.productservice.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter

@Getter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private boolean isDeleted;
    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        lastUpdatedAt = new Date();
    }


    @PreUpdate
    protected void onUpdate() {
        lastUpdatedAt = new Date();
    }

}
