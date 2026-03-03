package com.github.Ashirios.auth_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.Ashirios.auth_service.entity.UserEntity;
import com.github.Ashirios.auth_service.enums.Role;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByEmail(String email);


    public List<UserEntity> findAllByRole(Role role);


}
