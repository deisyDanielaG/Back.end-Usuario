package com.mx.adea.dominio;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="USUARIO")
@ToString
@Getter
@Setter
public class Usuario {
	/*
	LOGIN VARCHAR2(20) PRIMARY KEY NOT NULL,
	PASSWORD VARCHAR2(30) NOT NULL,
	NOMBRE VARCHAR2(50) NOT NULL,
	CLIENTE FLOAT NOT NULL,
	EMAIL VARCHAR2(50),
	FECHAALTA DATE DEFAULT SYSDATE NOT NULL,
	FECHABAJA DATE,
	STATUS CHAR(1) DEFAULT 'A' NOT NULL,
	INTENTOS FLOAT DEFAULT 0 NOT NULL,
	FECHAREVOCADO DATE,
	FECHA_VIGENCIA DATE,
	NO_ACCESO INTEGER,
	APELLIDO_PATERNO VARCHAR2(20),
	APELLIDO_MATERNO VARCHAR2(20),
	AREA NUMBER(4),
	FECHAMODIFICACION DATE */
	@Id
	@Column (name="LOGIN")
	String login;
	
	@Column (name="PASSWORD")
	String password;
	
	@Column (name="NOMBRE")
	String nombre;
	
	@Column (name="CLIENTE")
	float cliente;
	
	@Column (name="EMAIL")
	String email;
	
	@Column (name="FECHAALTA")
	Date fechaAlta;
	
	@Column (name="FECHABAJA")
	Date fechaBaja;
	
	@Column (name="STATUS")
	char status;
	
	@Column (name="INTENTOS")
	float intentos;
	
	@Column(name="FECHAREVOCADO")
	Date fechaRevocado;
	
	@Column (name="FECHA_VIGENCIA")
	Date fechaVigencia;
	
	@Column (name="NO_ACCESO")
	Integer noAcceso;
	
	@Column (name="APELLIDO_PATERNO")
	String apellidoPaterno;
	
	@Column (name="APELLIDO_MATERNO")
	String apellidoMaterno;
	
	@Column(name="AREA")
	Integer area;
	
	@Column (name="FECHAMODIFICACION")
	Date fechaModificacion;
	
	public Usuario() {
	}

	public Usuario(String login, String password, String nombre, int cliente) {
		LocalDate d = LocalDate.now();
		this.login = login;
		this.password=password;
		this.nombre=nombre;
		this.cliente=cliente;
		this.fechaAlta=java.sql.Date.valueOf(d);
		this.status='A';
		this.intentos=0;
		this.fechaModificacion=java.sql.Date.valueOf(d);;
		
	}

	public Usuario(String login, String password, String nombre, float cliente, String email, Date fechaAlta,
			Date fechaBaja, char status, float intentos, Date fechaRevocado, Date fechaVigencia, int noAcceso,
			String apellidoPaterno, String apellidoMaterno, int area, Date fechaModificacion) {
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		this.cliente = cliente;
		this.email = email;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.status = status;
		this.intentos = intentos;
		this.fechaRevocado = fechaRevocado;
		this.fechaVigencia = fechaVigencia;
		this.noAcceso = noAcceso;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.area = area;
		this.fechaModificacion = fechaModificacion;
	}

}
