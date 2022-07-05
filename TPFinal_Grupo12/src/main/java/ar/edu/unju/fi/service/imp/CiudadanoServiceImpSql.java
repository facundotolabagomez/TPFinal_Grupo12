package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.repository.ICiudadanoRepository;
import ar.edu.unju.fi.service.ICiudadanoService;

@Service("CiudadanoServiceImpSql")
public class CiudadanoServiceImpSql implements ICiudadanoService {
	
	@Autowired
	private ICiudadanoRepository ciudadanoRepository;
	
	@Override	
	public Ciudadano getCiudadano() {
		// TODO Auto-generated method stub
		return new Ciudadano();
	}

	@Override
	public boolean guardarCiudadano(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		if (ciudadanoRepository.save(ciudadano)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void modificarCiudadano(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		ciudadanoRepository.save(ciudadano);
		
	}

	@Override
	public void eliminarCiudadano(long ciudadano_id) {
		// TODO Auto-generated method stub
		Ciudadano ciudadano = ciudadanoRepository.findById(ciudadano_id);
		ciudadano.setExisteCiudadano(false);
		ciudadanoRepository.save(ciudadano);
		//ciudadanoRepository.deleteById(ciudadano_id);
	}

	@Override
	public List<Ciudadano> getListaCiudadano() {
		// TODO Auto-generated method stub
		return ciudadanoRepository.findAll();
	}

	@Override
	public Ciudadano buscarCiudadano(int dni) {
		// TODO Auto-generated method stub
		return ciudadanoRepository.findByDni(dni);
	}

	@Override
	public Ciudadano buscarCiudadanoPorEmail(String email) {
		// TODO Auto-generated method stub
		return ciudadanoRepository.findByEmail(email);
	}

	@Override
	public Ciudadano buscarCiudadanoPorOferta(long oferta_id) {
		// TODO Auto-generated method stub
		return ciudadanoRepository.findByOfertas(oferta_id);
	}

}
