package com.example.demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.JuegoController;
import com.example.demo.service.JuegoService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(JuegoController.class)
public class Proyecto2WebMvcTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private JuegoService service;
	
	@Test
	void comprobarCss() throws Exception {
		System.out.println("====================Prueba CSS ==============================");
		mockMvc.perform(get("/css/styles.css"))
			   .andDo(print())
			   .andExpect(status().isOk());
	}
	
	@Test
	void getJuegoOkTest() throws Exception {
		System.out.println("====================Prueba get(/juego)=========================");
		mockMvc.perform(get("/juego"))
			   .andDo(print())
			   .andExpect(status().isOk());
	}
	
	@Test
	void getJuegoAddOkTest() throws Exception {
		System.out.println("====================Prueba get(/juego/add)=========================");
		mockMvc.perform(get("/juego/add"))
			   .andDo(print())
			   .andExpect(status().isOk());
	}
	
	@Test
	void postJuegoSaveOkTest() throws Exception {
		System.out.println("====================Prueba get(/juego/save)=========================");
		mockMvc.perform(post("/juego/save"))
			   .andDo(print())
			   .andExpect(status().isOk());
	}
	
	@Test
	void getJuegoDeleteOkTest() throws Exception {
		System.out.println("====================Prueba get(/juego/delete)=========================");
		mockMvc.perform(get("/juego/delete?id=1"))
			   .andDo(print())
			   .andExpect(status().is(302));
	}
	
	@Test
	void getJuegoEditOkTest() throws Exception {
		System.out.println("====================Prueba get(/juego/edit)=========================");
		mockMvc.perform(get("/juego/edit?id=1"))
			   .andDo(print())
			   .andExpect(status().isOk());
	}
	
	@Test
	void getJuegoListNintendoOkTest() throws Exception {
		System.out.println("====================Prueba get(/juego/list/nintendo)=========================");
		mockMvc.perform(get("/juego/list/nintendo"))
			   .andDo(print())
			   .andExpect(status().isOk());
	}
	
	@Test
	void getJuegoListGeneroByPlataformaOkTest() throws Exception {
		System.out.println("====================Prueba get(/juego/list/generoByPlataforma)=========================");
		mockMvc.perform(get("/juego/list/generoByPlataforma"))
			   .andDo(print())
			   .andExpect(status().isOk());
	}
	
	@Test
	void postJuegoListGeneroOkTest() throws Exception {
		System.out.println("====================Prueba get(/juego/list/genero)=========================");
		mockMvc.perform(post("/juego/list/genero?genero=Action"))
			   .andDo(print())
			   .andExpect(status().isOk());
	}
	
	@Test
	void postJuegoListFechaOkTest() throws Exception {
		System.out.println("====================Prueba get(/juego/list/fecha)=========================");
		mockMvc.perform(post("/juego/list/fecha?fecha=2000"))
			   .andDo(print())
			   .andExpect(status().isOk());
	}
	
	@Test
	void getJuegoListSalesOverAverageOkTest() throws Exception {
		System.out.println("====================Prueba get(/juego/list/salesOverAverage)=========================");
		mockMvc.perform(get("/juego/list/salesOverAverage"))
			   .andDo(print())
			   .andExpect(status().isOk());
	}
	
	@Test
	void getJuegoListEditoresOkTest() throws Exception {
		System.out.println("====================Prueba get(/juego/list/editores)=========================");
		mockMvc.perform(get("/juego/list/editores"))
			   .andDo(print())
			   .andExpect(status().isOk());
	}
	
	@Test
	void getJuegoListFechasParesOkTest() throws Exception {
		System.out.println("====================Prueba get(/juego/list/fechasPares)=========================");
		mockMvc.perform(get("/juego/list/fechasPares"))
			   .andDo(print())
			   .andExpect(status().isOk());
	}
}
