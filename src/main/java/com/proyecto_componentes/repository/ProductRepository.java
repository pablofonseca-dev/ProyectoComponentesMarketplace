package com.proyecto_componentes.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.proyecto_componentes.domain.Product;
import java.util.List;

public interface ProductRepository extends CosmosRepository<Product, String> {

    List<Product> findAllByUserId(String userId);

    List<Product> findByUuid(String uuid);

    void deleteTaskByUuid(String uuid);
}