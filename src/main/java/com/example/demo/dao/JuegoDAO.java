package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Juego;

/**
 * Interfaz que hereda de las interfaces JuegoDaoCustom y el JpaRepository, para
 * crear los metodos de gestión de la base de datos
 * 
 * @author Steven Garcia, Eva Montiel, Jose Manuel, Gabriel Marchante, Juan
 *         Antonio Rodriguez
 *
 */
@Repository
public interface JuegoDAO extends JpaRepository<Juego, Integer>, JuegoDaoCustom {
	/**
	 * Método que proporciona los juegos cuya plataforma haya sido fabricada por un
	 * fabricante dado
	 * 
	 * @param fabricante
	 * @return lista de juegos
	 */
	public List<Juego> findAllByFabricante(String fabricante);

	/**
	 * Método que proporciona los juegos cuyo género coincide con uno dado
	 * 
	 * @param género
	 * @return lista de juegos
	 */
	public List<Juego> findAllByGenero(String genero);

	/**
	 * Método que proporciona los juegos cuya fecha (año) coincida con una dada
	 * (año)
	 * 
	 * @param fecha
	 * @return lista de juegos
	 */
	public List<Juego> findAllByFecha(int fecha);

	/**
	 * Método que proporciona todos los juegos cuyas ventas en Europa sean mayores a
	 * la media de ventas en Europa
	 * 
	 * @return lista de juegos
	 */
	@Query(value = "SELECT * FROM juego WHERE eu_sales > (select avg(eu_sales) from juego)", nativeQuery = true)
	public List<Juego> findAllByEuSalesOverAverage();

	/**
	 * Método que proporciona los distintos editores que aparecen en la base de
	 * datos
	 * 
	 * @return lista de editores
	 */
	@Query(value = "SELECT DISTINCT editor FROM juego WHERE editor NOT LIKE '0' ORDER BY editor;", nativeQuery = true)
	public List<String> findAllEditores();

	/**
	 * Método que proporciona todos los juegos cuya fecha de salida es un año par
	 * 
	 * @return lista de juegos
	 */
	@Query(value = "SELECT * FROM juego WHERE fecha % 2 = 0", nativeQuery = true)
	public List<Juego> findAllByFechaPair();

}
