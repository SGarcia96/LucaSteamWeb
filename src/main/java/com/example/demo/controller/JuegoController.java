package com.example.demo.controller;

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
	
	@GetMapping
	public String showMenu(Model model) {
		model.addAttribute("juegos", juegoService.findAll());
		return "index";
	}
	
	@GetMapping("/add")
	public String add(Juego juego, Model model) {
		model.addAttribute("juego", juego);
		return "form";
	}
	
	@PostMapping("/save")
	public String save(Juego juego) {
		juegoService.save(juego);
		return ("/redirect:/juego");
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("id") int id) {
		juegoService.deleteById(id);
		return ("redirect:/");
	}
	
	@GetMapping("/edit")
	public String findById(@RequestParam("id") int id, Model m) {
		m.addAttribute("juego", juegoService.findById(id));
		return "form";
	}
	
	@GetMapping("/list/nintendo")
	public String findByFabricante(Model m) {
		m.addAttribute("lista juegos", juegoService.findByFabricante("Nintendo"));
		return "list";
	}
}
