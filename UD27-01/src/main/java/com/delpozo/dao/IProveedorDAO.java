package com.delpozo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delpozo.dto.Proveedor;


public interface IProveedorDAO extends JpaRepository<Proveedor, String> {

}
