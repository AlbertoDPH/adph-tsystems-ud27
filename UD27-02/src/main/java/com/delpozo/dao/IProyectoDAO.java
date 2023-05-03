package com.delpozo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delpozo.dto.Proyecto;

public interface IProyectoDAO extends JpaRepository<Proyecto, String>{

}
