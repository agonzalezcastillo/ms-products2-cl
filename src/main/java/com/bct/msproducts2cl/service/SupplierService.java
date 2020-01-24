package com.bct.msproducts2cl.service;

import com.bct.msproducts2cl.model.Supplier;

public interface SupplierService {

    Integer saveSupplier(Supplier supplier);
    Boolean deleteSupplier(Integer supplierId);
    Supplier getSupplierAndProducts(Integer supplierId);

}
