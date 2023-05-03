package com.delpozo.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 

@Entity
@Table(name = "reserva") // en caso que la tabla sea diferente
public class Reserva {

	// Atributos de la entidad reserva
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_investigador")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Investigador investigador;

	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "id_equipo")
	private Equipo equipo;

	@Column(name = "comienzo")
	private LocalDateTime comienzo;

	@Column(name = "fin")
	private LocalDateTime fin;

	// Constructores

	public Reserva() {

	}

	/**
	 * 
	 * @param id
	 * @param investigador
	 * @param equipo
	 * @param comienzo
	 * @param fin
	 */
	public Reserva(int id, Investigador investigador, Equipo equipo, LocalDateTime comienzo, LocalDateTime fin) {
		this.id = id;
		this.investigador = investigador;
		this.equipo = equipo;
		this.comienzo = comienzo;
		this.fin = fin;
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public LocalDateTime getComienzo() {
		return comienzo;
	}

	public void setComienzo(LocalDateTime comienzo) {
		this.comienzo = comienzo;
	}

	public LocalDateTime getFin() {
		return fin;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}

	// Metodo toString
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", investigador=" + investigador + ", equipo=" + equipo + ", comienzo=" + comienzo
				+ ", fin=" + fin + "]";
	}

}
