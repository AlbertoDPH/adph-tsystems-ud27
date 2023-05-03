package com.delpozo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delpozo.dao.IEquipoDAO;
import com.delpozo.dto.Equipo;

@Service
public class EquipoServiceImpl implements IEquipoService{

	@Autowired
	IEquipoDAO iEquipoDAO;
	
	@Override
	public List<Equipo> listarEquipo() {
		
		return iEquipoDAO.findAll();
	}

	@Override
	public Equipo guardarEquipo(Equipo equipo) {
		
		return iEquipoDAO.save(equipo);
	}

	@Override
	public Equipo equipoXID(Integer id) {
		
		return iEquipoDAO.findById(id).get();
	}

	@Override
	public Equipo actualizarEquipo(Equipo equipo) {
	
		return iEquipoDAO.save(equipo);
	}

	@Override
	public void eliminarEquipo(Integer id) {
	
		iEquipoDAO.deleteById(id);
	}

}
