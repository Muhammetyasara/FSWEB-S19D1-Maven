package com.workintech.s18d2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public class Plant {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Size(min=3, max = 45, message = "name size must be between 3 to 45.")
    @NotNull(message = "name cannot be null")
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    @DecimalMin("10")
    private Double price;
}
