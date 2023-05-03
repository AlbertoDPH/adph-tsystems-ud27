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

import com.delpozo.dto.Asignado;
import com.delpozo.service.AsignadoServiceImpl;

@RestController
@RequestMapping("/")
public class AsignadoController {

	@Autowired
	AsignadoServiceImpl asignadoServiceImpl;

	@GetMapping("/asignado_a")
	public List<Asignado> listarAsignado() {
		return asignadoServiceImpl.listarAsignado();
	}

	@PostMapping("/asignado_a")
	public Asignado salvarAsignado(@RequestBody Asignado asignado) {
		return asignadoServiceImpl.guardarAsignado(asignado);
	}

	@GetMapping("/asignado_a/{dni}")
	public Asignado asignadoXID(@PathVariable(name = "dni") String id) {

		Asignado asignado_xid = new Asignado();

		asignado_xid = asignadoServiceImpl.asignadoXID(id);

		System.out.println("Asignado XID: " + asignado_xid);

		return asignado_xid;
	}

	@PutMapping("/asignado_a/{dni}")
	public Asignado actualizarAsignado(@PathVariable(name = "dni") String id,
			@RequestBody Asignado asignado) {

		Asignado asignado_seleccionado = new Asignado();
		Asignado asignado_actualizado = new Asignado();

		asignado_seleccionado = asignadoServiceImpl.asignadoXID(id);

		asignado_seleccionado.setCientifico(asignado.getCientifico());
		asignado_seleccionado.setProyecto(asignado.getProyecto());
		
		asignado_actualizado = asignadoServiceImpl.actualizarAsignado(asignado_seleccionado);

		System.out.println("La asignado actualizada es: " + asignado_actualizado);

		return asignado_actualizado;
	}

	@DeleteMapping("/asignado_a/{dni}")
	public void eliminarAsignado(@PathVariable(name = "dni") String id) {
		asignadoServiceImpl.eliminarAsignado(id);
	}

}
