package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.Equipo;

public interface IEquipoService {
	
	//Metodos del CRUD
		public List<Equipo> listarEquipo(); // Listar All

		public Equipo guardarEquipo(Equipo equipo); // Guarda un equipo CREATE

		public Equipo equipoXID(Integer id); // Leer datos de un equipo READ

		public Equipo actualizarEquipo(Equipo equipo); // Actualiza datos del equipo UPDATE

		public void eliminarEquipo(Integer id);// Elimina el equipo DELETE

}
