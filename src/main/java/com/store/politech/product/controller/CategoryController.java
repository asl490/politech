package com.store.politech.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.politech.product.service.CategoryService;
import com.store.politech.product.util.CategoryDTO;
import com.store.politech.shared.BaseController;

@RestController
@RequestMapping("/category")
public class CategoryController
        extends BaseController<CategoryDTO.Create, CategoryDTO.Update, CategoryDTO, CategoryDTO.Filters> {

    public CategoryController(CategoryService service) {
        super(service);
    }

}