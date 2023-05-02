package com.delpozo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "suministra")
public class Suministra {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "precio")
	private int precio;

	@ManyToOne
	@JoinColumn(name = "pieza_id")
	private Pieza pieza;

	@ManyToOne
	@JoinColumn(name = "proveedor_id")
	private Proveedor proveedor;

	// Constructores
	public Suministra() {

	}

	public Suministra(int id, Pieza pieza, Proveedor proveedor, int precio) {
		this.id = id;
		this.pieza = pieza;
		this.proveedor = proveedor;
		this.precio = precio;
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public int getPrecio() {
		return precio;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	// Metodo toString
	@Override
	public String toString() {
		return "Suministra [id=" + id + ", pieza=" + pieza + ", proveedor=" + proveedor + "]";
	}

}
