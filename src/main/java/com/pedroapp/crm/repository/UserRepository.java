package com.pedroapp.crm.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.pedroapp.crm.model.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByEmail(String email);
}
