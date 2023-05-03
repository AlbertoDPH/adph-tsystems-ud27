package com.delpozo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delpozo.dto.Equipo;

public interface IEquipoDAO extends JpaRepository<Equipo, Integer>{

}
