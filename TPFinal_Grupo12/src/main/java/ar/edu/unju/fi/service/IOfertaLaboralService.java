package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.entity.OfertaLaboral;

public interface IOfertaLaboralService {
	
	public OfertaLaboral getOfertaLaboral();
	public boolean guardarOfertaLab(OfertaLaboral ofertalab);
	public void modificarOfertaLab (OfertaLaboral ofertalab);
	public void eliminarOfertaLab (long oferta_id);
	public OfertaLaboral buscarOfertaLab(long oferta_id);
	public List<OfertaLaboral> buscarOfertaPorEmpleador(Empleador empleador);
	public List<OfertaLaboral> buscarTodasOferta();
	//public List<OfertaLaboral> buscarOfertaPorProv(Provincia provincia);
	public List<OfertaLaboral> buscarOfertaPorCiudadano(Ciudadano ciudadano);
	//buscar por palabra clave
	public List<OfertaLaboral> buscarOfertaPorPalabra(String keyword);

}
