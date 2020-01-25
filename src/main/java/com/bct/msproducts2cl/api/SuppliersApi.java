package com.bct.msproducts2cl.api;

import com.bct.msproducts2cl.model.Supplier;
import com.bct.msproducts2cl.service.SupplierService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/rest/supplier")
public class SuppliersApi {

    SupplierService supplierService;

    @RequestMapping(value="/{id}",  produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<Supplier> getSupplier(@PathVariable(name = "id") Integer supplierId){
        log.info("ProductsController - getSupplier :" + supplierId);
        Supplier supplier = supplierService.getSupplierAndProducts(supplierId);
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    @RequestMapping(value="/",  produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<Integer> createSupplier(@RequestBody Supplier supplier){
        log.info("ProductsController - getProduct :" + supplier.getId());
        Integer supplierId = supplierService.saveSupplier(supplier);
        return new ResponseEntity<>(supplierId, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}",  produces = {"application/json"}, method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteSupplier(@PathVariable(name = "id") Integer supplierId){
        log.info("ProductsController - deleteSupplier :" + supplierId);
        Boolean deleted = supplierService.deleteSupplier(supplierId);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
