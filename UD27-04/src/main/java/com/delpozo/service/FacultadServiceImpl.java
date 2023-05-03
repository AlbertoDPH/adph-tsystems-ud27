package com.delpozo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delpozo.dao.IFacultadDAO;
import com.delpozo.dto.Facultad;

@Service
public class FacultadServiceImpl implements IFacultadService{

	@Autowired
	IFacultadDAO iFacultadDAO;
	
	@Override
	public List<Facultad> listarFacultad() {
		
		return iFacultadDAO.findAll();
	}

	@Override
	public Facultad guardarFacultad(Facultad facultad) {
		
		return iFacultadDAO.save(facultad);
	}

	@Override
	public Facultad facultadXID(String id) {
		
		return iFacultadDAO.findById(id).get();
	}

	@Override
	public Facultad actualizarFacultad(Facultad facultad) {
	
		return iFacultadDAO.save(facultad);
	}

	@Override
	public void eliminarFacultad(String id) {
	
		iFacultadDAO.deleteById(id);
	}

}
