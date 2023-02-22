package com.mx.adea.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.adea.dao.UsuarioDao;
import com.mx.adea.dominio.Usuario;


@Service
public class UsuarioServImpl implements UsuarioService{
	@Autowired
	UsuarioDao usuarioDao;

	@Override
	public void guardar(Usuario usuario) {
		usuarioDao.save(usuario);
		//usuario.setNombre(usuario.getNombre());
	}

	@Override
	public void editar(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	@Override
	public void eliminar(Usuario usuario) {
		usuarioDao.delete(usuario);
	}

	@Override
	public Usuario buscar(Usuario usuario) { //Busca por login
		return usuarioDao.findById(usuario.getLogin()).orElse(null);
	}

	@Override
	public List<Usuario> listar() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	public List<Usuario> listarActivos() {
		return (List<Usuario>) usuarioDao.findByStatus('A');
	}

	@Override
	public List<Usuario> listarInactivos() {
		return (List<Usuario>) usuarioDao.findByStatus('B');
	}

	@Override
	public List<Usuario> listarRevocados() {
		return (List<Usuario>) usuarioDao.findByStatus('R');
	}
	
	@Override
	public List<Usuario> listarPorNombre(String nombre) {
		return (List<Usuario>) usuarioDao.findByNombre(nombre);
	}

}
