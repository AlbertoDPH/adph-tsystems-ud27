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

import com.delpozo.dto.Proyecto;
import com.delpozo.service.ProyectoServiceImpl;

@RestController
@RequestMapping("/")
public class ProyectoController {

	@Autowired
	ProyectoServiceImpl proyectoServiceImpl;

	@GetMapping("/proyecto")
	public List<Proyecto> listarProyecto() {
		return proyectoServiceImpl.listarProyecto();
	}

	@PostMapping("/proyecto")
	public Proyecto salvarProyecto(@RequestBody Proyecto proyecto) {
		return proyectoServiceImpl.guardarProyecto(proyecto);
	}

	@GetMapping("/proyecto/{id}")
	public Proyecto proyectoXID(@PathVariable(name = "id") String id) {

		Proyecto proyecto_xid = new Proyecto();

		proyecto_xid = proyectoServiceImpl.proyectoXID(id);

		System.out.println("Proyecto XID: " + proyecto_xid);

		return proyecto_xid;
	}

	@PutMapping("/proyecto/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name = "id") String id,
			@RequestBody Proyecto proyecto) {

		Proyecto proyecto_seleccionado = new Proyecto();
		Proyecto proyecto_actualizado = new Proyecto();

		proyecto_seleccionado = proyectoServiceImpl.proyectoXID(id);

		proyecto_seleccionado.setNombre(proyecto.getNombre());
		proyecto_seleccionado.setHoras(proyecto.getHoras());
		
		proyecto_actualizado = proyectoServiceImpl.actualizarProyecto(proyecto_seleccionado);

		System.out.println("La proyecto actualizada es: " + proyecto_actualizado);

		return proyecto_actualizado;
	}

	@DeleteMapping("/proyecto/{id}")
	public void eliminarProyecto(@PathVariable(name = "id") String id) {
		proyectoServiceImpl.eliminarProyecto(id);
	}

}
