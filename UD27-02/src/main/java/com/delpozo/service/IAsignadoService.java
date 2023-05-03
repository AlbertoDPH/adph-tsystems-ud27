package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.Asignado;

public interface IAsignadoService {
	
	//Metodos del CRUD
		public List<Asignado> listarAsignado(); // Listar All

		public Asignado guardarAsignado(Asignado asignado); // Guarda un asignado CREATE

		public Asignado asignadoXID(String id); // Leer datos de un asignado READ

		public Asignado actualizarAsignado(Asignado asignado); // Actualiza datos del asignado UPDATE

		public void eliminarAsignado(String id);// Elimina el asignado DELETE

}
