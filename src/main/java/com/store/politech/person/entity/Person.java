package com.store.politech.person.entity;

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
public class Person extends Auditable {

    private String firstName;

    private String lastName;

    private String email;

    private String dni;

    private String phone;

    private String address;

    private String city;

    private String imageUrl;

}