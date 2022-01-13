package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.User;
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
		
		
	}
	
	@Override
	//Esto es así porque el nuevo metodo devuelve un Optional
	public Optional<Juego> findById(int id) {
		return juegoDao.findById(id);
	}

}
