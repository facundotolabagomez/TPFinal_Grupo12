package ar.edu.unju.fi.entity;

import java.time.LocalDate;

public class Ciudadano {
		private long ciudadano_id; 
	    private int dni;
		private long numeroTramite;
		private String estadoCivil;
		private Provincia provincia;
		private String telefono;
		private LocalDate fechaNac;
		private String pasword;
		private Curriculum curriculum;
		
		public Ciudadano() {
			// TODO Auto-generated constructor stub
		}

		public Ciudadano(long ciudadano_id, int dni, long numeroTramite, String estadoCivil, Provincia provincia,
				String telefono, LocalDate fechaNac, String pasword, Curriculum curriculum) {
			super();
			this.ciudadano_id = ciudadano_id;
			this.dni = dni;
			this.numeroTramite = numeroTramite;
			this.estadoCivil = estadoCivil;
			this.provincia = provincia;
			this.telefono = telefono;
			this.fechaNac = fechaNac;
			this.pasword = pasword;
			this.curriculum = curriculum;
		}

		public long getCiudadano_id() {
			return ciudadano_id;
		}

		public void setCiudadano_id(long ciudadano_id) {
			this.ciudadano_id = ciudadano_id;
		}

		public int getDni() {
			return dni;
		}

		public void setDni(int dni) {
			this.dni = dni;
		}

		public long getNumeroTramite() {
			return numeroTramite;
		}

		public void setNumeroTramite(long numeroTramite) {
			this.numeroTramite = numeroTramite;
		}

		public String getEstadoCivil() {
			return estadoCivil;
		}

		public void setEstadoCivil(String estadoCivil) {
			this.estadoCivil = estadoCivil;
		}

		public Provincia getProvincia() {
			return provincia;
		}

		public void setProvincia(Provincia provincia) {
			this.provincia = provincia;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public LocalDate getFechaNac() {
			return fechaNac;
		}

		public void setFechaNac(LocalDate fechaNac) {
			this.fechaNac = fechaNac;
		}

		public String getPasword() {
			return pasword;
		}

		public void setPasword(String pasword) {
			this.pasword = pasword;
		}

		public Curriculum getCurriculum() {
			return curriculum;
		}

		public void setCurriculum(Curriculum curriculum) {
			this.curriculum = curriculum;
		}
		
		

}
