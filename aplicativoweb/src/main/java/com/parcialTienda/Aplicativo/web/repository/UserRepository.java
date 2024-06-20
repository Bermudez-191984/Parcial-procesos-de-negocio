package com.parcialTienda.Aplicativo.web.repository;
import com.parcialTienda.Aplicativo.web.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByEmail(String email);
}