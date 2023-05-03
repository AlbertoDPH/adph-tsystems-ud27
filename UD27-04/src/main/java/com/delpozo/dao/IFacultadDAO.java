package com.delpozo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delpozo.dto.Facultad;

public interface IFacultadDAO extends JpaRepository<Facultad, String>{

}
