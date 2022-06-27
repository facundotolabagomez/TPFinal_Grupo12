package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Educacion;


@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Long> {
	
	public Educacion findByNivelAlcanzado(String nivelAlcanzado);

}
