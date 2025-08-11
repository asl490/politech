package com.store.politech.product.util;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String website;
    private String ruc;
    private String bankAccount;
    private String contactPerson;
    private String description;

    @Data
    public static class Create {

        @NotBlank

        private String name;
        @Email

        private String email;
        @NotBlank

        private String phone;
        @NotBlank

        private String address;
        private String website;
        @NotBlank

        private String ruc;
        private String bankAccount;
        private String contactPerson;
        private String description;
    }

    @Data
    public static class Update {

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

    @Data
    public static class Filters {
        private Long id;
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
}