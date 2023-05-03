package com.delpozo.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "proyecto") // en caso que la tabala sea diferente
public class Proyecto {

	// Atributos de entidad proyecto
	@Id
	private String id;
	private String nombre;
	private int horas;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Asignado> asignado;

	// Constructores

	public Proyecto() {

	}

	/**
	 * @param id
	 * @param nombre
	 * @param horas
	 * @param asignado
	 */
	public Proyecto(String id, String nombre, int horas, List<Asignado> asignado) {
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
		this.asignado = asignado;
	}

	// Getters y Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public void setAsignado(List<Asignado> asignado) {
		this.asignado = asignado;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proyecto")
	public List<Asignado> getAsignado() {
		return asignado;
	}

	// Metodo toString
	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", horas=" + horas + "]";
	}

}
