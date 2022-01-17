package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Juego;
/**
 * Interfaz personalizada para crear el metodo cargarJuegos
 * @author Steven Garcia, Eva Montiel, Jose Manuel, Gabriel Marchante, Juan Antonio Rodriguez
 *
 */

public interface JuegoDaoCustom {
	/**
	 * Método abstracto para importar juegos al programa
	 * @return
	 */
	public List<Juego> cargarJuegos();
}
