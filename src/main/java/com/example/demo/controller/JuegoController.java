package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Juego;
import com.example.demo.service.JuegoService;

@Controller
@RequestMapping("/juego")
public class JuegoController {
	
	@Autowired
	JuegoService juegoService;
	private static final Logger log = LoggerFactory.getLogger(JuegoController.class);
	
	@GetMapping
	public String showMenu(Model model) {
		model.addAttribute("juegos", juegoService.findAll());
		log.info("en el metodo showMenu del controller");
		return "index";
	}
	
	@GetMapping("/add")
	public String add(Juego juego, Model model) {
		model.addAttribute("juego", juego);
		log.info("en el metodo add del controller");
		return "form";
	}
	
	@PostMapping("/save")
	public String save(Juego juego) {
		juegoService.save(juego);
		log.info("en el metodo save del controller");
		return ("redirect:/juego");
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("id") int id) {
		juegoService.deleteById(id);
		log.info("en el metodo deleteById del controller");
		return ("redirect:/juego");
	}
	
	@GetMapping("/edit")
	public String findById(@RequestParam("id") int id, Model m) {
		m.addAttribute("juego", juegoService.findById(id));
		log.info("en el metodo findById del controller");
		return "form";
	}
	
	@GetMapping("/list/nintendo")
	public String findByFabricante(Model m) {
		log.info(juegoService.findAllByFabricante("Nintendo").toString());
		m.addAttribute("juegos", juegoService.findAllByFabricante("Nintendo"));
		log.info("en el metodo findByFabricante del controller");
		return ("index");
	}
	
	@GetMapping("/list/generoByPlataforma")
	public String findByGeneroPlataforma(Model m) {
		m.addAttribute("juegos", juegoService.findAllByGenero("platform"));
		log.info(juegoService.findAllByGenero("Platform").toString());
		log.info("en el metodo findByGeneroPlataforma del controller");
		return "index";
	}
	
	@PostMapping("/list/genero")
	public String findByGenero(@RequestParam("genero")String genero, Model m) {
		m.addAttribute("juegos", juegoService.findAllByGenero(genero));
		log.info(juegoService.findAllByGenero(genero).toString());
		log.info("en el metodo findByGenero del controller");
		return "index";
	}
	@PostMapping("/list/fecha")
	public String findByFecha(@RequestParam("fecha")int fecha, Model m) {
		m.addAttribute("juegos", juegoService.findAllByFecha(fecha));
		log.info(juegoService.findAllByFecha(fecha).toString());
		log.info("en el metodo findByFecha del controller");
		return "index";
	}
}
