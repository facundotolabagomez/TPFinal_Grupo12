package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.entity.Curso;

public interface ICursoRepository extends JpaRepository<Curso, Long> {
	
	public Curso findById(long curso_id);

}
