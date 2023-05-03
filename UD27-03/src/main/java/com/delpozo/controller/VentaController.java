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

import com.delpozo.dto.Venta;
import com.delpozo.service.VentaServiceImpl;

@RestController
@RequestMapping("/")
public class VentaController {

	@Autowired
	VentaServiceImpl ventaServiceImpl;

	@GetMapping("/ventas")
	public List<Venta> listarVenta() {
		return ventaServiceImpl.listarVenta();
		
	}

	@PostMapping("/ventas")
	public Venta salvarVenta(@RequestBody Venta venta) {
		return ventaServiceImpl.guardarVenta(venta);
	}

	@GetMapping("/ventas/{codigo}")
	public Venta ventaXID(@PathVariable(name = "codigo") Integer id) {

		Venta venta_xid = new Venta();

		venta_xid = ventaServiceImpl.ventaXID(id);

		System.out.println("Venta XID: " + venta_xid);

		return venta_xid;
	}

	@PutMapping("/ventas/{codigo}")
	public Venta actualizarVenta(@PathVariable(name = "codigo") Integer id,
			@RequestBody Venta venta) {

		Venta venta_seleccionado = new Venta();
		Venta venta_actualizado = new Venta();

		venta_seleccionado = ventaServiceImpl.ventaXID(id);

		venta_seleccionado.setId(venta.getId());		
		venta_seleccionado.setProducto(venta.getProducto());
		venta_seleccionado.setCajero(venta.getCajero());
		venta_seleccionado.setMaquinaRegistradora(venta.getMaquinaRegistradora());
		
		venta_actualizado = ventaServiceImpl.actualizarVenta(venta_seleccionado);

		System.out.println("La venta actualizada es: " + venta_actualizado);

		return venta_actualizado;
	}

	@DeleteMapping("/ventas/{codigo}")
	public void eliminarVenta(@PathVariable(name = "codigo") Integer id) {
		ventaServiceImpl.eliminarVenta(id);
	}

}
