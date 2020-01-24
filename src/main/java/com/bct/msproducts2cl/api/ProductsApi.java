package com.bct.msproducts2cl.api;

import com.bct.msproducts2cl.model.Product;
import com.bct.msproducts2cl.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/rest/product")
public class ProductsApi {

    ProductService productService;

    @RequestMapping(value="/",  produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProducts(){
        log.info("ProductsController - getProducts");
        List<Product> productsList = productService.getAllProducts();
        return new ResponseEntity<>(productsList, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}",  produces = {"application/json"}, method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteProduct(@PathVariable(name = "id") Integer productId){
        log.info("ProductsController - deleteProduct :" + productId);
        Boolean deleted = productService.deleteProduct(productId);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

    @RequestMapping(value="/",  produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<Integer> createProduct(@RequestBody Product product){
        log.info("ProductsController - getProduct :" + product.getId());
        Integer productId = productService.createProduct(product);
        return new ResponseEntity<>(productId, HttpStatus.OK);
    }

    @RequestMapping(value="/{productId}",  produces = {"application/json"}, method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateProductQty(@PathVariable(name = "productId")Integer productId,
                                                    @RequestParam(required = true, name = "qty") Integer qty
    ){
        log.info("ProductsController - updateProductQty :" + qty );
        Boolean response = productService.updateProductQty(productId, qty);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
