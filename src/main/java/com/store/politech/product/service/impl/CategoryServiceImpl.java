package com.store.politech.product.service.impl;

import org.springframework.stereotype.Service;

import com.store.politech.product.entity.Category;
import com.store.politech.product.repository.CategoryRepository;
import com.store.politech.product.service.CategoryService;
import com.store.politech.product.util.CategoryDTO;
import com.store.politech.product.util.CategoryDTO.Create;
import com.store.politech.product.util.CategoryDTO.Filters;
import com.store.politech.product.util.CategoryDTO.Update;
import com.store.politech.product.util.CategoryMapper;
import com.store.politech.shared.BaseServiceImpl;

@Service
public class CategoryServiceImpl extends
        BaseServiceImpl<Category, Create, Update, CategoryDTO, Filters>
        implements CategoryService {

    public CategoryServiceImpl(CategoryRepository repository,
            CategoryMapper mapper) {
        super(repository, mapper);

    }

}