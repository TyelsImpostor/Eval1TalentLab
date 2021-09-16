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

import com.everis.data.models.Producto;
import com.everis.data.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	private final ProductoService ps;

	public ProductoController(ProductoService productoservice) {
		this.ps = productoservice;
	}
	// =================CREAR====================
	@RequestMapping("")
	public String index(@ModelAttribute("producto") Producto producto, Model model) {
		System.out.println("INDEX");
		List<Producto> lista_productos = ps.findAll();
		model.addAttribute("lista_productos", lista_productos);
		if(producto.getNombre().isBlank() || producto.getNombre().isEmpty()) {
			System.out.println("Nombre no puede estar vacio");
			return "redirect:/producto";
		}
		if(producto.getDescripcion().isBlank() || producto.getDescripcion().isEmpty()) {
			System.out.println("Descripcion no puede estar vacio");
			return "redirect:/producto";
		}
		if(producto.getPrecio() == null) {
			System.out.println("Precio no puede estar vacio");
			return "redirect:/producto";
		}
		if(producto.getStock() == null) {
			System.out.println("Stock no puede estar vacio");
			return "redirect:/producto";
		}
		return "producto.jsp";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("producto") Producto producto) {
		System.out.println("CREATE" + producto);
		ps.crearProducto(producto);
		return "redirect:/producto";
	}

	// ============================================
	// ==============DELETE=======================
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id) {
		System.out.println("eliminar la id:" + id);
		ps.deleteProducto(id);
		return "redirect:/producto";
	}
	// ============================================
	
	// ==================EDITAR================
	@RequestMapping(value = "/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("actualizar id: " + id);
		Producto producto = ps.buscarProducto(id);
		model.addAttribute("producto", producto);
		return "productoEditar.jsp";
	}
	// ============================================
	// ==================MODIFICAR==================
	@RequestMapping(value="/modificar", method= RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("venta") Producto producto) {
		ps.modificarProducto(producto);
		return "redirect:/producto";
	}
	//===============================================
}
