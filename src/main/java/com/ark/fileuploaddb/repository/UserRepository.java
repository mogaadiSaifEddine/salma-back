package com.ark.fileuploaddb.repository;

import com.ark.fileuploaddb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User ,Long> {
}
