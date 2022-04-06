package com.proyecto_componentes.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.proyecto_componentes.domain.User;
import java.util.List;

public interface UserRepository extends CosmosRepository<User, String> {

    List<User> findAllByUserId(String userId);

    List<User> findByUuid(String uuid);

    void deleteTaskByUuid(String uuid);
}