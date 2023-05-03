package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.Proyecto;

public interface IProyectoService {
	
	//Metodos del CRUD
		public List<Proyecto> listarProyecto(); // Listar All

		public Proyecto guardarProyecto(Proyecto proyecto); // Guarda un proyecto CREATE

		public Proyecto proyectoXID(String id); // Leer datos de un proyecto READ

		public Proyecto actualizarProyecto(Proyecto proyecto); // Actualiza datos del proyecto UPDATE

		public void eliminarProyecto(String id);// Elimina el proyecto DELETE

}
