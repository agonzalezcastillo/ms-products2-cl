package com.bct.msproducts2cl.service;

import com.bct.msproducts2cl.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Integer createProduct(Product product);
    Boolean deleteProduct(Integer productId);
    Boolean updateProductQty(Integer productId,  Integer qty);

}
