package com.proyecto_componentes.repository;

import com.proyecto_componentes.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findAllByUserId(String userId);

    List<User> findByUuid(String uuid);

    void deleteTaskByUuid(String uuid);
}