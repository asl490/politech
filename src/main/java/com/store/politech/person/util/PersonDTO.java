package com.store.politech.person.util;

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
public class PersonDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String dni;

    private String phone;

    private String address;

    private String city;

    private String imageUrl;

    @Data
    public static class Create {

        @NotBlank

        private String firstName;

        @NotBlank

        private String lastName;

        @Email

        private String email;

        @NotBlank

        private String dni;

        @NotBlank

        private String phone;

        @NotBlank

        private String address;

        @NotBlank

        private String city;

        @NotBlank

        private String imageUrl;

    }

    @Data
    public static class Update {

        private String firstName;

        private String lastName;

        private String email;

        private String dni;

        private String phone;

        private String address;

        private String city;

        private String imageUrl;

    }

    @Data
    public static class Filters {
        private Long id;

        private String firstName;

        private String lastName;

        private String email;

        private String dni;

        private String phone;

        private String address;

        private String city;

        private String imageUrl;

    }
}