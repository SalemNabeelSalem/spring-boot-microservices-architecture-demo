package com.springbootmicroservices.userservice.repositories;

import com.springbootmicroservices.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE name Like %:name%", nativeQuery = true)
    List<User> findUserByName(@Param("name") String name);
}