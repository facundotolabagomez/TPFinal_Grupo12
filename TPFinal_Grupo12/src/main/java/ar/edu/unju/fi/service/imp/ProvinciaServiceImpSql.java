package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.repository.IProvinciaRepository;
import ar.edu.unju.fi.service.IProvinciaService;

@Service("ProvinciaServiceImpSql")
public class ProvinciaServiceImpSql implements IProvinciaService {
	
	@Autowired
	private IProvinciaRepository provinciaRepository;

	@Override
	public Provincia getProvincia() {
		// TODO Auto-generated method stub
		return new Provincia();
	}

	@Override
	public boolean guardarProvincia(Provincia provincia) {
		// TODO Auto-generated method stub
		if (provinciaRepository.save(provincia)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void modificarProvincia(Provincia provincia) {
		// TODO Auto-generated method stub
		provinciaRepository.save(provincia);
		
	}

	@Override
	public void eliminarProvincia(String nombreProvincia) {
		// TODO Auto-generated method stub
		Provincia prov = buscarProvincia(nombreProvincia);
		provinciaRepository.delete(prov);
		
	}

	@Override
	public List<Provincia> getListaProvincia() {
		// TODO Auto-generated method stub
		return provinciaRepository.findAll();
	}

	@Override
	public Provincia buscarProvincia(String nombreProvincia) {
		// TODO Auto-generated method stub
		return provinciaRepository.findByNombreProvincia(nombreProvincia);
	}

}
