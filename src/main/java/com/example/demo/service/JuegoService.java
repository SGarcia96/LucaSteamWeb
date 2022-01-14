package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.Juego;

public interface JuegoService {


	public Juego save(Juego juego);
	public void deleteById(int id);
	
	public Optional <Juego> findById(int id);
	public Optional <Juego> findByFabricante(String fabricante);
	public Optional <Juego> findByGenero(String genero);
}
