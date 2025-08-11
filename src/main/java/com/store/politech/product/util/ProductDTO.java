package com.store.politech.product.util;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;

    private String name;

    private BigDecimal price;

    private Integer stock;

    private CategoryDTO category;

    private SupplierDTO supplier;

    @Data
    public static class Create {

        @NotBlank

        private String name;

        @NotNull

        @Min(0)

        private BigDecimal price;

        @NotNull

        @Min(0)

        private Integer stock;

        private Long category;

        private Long supplier;

    }

    @Data
    public static class Update {

        private String name;

        private BigDecimal price;

        private Integer stock;

        private Long category;

        private Long supplier;

    }

    @Data
    public static class Filters {
        private Long id;

        private String name;

        private BigDecimal price;

        private Integer stock;

        private Long category;

        private Long supplier;

    }
}