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

import com.delpozo.dto.Cientifico;
import com.delpozo.service.CientificoServiceImpl;

@RestController
@RequestMapping("/")
public class CientificoController {

	@Autowired
	CientificoServiceImpl cientificoServiceImpl;

	@GetMapping("/cientificos")
	public List<Cientifico> listarCientifico() {
		return cientificoServiceImpl.listarCientifico();
		
	}

	@PostMapping("/cientificos")
	public Cientifico salvarCientifico(@RequestBody Cientifico cientifico) {
		return cientificoServiceImpl.guardarCientifico(cientifico);
	}

	@GetMapping("/cientificos/{dni}")
	public Cientifico cientificoXID(@PathVariable(name = "dni") String id) {

		Cientifico cientifico_xid = new Cientifico();

		cientifico_xid = cientificoServiceImpl.cientificoXID(id);

		System.out.println("Cientifico XID: " + cientifico_xid);

		return cientifico_xid;
	}

	@PutMapping("/cientificos/{dni}")
	public Cientifico actualizarCientifico(@PathVariable(name = "dni") String id,
			@RequestBody Cientifico cientifico) {

		Cientifico cientifico_seleccionado = new Cientifico();
		Cientifico cientifico_actualizado = new Cientifico();

		cientifico_seleccionado = cientificoServiceImpl.cientificoXID(id);

		cientifico_seleccionado.setNomApel(cientifico.getNomApel());
		
		cientifico_actualizado = cientificoServiceImpl.actualizarCientifico(cientifico_seleccionado);

		System.out.println("La cientifico actualizada es: " + cientifico_actualizado);

		return cientifico_actualizado;
	}

	@DeleteMapping("/cientificos/{dni}")
	public void eliminarCientifico(@PathVariable(name = "dni") String id) {
		cientificoServiceImpl.eliminarCientifico(id);
	}

}
