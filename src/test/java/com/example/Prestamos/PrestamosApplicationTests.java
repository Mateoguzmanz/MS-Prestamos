package com.example.Prestamos;

import com.example.Prestamos.controllers.LibroPrestamoController;
import com.example.Prestamos.models.Prestamos;
import com.example.Prestamos.repositories.PrestamoRepository;
import com.example.Prestamos.service.PrestamoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
class PrestamosApplicationTests {

	/*@Test
	void contextLoads() {
	}

	@Mock
	private PrestamoService prestamoService;
	private PrestamoRepository prestamoRepository;

	@InjectMocks
	private LibroPrestamoController libroPrestamoController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void obtenerTodosLosPrestamosTest() {
		Prestamos prestamos1 = new Prestamos(1L, "Libro1", "Autor1", "20/11-2023", "20-11-2023");

		when(prestamoService.obtenerTodosLosPrestamos()).thenReturn(Flux.just(prestamos1));

		WebTestClient webTestClient = WebTestClient.bindToController(libroPrestamoController).build();

		webTestClient.get()
					.uri("/prestamos")
					.exchange()
					.expectStatus().isOk()
					.expectBodyList(Prestamos.class)
					.isEqualTo(List.of(prestamos1));

		verify(prestamoService, times(1)).obtenerTodosLosPrestamos();
	}

	@Test
	public void crearPrestamoTest() throws JsonProcessingException {
		Prestamos nuevoPrestamo = new Prestamos(1L, "NuevoLibro", "NuevoAutor", "20-11-2023", "20-11-2023");

		when(prestamoRepository.save(any(Prestamos.class))).thenReturn(Mono.just(nuevoPrestamo));

		WebTestClient webTestClient = WebTestClient.bindToController(libroPrestamoController).build();

		webTestClient.post()
				.uri("/prestamos")
				.contentType(MediaType.APPLICATION_JSON)
				.bodyValue(new ObjectMapper().writeValueAsString(nuevoPrestamo))
				.exchange()
				.expectStatus().isOk()
		;

		verify(prestamoRepository, times(1)).save(nuevoPrestamo);
	}

*/

}
