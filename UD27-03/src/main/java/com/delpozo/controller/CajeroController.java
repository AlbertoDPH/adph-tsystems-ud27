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

import com.delpozo.dto.Cajero;
import com.delpozo.service.CajeroServiceImpl;

@RestController
@RequestMapping("/")
public class CajeroController {

	@Autowired
	CajeroServiceImpl cajeroServiceImpl;

	@GetMapping("/cajeros")
	public List<Cajero> listarCajero() {
		return cajeroServiceImpl.listarCajero();
		
	}

	@PostMapping("/cajeros")
	public Cajero salvarCajero(@RequestBody Cajero cajero) {
		return cajeroServiceImpl.guardarCajero(cajero);
	}

	@GetMapping("/cajeros/{codigo}")
	public Cajero cajeroXID(@PathVariable(name = "codigo") Integer id) {

		Cajero cajero_xid = new Cajero();

		cajero_xid = cajeroServiceImpl.cajeroXID(id);

		System.out.println("Cajero XID: " + cajero_xid);

		return cajero_xid;
	}

	@PutMapping("/cajeros/{codigo}")
	public Cajero actualizarCajero(@PathVariable(name = "codigo") Integer id,
			@RequestBody Cajero cajero) {

		Cajero cajero_seleccionado = new Cajero();
		Cajero cajero_actualizado = new Cajero();

		cajero_seleccionado = cajeroServiceImpl.cajeroXID(id);

		cajero_seleccionado.setCodigo(cajero.getCodigo());	
		cajero_seleccionado.setNom_apelis(cajero.getNom_apelis());	
		
		cajero_actualizado = cajeroServiceImpl.actualizarCajero(cajero_seleccionado);

		System.out.println("La cajero actualizada es: " + cajero_actualizado);

		return cajero_actualizado;
	}

	@DeleteMapping("/cajeros/{codigo}")
	public void eliminarCajero(@PathVariable(name = "codigo") Integer id) {
		cajeroServiceImpl.eliminarCajero(id);
	}

}
