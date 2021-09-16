package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.everis.data.models.Producto;
import com.everis.data.repositories.ProductoRepository;
@Service
public class ProductoService {
	
	private final ProductoRepository pr;
	public ProductoService(ProductoRepository productorepository) {
		this.pr = productorepository;
	}
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	public Producto crearProducto(@Valid Producto producto) {
		// TODO Auto-generated method stub
		pr.save(producto);
		return producto;
	}

	public void deleteProducto(Long id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);
	}

	public Producto buscarProducto(Long id) {
		// TODO Auto-generated method stub
		Optional<Producto> oProducto= pr.findById(id);
		if (oProducto.isPresent()) {
			return oProducto.get();
		}
		return null;
	}

	public void modificarProducto(@Valid Producto producto) {
		// TODO Auto-generated method stub
		pr.save(producto);
	}

}
