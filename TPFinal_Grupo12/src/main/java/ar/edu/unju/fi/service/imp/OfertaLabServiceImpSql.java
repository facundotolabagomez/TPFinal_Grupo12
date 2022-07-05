package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.entity.OfertaLaboral;
import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.repository.IOfertaLabRepository;
import ar.edu.unju.fi.service.IOfertaLaboralService;

@Service("OfertaLabServiceImpSql")
public class OfertaLabServiceImpSql implements IOfertaLaboralService {

	@Autowired
	private IOfertaLabRepository ofertalabRepository;
	
	@Override
	public OfertaLaboral getOfertaLaboral() {
		// TODO Auto-generated method stub
		return new OfertaLaboral();
	}

	@Override
	public boolean guardarOfertaLab(OfertaLaboral ofertalab) {
		// TODO Auto-generated method stub
		if (ofertalabRepository.save(ofertalab)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void modificarOfertaLab(OfertaLaboral ofertalab) {
		// TODO Auto-generated method stub
		ofertalabRepository.save(ofertalab);
	}

	@Override
	public void eliminarOfertaLab(long oferta_id) {
		// TODO Auto-generated method stub
		OfertaLaboral of = ofertalabRepository.findById(oferta_id);
		of.setExisteOferta(false);
		ofertalabRepository.save(of);
		//ofertalabRepository.delete(of);

	}

	@Override
	public OfertaLaboral buscarOfertaLab(long oferta_id) {
		// TODO Auto-generated method stub
		return ofertalabRepository.findById(oferta_id);
	}

	@Override
	public List<OfertaLaboral> buscarOfertaPorEmpleador(Empleador empleador) {
		// TODO Auto-generated method stub
		return ofertalabRepository.findByEmpleador(empleador);
	}

	@Override
	public List<OfertaLaboral> buscarTodasOferta() {
		// TODO Auto-generated method stub
		return ofertalabRepository.findAll();
	}

	@Override
	public List<OfertaLaboral> buscarOfertaPorProv(Provincia provincia) {
		// TODO Auto-generated method stub
		return ofertalabRepository.findByEmpleadorProvincia(provincia);
	}

}
