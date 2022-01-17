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
	
	@Query(value="SELECT * FROM juego WHERE eu_sales > (select avg(eu_sales) from juego)", nativeQuery=true)
	public List<Juego> findAllByEuSalesOverAverage();

	@Query(value="SELECT * FROM juego WHERE fecha % 2 = 0", nativeQuery=true)
	public List<Juego> findAllByFechaPair();


}
