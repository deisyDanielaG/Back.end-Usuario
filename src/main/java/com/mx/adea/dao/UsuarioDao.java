package com.mx.adea.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mx.adea.dominio.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, String> {
	public List<Usuario> findByStatus(char status);
	public List<Usuario> findByNombre(String nombre);
}
