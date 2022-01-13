package com.example.demo.service;

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

}
