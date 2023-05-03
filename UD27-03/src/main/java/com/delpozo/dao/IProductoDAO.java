package com.delpozo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delpozo.dto.Producto;

public interface IProductoDAO extends JpaRepository<Producto, Integer>{

}
