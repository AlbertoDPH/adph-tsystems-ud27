package com.delpozo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ventas") // en caso que la tabala sea diferente
public class Venta {

	// Atributos de entidad venta
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "id_cajero")
	private Cajero cajero;

	@ManyToOne
	@JoinColumn(name = "id_maquina")
	private MaquinaRegistradora maquinaRegistradora;

	// Constructores

	public Venta() {

	}

	/**
	 * 
	 * @param id
	 * @param producto
	 * @param cajero
	 * @param maquinaRegistradora
	 */
	public Venta(int id, Producto producto, Cajero cajero, MaquinaRegistradora maquinaRegistradora) {
		this.id = id;
		this.producto = producto;
		this.cajero = cajero;
		this.maquinaRegistradora = maquinaRegistradora;
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Cajero getCajero() {
		return cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	public MaquinaRegistradora getMaquinaRegistradora() {
		return maquinaRegistradora;
	}

	public void setMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora) {
		this.maquinaRegistradora = maquinaRegistradora;

	}

	// Metodo toString
	@Override
	public String toString() {
		return "Venta [id=" + id + ", producto=" + producto + ", cajero=" + cajero + ", maquinaRegistradora="
				+ maquinaRegistradora + "]";
	}
}
