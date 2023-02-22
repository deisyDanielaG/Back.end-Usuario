package com.mx.adea.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.adea.dominio.Usuario;
import com.mx.adea.services.UsuarioService;

@RestController
@RequestMapping("Usuario")
@CrossOrigin
public class UsuarioWs {

	@Autowired
	UsuarioService usuarioService;
	
	// http://localhost:8015/Usuario/listar
	@GetMapping("listar")
	public List<Usuario> listar(){
		var lista=usuarioService.listar();
		return lista;
	}
	
	@GetMapping("listarActivos")
	public List<Usuario> listarActivos(){
		var lista=usuarioService.listarActivos();
		return lista;
	}
	
	@GetMapping("listarInactivos")
	public List<Usuario> listarInactivos(){
		var lista=usuarioService.listarInactivos();
		return lista;
	}
	
	@GetMapping("listarRevocados")
	public List<Usuario> listarRevocados(){
		var lista=usuarioService.listarRevocados();
		return lista;
	}
	
	@GetMapping("buscarPorNombre/{nombre}")
	public List<Usuario> buscarPorNombre(@PathVariable("nombre")String nombre){
		var lista=usuarioService.listarPorNombre(nombre);
		return lista;
	}
		
	@PostMapping("buscar")
	public Usuario buscar(@RequestBody Usuario usuario) {
		usuario=usuarioService.buscar(usuario);
		return usuario;
	}
	
	@PostMapping("guardar")
	public void guardar(@RequestBody Usuario usuario) {
		LocalDate d = LocalDate.now();
		usuario.setFechaAlta(java.sql.Date.valueOf(d));
		usuario.setFechaModificacion(java.sql.Date.valueOf(d));
		usuario.setStatus('A');
		usuario.setIntentos(0);
		usuarioService.guardar(usuario);
	}
	
	@PostMapping("editar")
	public void editar(@RequestBody Usuario usuario) {
		LocalDate d = LocalDate.now();
		usuario.setFechaModificacion(java.sql.Date.valueOf(d));
		usuarioService.editar(usuario);
	}
	
	@PostMapping("eliminar")
	public void eliminar(@RequestBody Usuario usuario) {
		usuarioService.eliminar(usuario);
	}
}
