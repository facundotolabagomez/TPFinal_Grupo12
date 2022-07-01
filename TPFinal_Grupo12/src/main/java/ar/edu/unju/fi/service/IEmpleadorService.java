package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Empleador;

public interface IEmpleadorService {
	
	public Empleador getEmpleador();
	public boolean guardarEmpleador(Empleador empleador);
	public void modificarEmpleador (Empleador empleador);
	public void eliminarEmpleador (long empleador_id);
	public List<Empleador> getListaEmpleador();
	public Empleador buscarEmpleador(String cuit);
	public Empleador buscarEmpleadorPorEmail(String email);

}
