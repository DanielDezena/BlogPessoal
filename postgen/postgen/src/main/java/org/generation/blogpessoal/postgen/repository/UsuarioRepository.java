package org.generation.blogpessoal.postgen.repository;

import java.util.List;
import java.util.Optional;

import org.generation.blogpessoal.postgen.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Optional<Usuario> findByUsuario(String Usuario);

	public List<Usuario> findAllByUsuarioContainingIgnoreCase(String string);
	

}
