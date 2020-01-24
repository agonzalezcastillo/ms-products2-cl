package com.bct.msproducts2cl.service.impl;

import com.bct.msproducts2cl.model.Product;
import com.bct.msproducts2cl.model.Supplier;
import com.bct.msproducts2cl.repository.ProductRepository;
import com.bct.msproducts2cl.repository.SupplierRepository;
import com.bct.msproducts2cl.service.SupplierService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
@Slf4j
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository supplierRepository;

    private ProductRepository productRepository;

    @Override
    public Integer saveSupplier(Supplier supplier){

        List<Product> supplierProductList = new ArrayList<>();
        List<Product> newProducts = new ArrayList<>();

        supplier.getProducts().forEach(p->p.setSupplierId(supplier.getId()));
        supplierProductList.addAll(supplier.getProducts());

        Supplier resSupplier =  new Supplier();
        try {
            resSupplier = supplierRepository.findById(supplier.getId()).get();
        }catch(NoSuchElementException e){
            log.info("no products associated");
        }

        if(resSupplier.getId() != null){
            if(resSupplier.getProducts() != null && !resSupplier.getProducts().isEmpty()){
                for (Product product : resSupplier.getProducts()) {
                    for (Product product2 : supplier.getProducts()) {
                        if (product.equals(product2)) {
                            product2.setQuantity(product.getQuantity() + product2.getQuantity());
                            product2.setId(product.getId());
                            productRepository.save(product2);
                        }else{
                            newProducts.add(product2);
                        }
                    }
                }
                productRepository.saveAll(newProducts);
            }
        }else{
            supplier.getProducts().clear();
            supplierRepository.save(supplier);
            productRepository.saveAll(supplierProductList);
        }

        return supplier.getId();
    }

    @Override
    public Boolean deleteSupplier(Integer supplierId) {
        supplierRepository.deleteById(supplierId);
        return true;
    }

    @Override
    public Supplier getSupplierAndProducts(Integer supplierId) {
        return supplierRepository.findById(supplierId).get();

    }

}
