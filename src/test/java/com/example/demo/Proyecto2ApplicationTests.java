package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.JuegoController;


@ExtendWith(SpringExtension.class)
@WebMvcTest(JuegoController.class)
class Proyecto2ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void comprobarCss() throws Exception {
		mockMvc.perform(get("/css/styles.css")).andDo(print()).andExpect(status().isOk());
	}

}
