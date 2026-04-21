package com.mysite.exam1.repository;

import com.mysite.exam1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}