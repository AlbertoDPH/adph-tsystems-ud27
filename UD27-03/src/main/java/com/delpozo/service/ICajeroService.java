package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.Cajero;

public interface ICajeroService {
	
	//Metodos del CRUD
		public List<Cajero> listarCajero(); // Listar All

		public Cajero guardarCajero(Cajero cajero); // Guarda un cajero CREATE

		public Cajero cajeroXID(Integer id); // Leer datos de un cajero READ

		public Cajero actualizarCajero(Cajero cajero); // Actualiza datos del cajero UPDATE

		public void eliminarCajero(Integer id);// Elimina el cajero DELETE

}
