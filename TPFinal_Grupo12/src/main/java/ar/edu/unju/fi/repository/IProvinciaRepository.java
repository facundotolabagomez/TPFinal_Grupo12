package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Provincia;


@Repository
public interface IProvinciaRepository extends JpaRepository<Provincia, Long> {
	
	public Provincia findByNombreProvincia(String nombreProvincia);
	
}
