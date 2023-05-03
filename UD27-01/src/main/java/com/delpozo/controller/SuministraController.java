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

import com.delpozo.dto.Suministra;
import com.delpozo.service.SuministraServiceImpl;


@RestController
@RequestMapping("/api")
public class SuministraController {

	@Autowired
	SuministraServiceImpl suministraServiceImp;

	@GetMapping("/suministra")
	public List<Suministra> listarSuministras() {
		return suministraServiceImp.listarSuministras();
	}

	@PostMapping("/suministra")
	public Suministra salvarSuministra(@RequestBody Suministra suministra) {
		return suministraServiceImp.guardarSuministra(suministra);
	}

	@GetMapping("/suministra/{id}")
	public Suministra suministraXID(@PathVariable(name = "id") int id) {
		return suministraServiceImp.suministraXID(id);
	}

	@PutMapping("/suministra/{id}")
	public Suministra actualizarSuministra(@PathVariable(name = "id") int id, @RequestBody Suministra suministra) {

		Suministra suministraSeleccionada = new Suministra();
		Suministra suministraActualizada = new Suministra();

		suministraSeleccionada = suministraServiceImp.suministraXID(id);

		suministraSeleccionada.setId(suministra.getId());
		suministraSeleccionada.setPieza(suministra.getPieza());
		suministraSeleccionada.setProveedor(suministra.getProveedor());
		suministraSeleccionada.setPrecio(suministra.getPrecio());

		suministraActualizada = suministraServiceImp.actualizarSuministra(suministraSeleccionada);

		return suministraActualizada;
	}

	@DeleteMapping("/suministra/{id}")
	public void eliminarSuministra(@PathVariable(name = "id") int id) {
		suministraServiceImp.eliminarSuministra(id);
	}
}
