package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Juego;

public interface JuegoDAO extends JpaRepository<Juego, Integer>{

}
