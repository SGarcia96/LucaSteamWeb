package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Juego;

@Repository
public interface JuegoDAO extends JpaRepository<Juego, Integer>, JuegoDaoCustom {

	public List<Juego> findAllByFabricante(String fabricante);

	public List<Juego> findAllByGenero(String genero);
	
	public List<Juego> findAllByFecha(int fecha);
	
	@Query(value="SELECT DISTINCT editor FROM juego WHERE editor NOT LIKE '0' ORDER BY editor;", nativeQuery=true)
	public List<String> findAllEditores();

	@Query(value="SELECT * FROM juego WHERE fecha % 2 = 0", nativeQuery=true)
	public List<Juego> findAllByFechaPair();

}
