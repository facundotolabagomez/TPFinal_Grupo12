package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.entity.OfertaLaboral;

@Repository
public interface IOfertaLabRepository extends JpaRepository<OfertaLaboral, Long>{

	public OfertaLaboral findById(long oferta_id);
	public List<OfertaLaboral> findByEmpleador(Empleador empleador);
	public List<OfertaLaboral> findAll();
	//public List<OfertaLaboral> findByEmpleadorProvincia(Provincia provincia);
	public List<OfertaLaboral> findByCiudadano(Ciudadano ciudadano);
	
	@Query(value="select * from Ofertas o where o.puesto_req like %:keyword%", nativeQuery = true)
	public List<OfertaLaboral> findByKeyword(@Param("keyword")String keyword);
	
}
