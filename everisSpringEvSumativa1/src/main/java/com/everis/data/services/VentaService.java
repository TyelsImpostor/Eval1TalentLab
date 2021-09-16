package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.everis.data.models.Venta;
import com.everis.data.repositories.VentaRepository;
@Service
public class VentaService {

	private final VentaRepository vr;
	public VentaService(VentaRepository ventarepository) {
		this.vr = ventarepository;
	}
	
	public List<Venta> findAll() {
		// TODO Auto-generated method stub
		return vr.findAll();
	}

	public Venta crearVenta(@Valid Venta venta) {
		// TODO Auto-generated method stub
		vr.save(venta);
		return venta;
	}

	public void deleteVenta(Long id) {
		// TODO Auto-generated method stub
		vr.deleteById(id);
	}

	public Venta buscarVenta(Long id) {
		// TODO Auto-generated method stub
		Optional<Venta> oVenta= vr.findById(id);
		if (oVenta.isPresent()) {
			return oVenta.get();
		}
		return null;
	}

	public void modificarVenta(@Valid Venta venta) {
		// TODO Auto-generated method stub
		vr.save(venta);
	}

}
