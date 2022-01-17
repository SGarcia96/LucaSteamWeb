package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.JuegoDAO;
import com.example.demo.model.Juego;

@Service
public class JuegoServiceImpl implements JuegoService{

	@Autowired
	private JuegoDAO juegoDao;
	
	@Override
	public Juego save(Juego juego) {
		juegoDao.save(juego);
		return juego;
	}

	@Override
	public void deleteById(int id) {
		juegoDao.deleteById(id);
	}
	
	@Override
	public Optional<Juego> findById(int id) {
		return juegoDao.findById(id);
	}
	
	@Override
	public List<Juego> findAllByFabricante(String fabricante) {
		return juegoDao.findAllByFabricante(fabricante);
	}
	
	@Override
	public List<Juego> findAllByGenero(String genero) {
		return juegoDao.findAllByGenero(genero);
	}
	@Override
	public List<Juego> findAllByFecha(int fecha) {
		return juegoDao.findAllByFecha(fecha);
	}

	@Override
	public List<Juego> findAll() {
		return juegoDao.findAll();
	}

	@Override
	public void cargarJuegos() {
		List<Juego> juegos = juegoDao.cargarJuegos();
		juegos.forEach(juego->save(juego));
	}
	
	@Override
	public List<String> findAllEditores(){
		return juegoDao.findAllEditores();
	}

}
