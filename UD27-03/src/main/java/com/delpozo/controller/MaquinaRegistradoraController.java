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

import com.delpozo.dto.MaquinaRegistradora;
import com.delpozo.service.MaquinaRegistradoraServiceImpl;

@RestController
@RequestMapping("/")
public class MaquinaRegistradoraController {

	@Autowired
	MaquinaRegistradoraServiceImpl maquinaRegistradoraServiceImpl;

	@GetMapping("/maquina_registradoras")
	public List<MaquinaRegistradora> listarMaquinaRegistradora() {
		return maquinaRegistradoraServiceImpl.listarMaquinaRegistradora();
		
	}

	@PostMapping("/maquina_registradoras")
	public MaquinaRegistradora salvarMaquinaRegistradora(@RequestBody MaquinaRegistradora maquinaRegistradora) {
		return maquinaRegistradoraServiceImpl.guardarMaquinaRegistradora(maquinaRegistradora);
	}

	@GetMapping("/maquina_registradoras/{codigo}")
	public MaquinaRegistradora maquinaRegistradoraXID(@PathVariable(name = "codigo") Integer id) {

		MaquinaRegistradora maquinaRegistradora_xid = new MaquinaRegistradora();

		maquinaRegistradora_xid = maquinaRegistradoraServiceImpl.maquinaRegistradoraXID(id);

		System.out.println("MaquinaRegistradora XID: " + maquinaRegistradora_xid);

		return maquinaRegistradora_xid;
	}

	@PutMapping("/maquina_registradoras/{codigo}")
	public MaquinaRegistradora actualizarMaquinaRegistradora(@PathVariable(name = "codigo") Integer id,
			@RequestBody MaquinaRegistradora maquinaRegistradora) {

		MaquinaRegistradora maquinaRegistradora_seleccionado = new MaquinaRegistradora();
		MaquinaRegistradora maquinaRegistradora_actualizado = new MaquinaRegistradora();

		maquinaRegistradora_seleccionado = maquinaRegistradoraServiceImpl.maquinaRegistradoraXID(id);

		maquinaRegistradora_seleccionado.setPiso(maquinaRegistradora.getPiso());		
		
		maquinaRegistradora_actualizado = maquinaRegistradoraServiceImpl.actualizarMaquinaRegistradora(maquinaRegistradora_seleccionado);

		System.out.println("La maquinaRegistradora actualizada es: " + maquinaRegistradora_actualizado);

		return maquinaRegistradora_actualizado;
	}

	@DeleteMapping("/maquina_registradoras/{codigo}")
	public void eliminarMaquinaRegistradora(@PathVariable(name = "codigo") Integer id) {
		maquinaRegistradoraServiceImpl.eliminarMaquinaRegistradora(id);
	}

}
