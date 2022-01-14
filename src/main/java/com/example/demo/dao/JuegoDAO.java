package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Juego;

@Repository
public interface JuegoDAO extends JpaRepository<Juego, Integer>{
	
	public void cargarJuegos();

	public Optional<Juego> findByFabricante(String fabricante);

	public Optional<Juego> findByGenero(String genero);
}
