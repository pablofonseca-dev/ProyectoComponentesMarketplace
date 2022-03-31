package com.proyecto_componentes.repository;

import com.proyecto_componentes.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findAllByUserId(String userId);

    List<Product> findByUuid(String uuid);

    void deleteTaskByUuid(String uuid);
}