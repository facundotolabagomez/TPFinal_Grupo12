package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Curriculum;
import ar.edu.unju.fi.entity.ExperienciaLaboral;
import ar.edu.unju.fi.service.ICurriculumService;
import ar.edu.unju.fi.service.IExperienciaLaboralService;


@Controller
@RequestMapping("/exp")
public class ExperinciaLaboralController {
	
	@Autowired
	@Qualifier("ExperienciaLaboralServiceImpSql")
	private IExperienciaLaboralService expService;
	@Autowired
	@Qualifier("CurriculumServiceImpSql")
	private ICurriculumService cvService;

	private static final Log LOGGER = LogFactory.getLog(ExperinciaLaboralController.class);
	
	@GetMapping("/nuevo/{cv}")
	public String getFormExperinciaPage(@PathVariable(value = "cv") long cv, Model model) {
		model.addAttribute("explab", expService.getExperiencia());
		model.addAttribute("cv", cvService.buscarCurriculum(cv));
		return "nuevo_experincia";		
	}
	
	@PostMapping("/guardar/{curriculum_id}")
	public ModelAndView getExpLabPage(@PathVariable(value = "curriculum_id") long curriculum_id,@Validated @ModelAttribute("explab")ExperienciaLaboral explab, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo");
			mav.addObject("explab", explab);
			return mav;
		}
		ModelAndView mavexp = new ModelAndView("redirect:/cv/editarExpLab/"+curriculum_id);
		explab.setCurriculum(cvService.buscarCurriculum(curriculum_id));
		if (expService.guardarExperiencia(explab)) {
			LOGGER.info("Se guardo nueva explab");
		}
		mavexp.addObject("explab", expService.getListaExperienciaLaboral());
		return mavexp; 
	} 
	
	@GetMapping("/eliminar/{experiencia_id}")
	public ModelAndView getEliminarExpPage(@PathVariable(value = "experiencia_id") long experiencia_id) {
		ExperienciaLaboral exp = expService.buscarExperiencia(experiencia_id);
		long curriculum_id = exp.getCurriculum().getCurriculum_id();
		Curriculum cv = cvService.buscarCurriculum(curriculum_id);
		ModelAndView mav = new ModelAndView("redirect:/cv/editarExpLab/"+cv.getCurriculum_id());
		expService.eliminarExperiencia(experiencia_id);
		LOGGER.info(cv.getCurriculum_id());
		LOGGER.info("Se eliminó exp lab");
		return mav;
	}
}
