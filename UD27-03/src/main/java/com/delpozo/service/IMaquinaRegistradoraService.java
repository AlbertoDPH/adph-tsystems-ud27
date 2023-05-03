package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.MaquinaRegistradora;

public interface IMaquinaRegistradoraService {
	
	//Metodos del CRUD
		public List<MaquinaRegistradora> listarMaquinaRegistradora(); // Listar All

		public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora); // Guarda un maquinaRegistradora CREATE

		public MaquinaRegistradora maquinaRegistradoraXID(Integer id); // Leer datos de un maquinaRegistradora READ

		public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora); // Actualiza datos del maquinaRegistradora UPDATE

		public void eliminarMaquinaRegistradora(Integer id);// Elimina el maquinaRegistradora DELETE

}
