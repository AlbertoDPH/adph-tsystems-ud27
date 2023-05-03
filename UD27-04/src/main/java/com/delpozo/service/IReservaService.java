package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.Reserva;

public interface IReservaService {
	
	//Metodos del CRUD
		public List<Reserva> listarReserva(); // Listar All

		public Reserva guardarReserva(Reserva reserva); // Guarda un reserva CREATE

		public Reserva reservaXID(Integer id); // Leer datos de un reserva READ

		public Reserva actualizarReserva(Reserva reserva); // Actualiza datos del reserva UPDATE

		public void eliminarReserva(Integer id);// Elimina el reserva DELETE

}
