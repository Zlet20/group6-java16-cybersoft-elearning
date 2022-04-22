package com.group6.java16.cybersoft.user.repository;

import java.util.Optional;
import java.util.UUID;

import com.group6.java16.cybersoft.user.model.ELUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ELUserRepository extends JpaRepository<ELUser, UUID>  {

    Optional<ELUser> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
