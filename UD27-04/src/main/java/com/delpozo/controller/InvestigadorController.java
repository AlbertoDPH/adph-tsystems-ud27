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

import com.delpozo.dto.Investigador;
import com.delpozo.service.InvestigadorServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadorController {

	@Autowired
	InvestigadorServiceImpl investigadorServiceImpl;

	@GetMapping("/investigadores")
	public List<Investigador> listarInvestigador() {
		return investigadorServiceImpl.listarInvestigador();
	}

	@PostMapping("/investigadores")
	public Investigador salvarInvestigador(@RequestBody Investigador investigador) {
		return investigadorServiceImpl.guardarInvestigador(investigador);
	}

	@GetMapping("/investigadores/{dni}")
	public Investigador investigadorXID(@PathVariable(name = "id") String id) {

		Investigador investigador_xid = new Investigador();

		investigador_xid = investigadorServiceImpl.investigadorXID(id);

		System.out.println("Investigador XID: " + investigador_xid);

		return investigador_xid;
	}

	@PutMapping("/investigadores/{dni}")
	public Investigador actualizarInvestigador(@PathVariable(name = "id") String id,
			@RequestBody Investigador investigador) {

		Investigador investigador_seleccionado = new Investigador();
		Investigador investigador_actualizado = new Investigador();

		investigador_seleccionado = investigadorServiceImpl.investigadorXID(id);

		investigador_seleccionado.setNombreApellidos(investigador.getNombreApellidos());
		investigador_seleccionado.setFacultad(investigador.getFacultad());
		
		investigador_actualizado = investigadorServiceImpl.actualizarInvestigador(investigador_seleccionado);

		System.out.println("La investigador actualizada es: " + investigador_actualizado);

		return investigador_actualizado;
	}

	@DeleteMapping("/investigadores/{dni}")
	public void eliminarInvestigador(@PathVariable(name = "id") String id) {
		investigadorServiceImpl.eliminarInvestigador(id);
	}

}
