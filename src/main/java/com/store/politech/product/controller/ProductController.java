package com.store.politech.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.politech.product.service.ProductService;
import com.store.politech.product.util.ProductDTO;
import com.store.politech.shared.BaseController;

@RestController
@RequestMapping("/product")
public class ProductController
        extends BaseController<ProductDTO.Create, ProductDTO.Update, ProductDTO, ProductDTO.Filters> {

    public ProductController(ProductService service) {
        super(service);
    }

}