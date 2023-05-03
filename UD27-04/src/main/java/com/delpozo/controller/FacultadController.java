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

import com.delpozo.dto.Facultad;
import com.delpozo.service.FacultadServiceImpl;

@RestController
@RequestMapping("/api")
public class FacultadController {

	@Autowired
	FacultadServiceImpl facultadServiceImpl;

	@GetMapping("/facultad")
	public List<Facultad> listarFacultad() {
		return facultadServiceImpl.listarFacultad();
	}

	@PostMapping("/facultad")
	public Facultad salvarFacultad(@RequestBody Facultad facultad) {
		return facultadServiceImpl.guardarFacultad(facultad);
	}

	@GetMapping("/facultad/{codigo}")
	public Facultad facultadXID(@PathVariable(name = "codigo") String id) {

		Facultad facultad_xid = new Facultad();

		facultad_xid = facultadServiceImpl.facultadXID(id);

		System.out.println("Facultad XID: " + facultad_xid);

		return facultad_xid;
	}

	@PutMapping("/facultad/{codigo}")
	public Facultad actualizarFacultad(@PathVariable(name = "codigo") String id,
			@RequestBody Facultad facultad) {

		Facultad facultad_seleccionado = new Facultad();
		Facultad facultad_actualizado = new Facultad();

		facultad_seleccionado = facultadServiceImpl.facultadXID(id);

		facultad_seleccionado.setNombre(facultad.getNombre());
		
		facultad_actualizado = facultadServiceImpl.actualizarFacultad(facultad_seleccionado);

		System.out.println("La facultad actualizada es: " + facultad_actualizado);

		return facultad_actualizado;
	}

	@DeleteMapping("/facultad/{codigo}")
	public void eliminarFacultad(@PathVariable(name = "codigo") String id) {
		facultadServiceImpl.eliminarFacultad(id);
	}

}
