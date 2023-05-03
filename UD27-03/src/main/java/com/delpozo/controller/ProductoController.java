package com.delpozo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delpozo.dto.Producto;
import com.delpozo.service.ProductoServiceImpl;

@RestController
@RequestMapping("/")
public class ProductoController {

	@Autowired
	ProductoServiceImpl productoServiceImpl;

	@GetMapping("/productos")
	public List<Producto> listarProducto() {
		return productoServiceImpl.listarProducto();
		
	}

	@PostMapping("/productos")
	public Producto salvarProducto(@RequestBody Producto producto) {
		return productoServiceImpl.guardarProducto(producto);
	}

	@GetMapping("/productos/{codigo}")
	public Producto productoXID(@PathVariable(name = "codigo") Integer id) {

		Producto producto_xid = new Producto();

		producto_xid = productoServiceImpl.productoXID(id);

		System.out.println("Producto XID: " + producto_xid);

		return producto_xid;
	}

	@PutMapping("/productos/{codigo}")
	public Producto actualizarProducto(@PathVariable(name = "codigo") Integer id,
			@RequestBody Producto producto) {

		Producto producto_seleccionado = new Producto();
		Producto producto_actualizado = new Producto();

		producto_seleccionado = productoServiceImpl.productoXID(id);
	
		producto_seleccionado.setNombre(producto.getNombre());		
		producto_seleccionado.setPrecio(producto.getPrecio());
		
		producto_actualizado = productoServiceImpl.actualizarProducto(producto_seleccionado);

		System.out.println("La producto actualizada es: " + producto_actualizado);

		return producto_actualizado;
	}

	@DeleteMapping("/productos/{codigo}")
	public void eliminarProducto(@PathVariable(name = "codigo") Integer id) {
		productoServiceImpl.eliminarProducto(id);
	}

}
