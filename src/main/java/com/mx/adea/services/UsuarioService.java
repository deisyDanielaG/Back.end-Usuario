package com.mx.adea.services;

import java.util.List;

import com.mx.adea.dominio.Usuario;

public interface UsuarioService {
	public void guardar(Usuario usuario);
	public void editar(Usuario usuario);
	public void eliminar(Usuario usuario);
	public Usuario buscar(Usuario usuario);
	public List<Usuario> listar();
	public List<Usuario> listarActivos();
	public List<Usuario> listarInactivos();
	public List<Usuario> listarRevocados();
	public List<Usuario> listarPorNombre(String nombre);
}
