package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Idioma;

@Repository
public interface IIdiomaRepository extends JpaRepository<Idioma, Long>{
	
	public Idioma findByNombreIdioma(String nombreIdioma);
	
	public Idioma findById(long idioma_id);

}
