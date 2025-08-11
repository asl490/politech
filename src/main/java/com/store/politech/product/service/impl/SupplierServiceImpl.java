package com.store.politech.product.service.impl;

import org.springframework.stereotype.Service;

import com.store.politech.product.entity.Supplier;
import com.store.politech.product.repository.SupplierRepository;
import com.store.politech.product.service.SupplierService;
import com.store.politech.product.util.SupplierDTO;
import com.store.politech.product.util.SupplierDTO.Create;
import com.store.politech.product.util.SupplierDTO.Filters;
import com.store.politech.product.util.SupplierDTO.Update;
import com.store.politech.product.util.SupplierMapper;
import com.store.politech.shared.BaseServiceImpl;

@Service
public class SupplierServiceImpl extends
        BaseServiceImpl<Supplier, Create, Update, SupplierDTO, Filters>
        implements SupplierService {

    public SupplierServiceImpl(SupplierRepository repository,
            SupplierMapper mapper) {
        super(repository, mapper);

    }

}