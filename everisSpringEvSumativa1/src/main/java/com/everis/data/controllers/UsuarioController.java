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

import com.everis.data.models.Usuario;
import com.everis.data.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final UsuarioService us;
	
	public UsuarioController(UsuarioService ususarioservice) {
		this.us = ususarioservice;
	}
	// =================CREAR====================
	// PASAR ENTIDA A JSP
	@RequestMapping("")
	public String index(@ModelAttribute("usuario") Usuario usuario, Model model) {
		System.out.println("INDEX");
		List<Usuario> lista_usuarios = us.findAll();
		model.addAttribute("lista_usuarios", lista_usuarios);
		return "usuario.jsp";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("usuario") Usuario usuario) {
		System.out.println("CREATE" + usuario);
		if(usuario.getNombre().isBlank() || usuario.getNombre().isEmpty()) {
			System.out.println("Nombre no puede estar vacio");
			return "redirect:/usuario";
		}
		if(usuario.getRut().isBlank() || usuario.getRut().isEmpty()) {
			System.out.println("Rut  no puede estar vacio");
			return "redirect:/usuario";
		}
		if(usuario.getApellido().isBlank() || usuario.getApellido().isEmpty()) {
			System.out.println("Apellido  no puede estar vacio");
			return "redirect:/usuario";
		}
		if(usuario.getCorreo().isBlank() || usuario.getCorreo().isEmpty()) {
			System.out.println("Correo no puede estar vacio");
			return "redirect:/usuario";
		}
		if(usuario.getEdad() == null) {
			System.out.println("Edad no puede estar vacio");
			return "redirect:/usuario";
		}
		us.crearUsuario(usuario);
		return "redirect:/usuario";
	}

	// ============================================
	// ==============DELETE=======================
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id) {
		System.out.println("eliminar la id:" + id);
		us.deleteUsuario(id);
		return "redirect:/usuario";
	}
	// ============================================
	
	// ==================EDITAR================
	@RequestMapping(value = "/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("actualizar id: " + id);
		
		
		Usuario usuario = us.buscarUsuario(id);
		model.addAttribute("usuario", usuario);
		return "usuarioEditar.jsp";
	}
	// ============================================
	// ==================MODIFICAR==================
	@RequestMapping(value="/modificar", method= RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("usuario") Usuario usuario) {
		us.modificarUsuario(usuario);
		if(usuario.getNombre().isBlank() || usuario.getNombre().isEmpty()) {
			System.out.println("Nombre no puede estar vacio");
			return "redirect:/usuario";
		}
		if( usuario.getRut().isEmpty()) {
			System.out.println("Rut  no puede estar vacio");
			return "redirect:/usuario";
		}
		if(usuario.getApellido().isBlank() || usuario.getApellido().isEmpty()) {
			System.out.println("Apellido  no puede estar vacio");
			return "redirect:/usuario";
		}
		if(usuario.getCorreo().isBlank() || usuario.getCorreo().isEmpty()) {
			System.out.println("Correo no puede estar vacio");
			return "redirect:/usuario";
		}
		if(usuario.getEdad() == null) {
			System.out.println("Edad no puede estar vacio");
			return "redirect:/usuario";
		}
		return "redirect:/usuario";
	}
	//===============================================
}
