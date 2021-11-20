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
		usuarioRepository.save(new Usuario(0L, "Gabriel Monteiro", "gabrielmonte@gmail.com.br", "123456789"));
		usuarioRepository.save(new Usuario(0L, "Pedro Monteiro", "pedrimonte@gmail.com.br", "123456789"));
		usuarioRepository.save(new Usuario(0L, "José Monteiro", "josemonte@gmail.com.br", "123456789"));
		usuarioRepository.save(new Usuario(0L, "Guilherme Monteiro", "guimonte@gmail.com.br", "123456789"));

	}

	@Test
	@DisplayName("retorna 1 usuario")
	public void deveRetornarIUmUsuario() {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("pedrimonte@gmail.com.br");
		assertTrue(usuario.get().getUsuario().equals("pedrimonte@gmail.com.br"));

	}

	@Test
	@DisplayName("retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByUsuarioContainingIgnoreCase("Monteiro");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(1).getNome().equalsIgnoreCase("Gabriel Monteiro"));
		assertTrue(listaDeUsuarios.get(2).getNome().equalsIgnoreCase("Guilherme Monteiro"));
		assertTrue(listaDeUsuarios.get(3).getNome().equalsIgnoreCase("José Monteiro"));
		

	}

}
