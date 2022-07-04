package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.entity.OfertaLaboral;

@Repository
public interface IOfertaLabRepository extends JpaRepository<OfertaLaboral, Long>{

	public OfertaLaboral findById(long oferta_id);
	public List<OfertaLaboral> findByEmpleador(Empleador empleador);
	
}
