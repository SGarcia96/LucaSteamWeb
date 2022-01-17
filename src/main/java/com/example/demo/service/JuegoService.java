package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Juego;

/**
 * Interfaz de la clase JuegoService
 * @author alumno
 *
 */

public interface JuegoService {
	
	/**
	 * Método que guarda los juegos que se han introducido 
	 * @param juego
	 * @return
	 */

	public Juego save(Juego juego);

	
	/**
	 * Método que borra los juegos por su ID
	 * @param id
	 */
	
	public void deleteById(int id);
	
	/**
	 * Método que proporciona todos los juegos de la lista
	 * @return
	 */
	
	public List<Juego> findAll();
	
	/**
	 * Método para cargar los juegos
	 */
	
	public void cargarJuegos();
	
	/**
	 * Método para buscar juegos por ID
	 * @param id
	 * @return
	 */
	
	public Optional <Juego> findById(int id);
	
	/**
	 * Método para buscar juego por fabricante
	 * @param fabricante
	 * @return
	 */
	
	public List<Juego> findAllByFabricante(String fabricante);
	
	/**
	 * Método para buscar juegos por género
	 * @param genero
	 * @return
	 */

	public List<Juego> findAllByGenero(String genero);

	/**
	 * Método para buscar juegos por el año de publicación
	 * @param fecha
	 * @return
	 */

	public List<Juego> findAllByFecha(int fecha);
	
	/**
	 * Método para buscar juegos por editores
	 * @return
	 */

	public List<String> findAllEditores();
	
	/**
	 * Método para filtrar juegos por año par
	 * @return
	 */

	public List<Juego> findAllByFechaPair();

	/**
	 * Método para filtrar juegos con recaudación por encima de la media europea
	 * @return
	 */
	
	public List<Juego> findAllByEuSalesOverAverage();

}
