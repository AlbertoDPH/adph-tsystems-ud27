package com.delpozo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delpozo.dao.IAsignadoDAO;
import com.delpozo.dto.Asignado;

@Service
public class AsignadoServiceImpl implements IAsignadoService{

	@Autowired
	IAsignadoDAO iAsignadoDAO;
	
	@Override
	public List<Asignado> listarAsignado() {
		
		return iAsignadoDAO.findAll();
	}

	@Override
	public Asignado guardarAsignado(Asignado asignado) {
		
		return iAsignadoDAO.save(asignado);
	}

	@Override
	public Asignado asignadoXID(String id) {
		
		return iAsignadoDAO.findById(id).get();
	}

	@Override
	public Asignado actualizarAsignado(Asignado asignado) {
	
		return iAsignadoDAO.save(asignado);
	}

	@Override
	public void eliminarAsignado(String id) {
	
		iAsignadoDAO.deleteById(id);
	}

}
