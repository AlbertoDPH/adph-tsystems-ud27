package com.delpozo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.delpozo.dto.Reserva;

public interface IReservaDAO extends JpaRepository<Reserva, Integer>{

}
