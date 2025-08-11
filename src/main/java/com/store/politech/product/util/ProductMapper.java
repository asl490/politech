package com.store.politech.product.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.store.politech.product.entity.Category;
import com.store.politech.product.entity.Product;
import com.store.politech.product.entity.Supplier;
import com.store.politech.shared.BaseMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper extends BaseMapper<Product, ProductDTO, ProductDTO.Create, ProductDTO.Update> {

    default Category map(Long categoryId) {
        if (categoryId == null)
            return null;
        Category category = new Category();
        category.setId(categoryId);
        return category;
    }

    default Supplier mapSupplier(Long supplierId) {
        if (supplierId == null)
            return null;
        Supplier supplier = new Supplier();
        supplier.setId(supplierId);
        return supplier;
    }

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    Product toEntity(ProductDTO.Create dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    void updateEntityFromDTO(ProductDTO.Update dto, @MappingTarget Product entity);

}