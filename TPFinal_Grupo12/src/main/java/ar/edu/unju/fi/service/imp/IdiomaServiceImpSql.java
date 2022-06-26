package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Idioma;
import ar.edu.unju.fi.repository.IIdiomaRepository;
import ar.edu.unju.fi.service.IIdiomaService;

@Service("IdiomaServiceImpSql")
public class IdiomaServiceImpSql implements IIdiomaService {
	
	@Autowired
	private IIdiomaRepository idiomaRepository;

	@Override
	public Idioma getIdioma() {
		// TODO Auto-generated method stub
		return new Idioma();
	}

	@Override
	public boolean guardarIdioma(Idioma idioma) {
		// TODO Auto-generated method stub
		if (idiomaRepository.save(idioma)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void modificarIdioma(Idioma idioma) {
		// TODO Auto-generated method stub
		idiomaRepository.save(idioma);
		
	}

	@Override
	public void eliminarIdioma(String nombreIdioma) {
		// TODO Auto-generated method stub
		Idioma idio = buscarIdioma(nombreIdioma);
		idiomaRepository.delete(idio);
	}

	@Override
	public List<Idioma> getListaIdioma() {
		// TODO Auto-generated method stub
		return idiomaRepository.findAll();
	}

	@Override
	public Idioma buscarIdioma(String nombreIdioma) {
		// TODO Auto-generated method stub		
		return idiomaRepository.findByNombreIdioma(nombreIdioma);
	}

}
