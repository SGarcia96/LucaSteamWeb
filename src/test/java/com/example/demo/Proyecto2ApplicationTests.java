package com.example.demo;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.JuegoController;


@SpringBootTest
class Proyecto2ApplicationTests {

	@Autowired
	private JuegoController controller;

	@Test
	void contextLoads() {
		assertThat(true).isTrue();
	}

	@Test
	void controllerNotNull() {
		assertThat(controller).isNotNull();
	}
}
