package com.proyecto_componentes.web;

import java.util.List;

import com.proyecto_componentes.domain.Product;
import com.proyecto_componentes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public String products(Model model) {
        return "products";
    }

    @CrossOrigin
    @PostMapping("/api/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product newProduct = new Product(product.getUserId(), product.getName(), product.getDescription(), product.getPrice());
        productService.registerProduct(newProduct);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(path="/api/product/{userId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProductsByUserID(@PathVariable("userId") String userId) {
        List<Product> productList = productService.findAllByUserId(userId);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(path="/api/product/{uuid}")
    public ResponseEntity<Product> updateProductByUUID(@PathVariable("uuid") String uuid, @RequestBody Product product) {
        Product updatedEspecie = productService.updateByUuid(uuid, product);
        return new ResponseEntity<>(updatedEspecie, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(path="/api/product/{uuid}")
    public ResponseEntity<String> deleteProductByUUID(@PathVariable("uuid") String uuid) {
        productService.deleteByUuid(uuid);
        return new ResponseEntity<>(uuid, HttpStatus.OK);
    }
}
