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

import com.delpozo.dto.Proveedor;
import com.delpozo.service.ProveedorServiceImp;
 

@RestController
@RequestMapping("/api")
public class ProveedorController {

	@Autowired
	ProveedorServiceImp proveedorServiceImp;

	@GetMapping("/proveedores")
	public List<Proveedor> listarProveedors() {
		return proveedorServiceImp.listarProveedors();
	}

	@PostMapping("/proveedores")
	public Proveedor salvarProveedor(@RequestBody Proveedor proveedor) {
		return proveedorServiceImp.guardarProveedor(proveedor);
	}

	@GetMapping("/proveedores/{id}")
	public Proveedor proveedorXID(@PathVariable(name = "id") String id) {
		return proveedorServiceImp.proveedorXID(id);
	}

	@PutMapping("/proveedores/{id}")
	public Proveedor actualizarProveedor(@PathVariable(name = "id") String id, @RequestBody Proveedor proveedor) {

		Proveedor proveedorSeleccionado = new Proveedor();
		Proveedor proveedorActualizado = new Proveedor();

		proveedorSeleccionado = proveedorServiceImp.proveedorXID(id);

		proveedorSeleccionado.setId(proveedor.getId());
		proveedorSeleccionado.setNombre(proveedor.getNombre());

		proveedorActualizado = proveedorServiceImp.actualizarProveedor(proveedorSeleccionado);

		return proveedorActualizado;
	}

	@DeleteMapping("/proveedores/{id}")
	public void eliminarProveedor(@PathVariable(name = "id") String id) {
		proveedorServiceImp.eliminarProveedor(id);
	}
}
