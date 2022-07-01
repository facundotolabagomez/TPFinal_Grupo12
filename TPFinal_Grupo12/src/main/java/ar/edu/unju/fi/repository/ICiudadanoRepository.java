package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Ciudadano;


@Repository
public interface ICiudadanoRepository  extends JpaRepository<Ciudadano, Long> {
	
	public Ciudadano findByDni(int dni);
	
	public Ciudadano findByEmail(String email);

	

}
