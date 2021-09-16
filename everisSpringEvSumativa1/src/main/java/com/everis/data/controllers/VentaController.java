package com.everis.data.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Venta;
import com.everis.data.services.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {
	
	private final VentaService vs;
	
	public VentaController (VentaService ventaservice) {
		this.vs = ventaservice;
	}
	// =================CREAR====================
	@RequestMapping("")
	public String index(@ModelAttribute("venta") Venta venta, Model model) {
		System.out.println("INDEX");
		List<Venta> lista_ventas = vs.findAll();
		model.addAttribute("lista_ventas", lista_ventas);
		return "venta.jsp";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("venta") Venta venta) {
		System.out.println("CREATE" + venta);
		if(venta.getDescripcion().isBlank() || venta.getDescripcion().isEmpty()) {
			System.out.println("Nombre no puede estar vacio");
			return "redirect:/venta";
		}
		if(venta.getCantidad() == null) {
			System.out.println("Cantidad no puede estar vacio");
			return "redirect:/venta";
		}
		if(venta.getTotal() == null) {
			System.out.println("Total no puede estar vacio");
			return "redirect:/venta";
		}
		vs.crearVenta(venta);
		return "redirect:/venta";
	}

	// ============================================
	// ==============DELETE=======================
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id) {
		System.out.println("eliminar la id:" + id);
		vs.deleteVenta(id);
		return "redirect:/venta";
	}
	// ============================================
	// ==================EDITAR================
	@RequestMapping(value = "/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("actualizar id: " + id);
		Venta venta = vs.buscarVenta(id);
		model.addAttribute("venta", venta);
		return "ventaEditar.jsp";
	}
	// ============================================
	// ==================MODIFICAR==================
	@RequestMapping(value="/modificar", method= RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("venta") Venta venta) {
		vs.modificarVenta(venta);
		return "redirect:/venta";
	}
	//===============================================
}
