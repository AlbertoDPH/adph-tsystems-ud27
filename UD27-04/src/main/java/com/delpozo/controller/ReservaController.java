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

import com.delpozo.dto.Reserva;
import com.delpozo.service.ReservaServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservaController {

	@Autowired
	ReservaServiceImpl reservaServiceImpl;

	@GetMapping("/reserva")
	public List<Reserva> listarReserva() {
		return reservaServiceImpl.listarReserva();
	}

	@PostMapping("/reserva")
	public Reserva salvarReserva(@RequestBody Reserva reserva) {
		return reservaServiceImpl.guardarReserva(reserva);
	}

	@GetMapping("/reserva/{id}")
	public Reserva reservaXID(@PathVariable(name = "id") Integer id) {

		Reserva reserva_xid = new Reserva();

		reserva_xid = reservaServiceImpl.reservaXID(id);

		System.out.println("Reserva XID: " + reserva_xid);

		return reserva_xid;
	}

	@PutMapping("/reserva/{id}")
	public Reserva actualizarReserva(@PathVariable(name = "id") Integer id,
			@RequestBody Reserva reserva) {

		Reserva reserva_seleccionado = new Reserva();
		Reserva reserva_actualizado = new Reserva();

		reserva_seleccionado = reservaServiceImpl.reservaXID(id);

		reserva_seleccionado.setInvestigador(reserva.getInvestigador());
		reserva_seleccionado.setEquipo(reserva.getEquipo());
		reserva_seleccionado.setComienzo(reserva.getComienzo());
		reserva_seleccionado.setFin(reserva.getFin());
		
		reserva_actualizado = reservaServiceImpl.actualizarReserva(reserva_seleccionado);

		System.out.println("La reserva actualizada es: " + reserva_actualizado);

		return reserva_actualizado;
	}

	@DeleteMapping("/reserva/{id}")
	public void eliminarReserva(@PathVariable(name = "id") Integer id) {
		reservaServiceImpl.eliminarReserva(id);
	}

}
