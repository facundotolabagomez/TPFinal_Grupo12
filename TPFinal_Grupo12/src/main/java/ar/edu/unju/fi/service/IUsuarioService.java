package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Usuario;

public interface IUsuarioService {
	public Usuario getUsuario ();
	public void crearUsuario(Usuario usuario);
	public boolean guardarUsuario(Usuario usuario);
	public void modificarUsuario(Usuario usuario);
	public void eliminarUsuario(long usuario_id);
	public Usuario buscarUsuario(String emailUser, boolean existeUsuario);
	public Usuario encontrarUsuario(String emailUser, boolean existeUsuario) throws Exception;
	
}