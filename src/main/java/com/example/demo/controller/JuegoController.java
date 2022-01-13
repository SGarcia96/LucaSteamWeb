package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Juego;
import com.example.demo.service.JuegoService;

@Controller
@RequestMapping("/juego")
public class JuegoController {
	
	@Autowired
	JuegoService juegoService;
	
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
}
