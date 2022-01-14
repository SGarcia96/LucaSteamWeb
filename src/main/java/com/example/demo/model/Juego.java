package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
public class Juego implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter private int id;
	
	@Getter @Setter String nombre;
	@Getter @Setter private int fecha;
	@Getter @Setter private String editor;
	@Getter @Setter private String genero;
	@Getter @Setter private String plataforma;
	@Getter @Setter private double eu_sales;
	@Getter @Setter private String fabricante;
	
}


