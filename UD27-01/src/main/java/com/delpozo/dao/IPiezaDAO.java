package com.delpozo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delpozo.dto.Pieza;


public interface IPiezaDAO extends JpaRepository<Pieza, Integer> {

}
