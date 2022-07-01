package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.repository.IEmpleadorRepository;
import ar.edu.unju.fi.service.IEmpleadorService;

@Service("EmpleadorServiceImpSql")
public class EmpleadorServiceImpSql implements IEmpleadorService {
	
	@Autowired
	private IEmpleadorRepository empleadorRepository;

	@Override
	public Empleador getEmpleador() {
		// TODO Auto-generated method stub
		return new Empleador();
	}

	@Override
	public boolean guardarEmpleador(Empleador empleador) {
		// TODO Auto-generated method stub
		if (empleadorRepository.save(empleador)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void modificarEmpleador(Empleador empleador) {
		// TODO Auto-generated method stub
		empleadorRepository.save(empleador);
	}

	@Override
	public void eliminarEmpleador(long empleador_id) {
		// TODO Auto-generated method stub
		empleadorRepository.deleteById(empleador_id);
		
	}

	@Override
	public List<Empleador> getListaEmpleador() {
		// TODO Auto-generated method stub
		return empleadorRepository.findAll();
	}

	@Override
	public Empleador buscarEmpleador(String cuit) {
		// TODO Auto-generated method stub
		return empleadorRepository.findByCuit(cuit);
	}

	@Override
	public Empleador buscarEmpleadorPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
