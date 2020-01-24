package com.bct.msproducts2cl.service.impl;

import com.bct.msproducts2cl.model.Product;
import com.bct.msproducts2cl.repository.ProductRepository;
import com.bct.msproducts2cl.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Integer createProduct(Product product) {
        Product productId = productRepository.save(product);
        return productId.getId();
    }

    @Override
    public Boolean deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public Boolean updateProductQty(Integer productId, Integer qty) {
        Product product = productRepository.findById(productId).get();
        product.setQuantity(qty);
        productRepository.save(product);
        return true;
    }
}
