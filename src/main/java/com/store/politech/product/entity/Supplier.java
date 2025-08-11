package com.store.politech.product.entity;

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
public class Supplier extends Auditable {

    private String name;

    private String email;

    private String phone;

    private String address;

    private String website;

    private String ruc;

    private String bankAccount;

    private String contactPerson;

    private String description;

}