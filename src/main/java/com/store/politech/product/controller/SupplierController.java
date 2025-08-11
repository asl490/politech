package com.store.politech.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.politech.product.service.SupplierService;
import com.store.politech.product.util.SupplierDTO;
import com.store.politech.shared.BaseController;

@RestController
@RequestMapping("/supplier")
public class SupplierController
        extends BaseController<SupplierDTO.Create, SupplierDTO.Update, SupplierDTO, SupplierDTO.Filters> {

    public SupplierController(SupplierService service) {
        super(service);
    }

}