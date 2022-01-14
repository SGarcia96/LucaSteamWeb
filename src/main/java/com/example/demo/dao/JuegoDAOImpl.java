package com.example.demo.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Juego;

@Repository
public class JuegoDAOImpl implements JuegoDaoCustom{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Juego> cargarJuegos() {
		String linea;
		String[] juegoArray = new String[6];
		List<Juego> juegos = new ArrayList<>();
		
		try (FileReader fileReader = new FileReader("src/main/resources/vgsales.csv");
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			bufferedReader.readLine();
			while ((linea = bufferedReader.readLine()) != null) {
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
					juego.setEu_sales(Double.parseDouble(juegoArray[5]));
					juego.setFabricante(dimeFabricante(juego.getPlataforma()));
					juegos.add(juego);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		return juegos;
	}
	
	private String dimeFabricante(String plataforma) {
		switch(plataforma.toUpperCase()) {
		case "3DO":
			return "The 3DO Company";
		case "3DS", "DS", "GB", "GBA", "GC", "N64", "NES", "SNES", "WII", "WIIU":
			return "Nintendo";
		case "DC", "GEN", "SAT", "SCD", "GG":
			return "Sega";
		case "PCFX", "T16":
			return "Huson Soft";
		case "PS", "PS2", "PS3", "PS4", "PSP", "PSV":
			return "Sony";
		case "WS":
			return "Bandai";
		case "XB", "X360", "XOne":
			return "Microsoft";
		case "2600":
			return "Atari";
		default:
			return "N/A";
		}
	}
}
