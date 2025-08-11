package com.store.politech.product.entity;

import java.math.BigDecimal;

import com.store.politech.shared.Auditable;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends Auditable {

    private String name;

    private BigDecimal price;

    private Integer stock;

    private Category category;

    private Supplier supplier;

}