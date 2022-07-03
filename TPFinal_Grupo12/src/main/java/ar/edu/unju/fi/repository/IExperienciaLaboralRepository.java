package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.fi.entity.ExperienciaLaboral;
import ar.edu.unju.fi.entity.Idioma;


@Repository
public interface IExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Long> {
	
	//public Idioma findById(long experiencia_id);	

}
