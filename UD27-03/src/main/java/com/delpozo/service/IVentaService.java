package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.Venta;

public interface IVentaService {
	
	//Metodos del CRUD
		public List<Venta> listarVenta(); // Listar All

		public Venta guardarVenta(Venta venta); // Guarda un venta CREATE

		public Venta ventaXID(Integer id); // Leer datos de un venta READ

		public Venta actualizarVenta(Venta venta); // Actualiza datos del venta UPDATE

		public void eliminarVenta(Integer id);// Elimina el venta DELETE

}
