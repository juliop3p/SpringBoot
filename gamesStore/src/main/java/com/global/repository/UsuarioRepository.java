package com.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.global.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
