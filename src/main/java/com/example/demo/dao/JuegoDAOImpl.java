package com.example.demo.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Juego;

@Repository
public class JuegoDAOImpl implements JuegoDaoCustom{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void cargarJuegos() {
		String linea;
		String[] juegoArray = new String[5];
		int cont = 0;
		
		try (FileReader fileReader = new FileReader("vgsales.csv");
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			while ((linea = bufferedReader.readLine()) != null) {
				if (cont > 0) {
					Juego juego = new Juego();
					juegoArray = linea.split(",");
					juego.setNombre(juegoArray[0]);
					juego.setPlataforma(juegoArray[1]);
					try {
						juego.setFecha(Integer.parseInt(juegoArray[2]));
					} catch (NumberFormatException e) {
						System.out.println("No se ha insertado un numero");
					}
					juego.setGenero(juegoArray[3]);
					juego.setEditor(juegoArray[4]);
					this.darDeAlta(juego);

				}
				cont++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
