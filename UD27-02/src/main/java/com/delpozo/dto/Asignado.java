package com.delpozo.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "asignado_a") // en caso que la tabla sea diferente
public class Asignado {

	// Atributos de la entidad asignado
	@EmbeddedId
	private AsignadoKey id;

	@ManyToOne
	@MapsId("dniCientifico")
	@JoinColumn(name = "dni", referencedColumnName = "dni", nullable = false)
	Cientifico cientifico;

	@ManyToOne
	@MapsId("idProyecto")
	@JoinColumn(name = "id_proyecto", referencedColumnName = "id", nullable = false)
	Proyecto proyecto;

	// Constructores

	public Asignado() {

	}

	/**
	 * 
	 * @param id
	 * @param cientifico
	 * @param proyecto
	 */
	public Asignado(AsignadoKey id, Cientifico cientifico, Proyecto proyecto) {
		this.id = id;
		this.cientifico = cientifico;
		this.proyecto = proyecto;
	}

	// Getters y Setters
	public AsignadoKey getId() {
		return id;
	}

	public void setId(AsignadoKey id) {
		this.id = id;
	}

	public Cientifico getCientifico() {
		return cientifico;
	}

	public void setCientifico(Cientifico cientifico) {
		this.cientifico = cientifico;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	// Metodo toString
	@Override
	public String toString() {
		return "Asignado [id=" + id + ", cientifico=" + cientifico + ", proyecto=" + proyecto + "]";
	}

}
