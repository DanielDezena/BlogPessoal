package org.generation.blogpessoal.postgen.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.generation.blogpessoal.postgen.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	void start() {
		usuarioRepository.save(new Usuario(0L, "Gabriel Monteiro", "gabrielmonte@mail.com", "123456789"));
		usuarioRepository.save(new Usuario(0L, "Pedro Monteiro", "pedrimonte@mail.com", "123456789"));
		usuarioRepository.save(new Usuario(0L, "José Monteiro", "josemonte@mail.com", "123456789"));
		usuarioRepository.save(new Usuario(0L, "Guilherme Monteiro", "guimonte@mail.com", "123456789"));

	}

	@Test
	@DisplayName("retorna 1 usuario")
	public void deveRetornarIUmUsuario() {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("pedrimonte@gmail.com");
		assertTrue(usuario.get().getUsuario().equals("pedrimonte@gmail.com"));

	}

	@Test
	@DisplayName("retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByUsuarioContainingIgnoreCase("monteiro");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equalsIgnoreCase("Gabriel Montero"));
		assertTrue(listaDeUsuarios.get(1).getNome().equalsIgnoreCase("Pedro Montero"));
		assertTrue(listaDeUsuarios.get(2).getNome().equalsIgnoreCase("José Montero"));

	}

}
