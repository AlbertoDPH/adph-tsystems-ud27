package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.Investigador;

public interface IInvestigadorService {
	
	//Metodos del CRUD
		public List<Investigador> listarInvestigador(); // Listar All

		public Investigador guardarInvestigador(Investigador investigador); // Guarda un investigador CREATE

		public Investigador investigadorXID(String id); // Leer datos de un investigador READ

		public Investigador actualizarInvestigador(Investigador investigador); // Actualiza datos del investigador UPDATE

		public void eliminarInvestigador(String id);// Elimina el investigador DELETE

}
