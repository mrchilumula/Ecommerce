package com.example.productservice.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity

public class Roles  extends BaseModel {
    private String RoleName;
    private String Description;
    private Boolean isActive;
}
