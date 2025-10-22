package com.cvbuilder.auth.repository;

import com.cvbuilder.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
