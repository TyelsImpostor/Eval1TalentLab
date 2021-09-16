package com.everis.data.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.everis.data.models.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
	List<Producto> findAll();

}
