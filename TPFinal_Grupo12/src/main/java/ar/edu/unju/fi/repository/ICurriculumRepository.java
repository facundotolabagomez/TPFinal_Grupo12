package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Curriculum;

@Repository
public interface ICurriculumRepository extends JpaRepository<Curriculum, Long> {
	
	public Curriculum findById(long curriculum_id);
	
	//public Curriculum findByCiudadano_Id(long ciudadano_id);

	

}
