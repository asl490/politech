package com.store.politech.product.service.impl;

import org.springframework.stereotype.Service;

import com.store.politech.product.entity.Product;
import com.store.politech.product.repository.ProductRepository;
import com.store.politech.product.service.ProductService;
import com.store.politech.product.util.ProductDTO;
import com.store.politech.product.util.ProductDTO.Create;
import com.store.politech.product.util.ProductDTO.Filters;
import com.store.politech.product.util.ProductDTO.Update;
import com.store.politech.product.util.ProductMapper;
import com.store.politech.shared.BaseServiceImpl;

@Service
public class ProductServiceImpl extends
        BaseServiceImpl<Product, Create, Update, ProductDTO, Filters>
        implements ProductService {

    public ProductServiceImpl(ProductRepository repository,
            ProductMapper mapper) {
        super(repository, mapper);

    }

}