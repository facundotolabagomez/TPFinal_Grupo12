package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Curriculum;
import ar.edu.unju.fi.repository.ICurriculumRepository;
import ar.edu.unju.fi.service.ICurriculumService;

@Service("CurriculumServiceImpSql")
public class CurriculumServiceImpSql implements ICurriculumService {

	@Autowired
	private ICurriculumRepository curriculumRepository;
			
	@Override
	public Curriculum getCurriculum() {
		// TODO Auto-generated method stub
		return new Curriculum();
	}

	@Override
	public boolean guardarCurriculum(Curriculum curriculum) {
		// TODO Auto-generated method stub
		if (curriculumRepository.save(curriculum)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void modificarCurriculum(Curriculum curriculum) {
		// TODO Auto-generated method stub
		curriculumRepository.save(curriculum);
	}

	@Override
	public void eliminarCiudadano(long curriculum_id) {
		// TODO Auto-generated method stub
		Curriculum cv = curriculumRepository.findById(curriculum_id);
		cv.setExisteCurriculum(false);
		curriculumRepository.save(cv);
		//curriculumRepository.deleteById(curriculum_id);

	}

	@Override
	public Curriculum buscarCurriculum(long curriculum_id) {
		// TODO Auto-generated method stub
		return curriculumRepository.findById(curriculum_id);
	}

	/*
	 * @Override public Curriculum buscarCurriculumPorCiudadanoId(long ciudadano_id)
	 * { // TODO Auto-generated method stub return
	 * curriculumRepository.findByCiudadanoId(ciudadano_id); }
	 */

	

}
