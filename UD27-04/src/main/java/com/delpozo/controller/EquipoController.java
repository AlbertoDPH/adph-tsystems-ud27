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

import com.delpozo.dto.Equipo;
import com.delpozo.service.EquipoServiceImpl;

@RestController
@RequestMapping("/api")
public class EquipoController {

	@Autowired
	EquipoServiceImpl equipoServiceImpl;

	@GetMapping("/equipos")
	public List<Equipo> listarEquipo() {
		return equipoServiceImpl.listarEquipo();
	}

	@PostMapping("/equipos")
	public Equipo salvarEquipo(@RequestBody Equipo equipo) {
		return equipoServiceImpl.guardarEquipo(equipo);
	}

	@GetMapping("/equipos/{num_serie}")
	public Equipo equipoXID(@PathVariable(name = "id") Integer id) {

		Equipo equipo_xid = new Equipo();

		equipo_xid = equipoServiceImpl.equipoXID(id);

		System.out.println("Equipo XID: " + equipo_xid);

		return equipo_xid;
	}

	@PutMapping("/equipos/{num_serie}")
	public Equipo actualizarEquipo(@PathVariable(name = "id") Integer id,
			@RequestBody Equipo equipo) {

		Equipo equipo_seleccionado = new Equipo();
		Equipo equipo_actualizado = new Equipo();

		equipo_seleccionado = equipoServiceImpl.equipoXID(id);

		equipo_seleccionado.setNombre(equipo.getNombre());
		equipo_seleccionado.setFacultad(equipo.getFacultad());
		
		equipo_actualizado = equipoServiceImpl.actualizarEquipo(equipo_seleccionado);

		System.out.println("La equipo actualizada es: " + equipo_actualizado);

		return equipo_actualizado;
	}

	@DeleteMapping("/equipos/{num_serie}")
	public void eliminarEquipo(@PathVariable(name = "id") Integer id) {
		equipoServiceImpl.eliminarEquipo(id);
	}

}
