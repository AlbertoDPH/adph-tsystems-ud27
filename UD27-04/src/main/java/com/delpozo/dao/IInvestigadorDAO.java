package com.delpozo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delpozo.dto.Investigador;

public interface IInvestigadorDAO extends JpaRepository<Investigador, String>{

}
