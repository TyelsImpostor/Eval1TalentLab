package com.everis.data.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.everis.data.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	List<Usuario> findAll();

}
