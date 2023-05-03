package com.delpozo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delpozo.dao.IProductoDAO;
import com.delpozo.dto.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	IProductoDAO iProductoDAO;
	
	@Override
	public List<Producto> listarProducto() {
		
		return iProductoDAO.findAll();
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		
		return iProductoDAO.save(producto);
	}

	@Override
	public Producto productoXID(Integer id) {
		
		return iProductoDAO.findById(id).get();
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
	
		return iProductoDAO.save(producto);
	}

	@Override
	public void eliminarProducto(Integer id) {
	
		iProductoDAO.deleteById(id);
	}

}
