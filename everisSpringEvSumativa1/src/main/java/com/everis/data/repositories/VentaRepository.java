package com.everis.data.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.everis.data.models.Venta;

public interface VentaRepository extends CrudRepository<Venta, Long>{
	List<Venta> findAll();

}
