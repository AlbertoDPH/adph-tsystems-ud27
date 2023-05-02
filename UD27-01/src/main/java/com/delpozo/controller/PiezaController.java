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

import com.delpozo.dto.Pieza;
import com.delpozo.service.PiezaServiceImp;

@RestController
@RequestMapping("/api")
public class PiezaController {

	@Autowired
	PiezaServiceImp piezaServiceImp;

	@GetMapping("/piezas")
	public List<Pieza> listarPiezas() {
		return piezaServiceImp.listarPiezas();
	}

	@PostMapping("/piezas")
	public Pieza salvarPieza(@RequestBody Pieza pieza) {
		return piezaServiceImp.guardarPieza(pieza);
	}

	@GetMapping("/piezas/{id}")
	public Pieza piezaXID(@PathVariable(name = "id") int id) {
		return piezaServiceImp.piezaXID(id);
	}

	@PutMapping("/piezas/{id}")
	public Pieza actualizarPieza(@PathVariable(name = "id") int id, @RequestBody Pieza pieza) {

		Pieza piezaSeleccionada = new Pieza();
		Pieza piezaActualizada = new Pieza();

		piezaSeleccionada = piezaServiceImp.piezaXID(id);

		piezaSeleccionada.setId(pieza.getId());
		piezaSeleccionada.setNombre(pieza.getNombre());

		piezaActualizada = piezaServiceImp.actualizarPieza(piezaSeleccionada);

		return piezaActualizada;
	}

	@DeleteMapping("/piezas/{id}")
	public void eliminarPieza(@PathVariable(name = "id") int id) {
		piezaServiceImp.eliminarPieza(id);
	}
}
