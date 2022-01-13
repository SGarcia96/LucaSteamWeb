package com.example.demo.service;

import java.util.List;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Juego> findAll() {
		return juegoDao.findAll();
	}

	@Override
	public void cargarJuegos() {
		List<Juego> juegos = juegoDao.cargarJuegos();
		juegos.forEach(juego->juegoDao.save(juego));
	}

}
