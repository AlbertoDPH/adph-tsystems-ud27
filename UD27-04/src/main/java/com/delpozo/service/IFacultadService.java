package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.Facultad;

public interface IFacultadService {
	
	//Metodos del CRUD
		public List<Facultad> listarFacultad(); // Listar All

		public Facultad guardarFacultad(Facultad facultad); // Guarda un facultad CREATE

		public Facultad facultadXID(String id); // Leer datos de un facultad READ

		public Facultad actualizarFacultad(Facultad facultad); // Actualiza datos del facultad UPDATE

		public void eliminarFacultad(String id);// Elimina el facultad DELETE

}
