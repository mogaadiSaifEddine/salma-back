package com.ark.fileuploaddb.repository;

import com.ark.fileuploaddb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User ,Long> {

    Optional<User> findByNom(String nom);
    Optional<User> findByEmail(String email);
//    Boolean existsByUsername(String nom);



    Boolean existsByEmail(String email);
    List<User> findByEmailContaining(String email);

}
