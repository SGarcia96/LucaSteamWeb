package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Juego;

@Repository
public interface JuegoDAO extends JpaRepository<Juego, Integer>{
	
	public void cargarJuegos();
}
