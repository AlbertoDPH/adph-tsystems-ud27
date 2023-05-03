package com.delpozo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delpozo.dao.IProyectoDAO;
import com.delpozo.dto.Proyecto;

@Service
public class ProyectoServiceImpl implements IProyectoService{

	@Autowired
	IProyectoDAO iProyectoDAO;
	
	@Override
	public List<Proyecto> listarProyecto() {
		
		return iProyectoDAO.findAll();
	}

	@Override
	public Proyecto guardarProyecto(Proyecto proyecto) {
		
		return iProyectoDAO.save(proyecto);
	}

	@Override
	public Proyecto proyectoXID(String id) {
		
		return iProyectoDAO.findById(id).get();
	}

	@Override
	public Proyecto actualizarProyecto(Proyecto proyecto) {
	
		return iProyectoDAO.save(proyecto);
	}

	@Override
	public void eliminarProyecto(String id) {
	
		iProyectoDAO.deleteById(id);
	}

}
