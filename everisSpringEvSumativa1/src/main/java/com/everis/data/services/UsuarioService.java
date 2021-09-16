package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.everis.data.models.Usuario;
import com.everis.data.repositories.UsuarioRepository;
@Service
public class UsuarioService {

	private final UsuarioRepository ur;
	public UsuarioService(UsuarioRepository usuariorepository) {
		this.ur = usuariorepository;
	}
	
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

	public Usuario crearUsuario(@Valid Usuario usuario) {
		// TODO Auto-generated method stub
		ur.save(usuario);
		return usuario;
	}

	public void deleteUsuario(Long id) {
		// TODO Auto-generated method stub
		ur.deleteById(id);
	}

	public Usuario buscarUsuario(Long id) {
		// TODO Auto-generated method stub
		Optional<Usuario> oUsuario= ur.findById(id);
		if (oUsuario.isPresent()) {
			return oUsuario.get();
		}
		return null;
	}

	public void modificarUsuario(@Valid Usuario usuario) {
		// TODO Auto-generated method stub
		ur.save(usuario);
	}

}
