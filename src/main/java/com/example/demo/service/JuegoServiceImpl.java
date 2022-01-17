package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.JuegoDAO;
import com.example.demo.model.Juego;
/**
 * Proporciona un medio parar crear y formatear un archivo de
 * documento de lenguaje, con espacios de nombres,
 * elementos y atributos apropiados de una lista
 * de juegos que describen nuestro servicio web.
 * @author Eva, Gabriel, José Manuel, Steven, Tony
 * @version 1.0
 */
@Service
public class JuegoServiceImpl implements JuegoService{
	/**
	 * 
	 */
	@Autowired
	private JuegoDAO juegoDao;
	
	/**
	 * método para guardar los juegos del csv proporcionado a la base de datos
	 * @return juego
	 */
	@Override
	public Juego save(Juego juego) {
		juegoDao.save(juego);
		return juego;
	}
	/**
	 * método para borrar los juegos por su ID
	 */
	@Override
	public void deleteById(int id) {
		juegoDao.deleteById(id);
	}
	/**
	 * método para buscar juegos por su ID
	 * @return juegoDao.findById
	 */
	@Override
	public Optional<Juego> findById(int id) {
		return juegoDao.findById(id);
	}
	/**
	 * método para filtrar juegos por fabricante
	 * @return juegoDao.findAllByFabricante(fabricante)
	 */
	@Override
	public List<Juego> findAllByFabricante(String fabricante) {
		return juegoDao.findAllByFabricante(fabricante);
	}
	/**
	 * método para filtrar juegos por género
	 * @return juegoDao.findAllByGenero(genero)
	 */
	@Override
	public List<Juego> findAllByGenero(String genero) {
		return juegoDao.findAllByGenero(genero);
	}
	
	/**
	 * método para filtrar juegos por año de lanzamiento
	 * @return juegoDao.findAllByFecha(fecha)
	 */
	@Override
	public List<Juego> findAllByFecha(int fecha) {
		return juegoDao.findAllByFecha(fecha);
	}
	/**
	 * método para buscar un juego en toda la lista
	 * @return juegoDao.findAll()
	 */
	@Override
	public List<Juego> findAll() {
		return juegoDao.findAll();
	}
	/**
	 * método para cargar un juego
	 */
	@Override
	public void cargarJuegos() {
		List<Juego> juegos = juegoDao.cargarJuegos();
		juegos.forEach(juego->save(juego));
	}
	/**
	 * método para filtrar juegos con ventas por encima de la media en europa
	 * @juegoDao.findAllByEuSalesOverAverage()
	 */
	@Override
	public List<Juego> findAllByEuSalesOverAverage() {
		return juegoDao.findAllByEuSalesOverAverage();
	}
	/**
	 * método para filtrar por editores
	 * @return juegoDao.findAllEditores();
	 */
	@Override
	public List<String> findAllEditores(){
		return juegoDao.findAllEditores();

	}
	/**
	 * método para filtrar juegos con año de lanzamiento par
	 * @return juegoDao.findAllByFechaPair()
	 */
	@Override
	public List<Juego> findAllByFechaPair() {
		return juegoDao.findAllByFechaPair();
	}

}
