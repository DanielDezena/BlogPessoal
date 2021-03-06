package org.generation.blogpessoal.postgen.repository;

import java.util.List;

import org.generation.blogpessoal.postgen.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Long>{
	
	public List<Tema> findAllByDescricaoContainingIgnoreCase( String descricao);

}
