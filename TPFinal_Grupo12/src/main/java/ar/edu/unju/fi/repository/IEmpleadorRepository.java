package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Empleador;

@Repository
public interface IEmpleadorRepository extends JpaRepository<Empleador, Long>  {
		
	public Empleador findByCuit(String cuit);

}
