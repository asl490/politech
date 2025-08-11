package com.store.politech.product.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



import jakarta.validation.constraints.NotBlank;






@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long id;

    private String name;

    private String description;


    @Data
    public static class Create {
        
        
        
            @NotBlank
        
        
            private String name;
        
        
            private String description;
        
    }

    @Data
    public static class Update {
        
        private String name;
    
        private String description;
    
    }

    @Data
    public static class Filters {
        private Long id;
    
        private String name;
    
        private String description;
    
    }
}