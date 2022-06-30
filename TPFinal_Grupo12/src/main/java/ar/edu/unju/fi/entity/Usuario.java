package ar.edu.unju.fi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USUARIO_ID")	
	private long usuario_id;
	
	@Column(name = "USUARIO_EMAIL", length = 50)
	@NotNull(message = "Debe completar el Email")
	@Email
	private String emailUser;
	
	@Column(name = "USUARIO_PASS", length = 15)
	@NotNull(message = "Debe completar Contraseña")
	@Size(min=5, max=15)	
	private String passwordUser;
	
	@Column(name = "TIPOUSUARIO", length = 15)
	@NotNull(message = "Seleccionar el tipo de usuario")
	@Size(min=5, max=15)	
	private String tipoUsuario;
	
	@Column(name = "EXISTEUSUARIO")
	private boolean existeUsuario;
	
	@OneToMany(
			mappedBy = "usuario", 
			cascade = CascadeType.ALL, 
			orphanRemoval = false)
	private List <Ciudadano> ciudadanos;
	
	@OneToMany(
			mappedBy = "usuario", 
			cascade = CascadeType.ALL, 
			orphanRemoval = false)
	private List <Empleador> empleadores;

	

	public long getUsuario_id() {
		return usuario_id;
	}



	public void setUsuario_id(long usuario_id) {
		this.usuario_id = usuario_id;
	}



	public String getEmailUser() {
		return emailUser;
	}



	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}



	public String getPasswordUser() {
		return passwordUser;
	}



	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}



	public String getTipoUsuario() {
		return tipoUsuario;
	}



	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}



	public boolean isExisteUsuario() {
		return existeUsuario;
	}



	public void setExisteUsuario(boolean existeUsuario) {
		this.existeUsuario = existeUsuario;
	}



	public List<Ciudadano> getCiudadanos() {
		return ciudadanos;
	}



	public void setCiudadanos(List<Ciudadano> ciudadanos) {
		this.ciudadanos = ciudadanos;
	}



	public List<Empleador> getEmpleadores() {
		return empleadores;
	}



	public void setEmpleadores(List<Empleador> empleadores) {
		this.empleadores = empleadores;
	}



	public Usuario(long usuario_id, @NotNull(message = "Debe completar el Email") @Email String emailUser,
			@NotNull(message = "Debe completar Contraseña") @Size(min = 5, max = 15) String passwordUser,
			String tipoUsuario, boolean existeUsuario, List<Ciudadano> ciudadanos, List<Empleador> empleadores) {
		super();
		this.usuario_id = usuario_id;
		this.emailUser = emailUser;
		this.passwordUser = passwordUser;
		this.tipoUsuario = tipoUsuario;
		this.existeUsuario = existeUsuario;
		this.ciudadanos = ciudadanos;
		this.empleadores = empleadores;
	}



	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	
	
	

}
