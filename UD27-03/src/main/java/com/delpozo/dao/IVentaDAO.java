package com.delpozo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delpozo.dto.Venta;

public interface IVentaDAO extends JpaRepository<Venta, Integer>{

}
