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

/**
 * Clase controladora que dirige a los distintos archivos HTML cuando es
 * necesario
 * 
 * @author Steven Garcia, Eva Montiel, Jose Manuel, Gabriel Marchante, Juan
 *         Antonio Rodriguez
 *
 */
@Controller
@RequestMapping("/juego")
public class JuegoController {

	@Autowired
	private JuegoService juegoService;
	private static final Logger log = LoggerFactory.getLogger(JuegoController.class);

	/**
	 * Método que redirige al archivo index.html mostrando las opciones disponibles
	 * en la página
	 * 
	 * @param model
	 * @return index
	 */
	@GetMapping
	public String showMenu(Model model) {
		model.addAttribute("juegos", juegoService.findAll());
		log.info("en el metodo showMenu del controller");
		return "index";
	}

	/**
	 * Método que redirige al formulario para añadir un juego
	 * 
	 * @param juego
	 * @param model
	 * @return form
	 */
	@GetMapping("/add")
	public String add(Juego juego, Model model) {
		model.addAttribute("juego", juego);
		log.info("en el metodo add del controller");
		return "form";
	}

	/**
	 * Método que guarda la información de un juego en la base de datos
	 * 
	 * @param juego
	 * @return redirect:/juego
	 */
	@PostMapping("/save")
	public String save(Juego juego) {
		juegoService.save(juego);
		log.info("en el metodo save del controller");
		return ("redirect:/juego");
	}

	/**
	 * Método que elimina un juego dado de la base de datos
	 * 
	 * @param id
	 * @return redirect:/juego
	 */
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("id") int id) {
		juegoService.deleteById(id);
		log.info("en el metodo deleteById del controller");
		return ("redirect:/juego");
	}

	/**
	 * Método para encontrar un juego que coincida con un id dado y redirige a un
	 * formulario para editar ese juego
	 * 
	 * @param id
	 * @param m
	 * @return form
	 */
	@GetMapping("/edit")
	public String findById(@RequestParam("id") int id, Model m) {
		m.addAttribute("juego", juegoService.findById(id));
		log.info("en el metodo findById del controller");
		return "form";
	}

	/**
	 * Método que dado un fabricante proporciona los juegos para las plataformas de
	 * dicho fabricante, en este caso Nintendo
	 * 
	 * @param m
	 * @return index
	 */
	@GetMapping("/list/nintendo")
	public String findByFabricante(Model m) {
		log.info(juegoService.findAllByFabricante("Nintendo").toString());
		m.addAttribute("juegos", juegoService.findAllByFabricante("Nintendo"));
		log.info("en el metodo findByFabricante del controller");
		return ("index");
	}

	/**
	 * Método que proporciona los juegos que pertenecen a un genero dado, en este
	 * caso plataforma (platform)
	 * 
	 * @param m
	 * @return index
	 */
	@GetMapping("/list/generoByPlataforma")
	public String findByGeneroPlataforma(Model m) {
		m.addAttribute("juegos", juegoService.findAllByGenero("platform"));
		log.info(juegoService.findAllByGenero("Platform").toString());
		log.info("en el metodo findByGeneroPlataforma del controller");
		return "index";
	}

	/**
	 * Método que proporciona los juegos que pertenecen a un genero dado
	 * 
	 * @param genero
	 * @param m
	 * @return index
	 */
	@PostMapping("/list/genero")
	public String findByGenero(@RequestParam("genero") String genero, Model m) {
		m.addAttribute("juegos", juegoService.findAllByGenero(genero));
		log.info(juegoService.findAllByGenero(genero).toString());
		log.info("en el metodo findByGenero del controller");
		return "index";
	}

	/**
	 * Método que proporciona los juegos pertenecientes a un año dado
	 * 
	 * @param fecha
	 * @param m
	 * @return
	 */
	@PostMapping("/list/fecha")
	public String findByFecha(@RequestParam("fecha") int fecha, Model m) {
		m.addAttribute("juegos", juegoService.findAllByFecha(fecha));
		log.info(juegoService.findAllByFecha(fecha).toString());
		log.info("en el metodo findByFecha del controller");
		return "index";
	}

	/**
	 * Método que proporciona todos los juegos cuyas ventas en Europa sean
	 * superiores a la media de las ventas en Europa
	 * 
	 * @param m
	 * @return index
	 */
	@GetMapping("/list/salesOverAverage")
	public String findAllByEuSalesOverAverage(Model m) {
		m.addAttribute("juegos", juegoService.findAllByEuSalesOverAverage());
		log.info(juegoService.findAllByEuSalesOverAverage().toString());
		log.info("en el metodo findAllByEuSalesOverAverage del controller");
		return "index";
	}

	/**
	 * Método que proporciona la lista de los distintos editores que aparecen en la
	 * base de datos
	 * 
	 * @param m
	 * @return listaEditores
	 */
	@GetMapping("/list/editores")
	public String findAllEditores(Model m) {
		m.addAttribute("editores", juegoService.findAllEditores());
		log.info(juegoService.findAllEditores().toString());
		log.info("en el metodo findAllEditores del controller");
		return "listaEditores";

	}

	/**
	 * Método que proporciona todos los juegos cuya fecha de salida sea un año par
	 * 
	 * @param m
	 * @return
	 */
	@GetMapping("/list/fechasPares")
	public String findByFechaPar(Model m) {
		m.addAttribute("juegos", juegoService.findAllByFechaPair());
		log.info(juegoService.findAllByFechaPair().toString());
		log.info("en el metodo findAllByFechaPair del controller");
		return "index";
	}
}
