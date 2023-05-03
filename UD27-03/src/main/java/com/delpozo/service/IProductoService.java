package com.delpozo.service;

import java.util.List;

import com.delpozo.dto.Producto;

public interface IProductoService {
	
	//Metodos del CRUD
		public List<Producto> listarProducto(); // Listar All

		public Producto guardarProducto(Producto producto); // Guarda un producto CREATE

		public Producto productoXID(Integer id); // Leer datos de un producto READ

		public Producto actualizarProducto(Producto producto); // Actualiza datos del producto UPDATE

		public void eliminarProducto(Integer id);// Elimina el producto DELETE

}
