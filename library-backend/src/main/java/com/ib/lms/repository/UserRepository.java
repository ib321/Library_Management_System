package com.ib.lms.repository;

import com.ib.lms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * UserRepository interface extends JpaRepository for User entity
 * Uses userid as the primary identifier (not email)
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUserid(String userid);

    boolean existsByUserid(String userid);

    @Query("SELECT u FROM User u WHERE u.role = :role")
    List<User> findByRole(@Param("role") User.Role role);
}