package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.entity.OfertaLaboral;

public interface IOfertaLaboralService {
	
	public OfertaLaboral getOfertaLaboral();
	public boolean guardarOfertaLab(OfertaLaboral ofertalab);
	public void modificarOfertaLab (OfertaLaboral ofertalab);
	public void eliminarOfertaLab (long oferta_id);
	public OfertaLaboral buscarOfertaLab(long oferta_id);
	public List<OfertaLaboral> buscarOfertaPorEmpleador(Empleador empleador);

}
