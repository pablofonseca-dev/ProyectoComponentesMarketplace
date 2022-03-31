package com.proyecto_componentes.service;

import java.util.List;

import com.proyecto_componentes.domain.Product;

public interface ProductService {
    void registerProduct(Product product);

    List<Product> findAllByUserId(String userId);

    Product updateByUuid(String uuid, Product product);

    void deleteByUuid(String uuid);
}
