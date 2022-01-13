package com.example.demo.service;

import com.example.demo.model.Juego;

public interface JuegoService {


	public Juego save(Juego juego);
	public void deleteById(int id);
}
