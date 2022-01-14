package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Juego;

public interface JuegoService {

	public Juego save(Juego juego);
	
	public void deleteById(int id);
	
	public List<Juego> findAll();
	
	public void cargarJuegos();
	
	public Optional <Juego> findById(int id);
	
	public List<Juego> findAllByFabricante(String fabricante);

}
