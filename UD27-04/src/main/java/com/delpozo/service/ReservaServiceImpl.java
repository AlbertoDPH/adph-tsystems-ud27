package com.delpozo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delpozo.dao.IReservaDAO;
import com.delpozo.dto.Reserva;

@Service
public class ReservaServiceImpl implements IReservaService{

	@Autowired
	IReservaDAO iReservaDAO;
	
	@Override
	public List<Reserva> listarReserva() {
		
		return iReservaDAO.findAll();
	}

	@Override
	public Reserva guardarReserva(Reserva reserva) {
		
		return iReservaDAO.save(reserva);
	}

	@Override
	public Reserva reservaXID(Integer id) {
		
		return iReservaDAO.findById(id).get();
	}

	@Override
	public Reserva actualizarReserva(Reserva reserva) {
	
		return iReservaDAO.save(reserva);
	}

	@Override
	public void eliminarReserva(Integer id) {
	
		iReservaDAO.deleteById(id);
	}

}
