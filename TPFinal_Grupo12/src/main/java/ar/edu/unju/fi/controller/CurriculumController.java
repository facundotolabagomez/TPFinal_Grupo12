package ar.edu.unju.fi.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.entity.Curriculum;
import ar.edu.unju.fi.entity.Educacion;
import ar.edu.unju.fi.service.ICurriculumService;
import ar.edu.unju.fi.service.IEducacionService;
import ar.edu.unju.fi.service.IIdiomaService;


@Controller
@RequestMapping("/cv")
public class CurriculumController {
	
	@Autowired
	@Qualifier("CurriculumServiceImpSql")
	private ICurriculumService curriculumService;
	
	@Autowired
	@Qualifier("EducacionServiceImpSql")
	private IEducacionService educacionService;
	
	@Autowired
	@Qualifier("IdiomaServiceImpSql")
	private IIdiomaService idiomaService;
	
	/* falta crear este servicio
	@Autowired
	@Qualifier("ExperienciaLaboralServiceImpSql")
	private ExperienciaLaboralService explabService;
	*/
	
	private static final Log LOGGER = LogFactory.getLog(CurriculumController.class);
	
	@PostMapping("/guardar")
	public ModelAndView getDatosCurriculumPage(@Validated @ModelAttribute("curriculum")Curriculum curriculum, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_curriculum");
			mav.addObject("curriculum", curriculum);
			return mav;
		}
		ModelAndView mavcurriculum = new ModelAndView("redirect:/ciudadano/home");
		if (curriculumService.guardarCurriculum(curriculum)) {
			LOGGER.info("Se guardo el curriculum");
		}
		mavcurriculum.addObject("curriculum", curriculum);
		return mavcurriculum;
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosCiudadano(@Validated @ModelAttribute("curriculum") Curriculum curriculum, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+ curriculum);
			ModelAndView mav = new ModelAndView("edicion_curriculum");
			mav.addObject("curriculum", curriculum);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/ciudadano/home");
		curriculumService.modificarCurriculum(curriculum);
		LOGGER.info("Se modificó curriculum");
		return mav;
	} 
	
	@GetMapping("/edicion/{curriculum_id}")
	public ModelAndView getEditarCiudadanoPage(@PathVariable(value="curriculum_id")long curriculum_id) {
		ModelAndView mav = new ModelAndView("edicion_curriculum");
		Curriculum curri = curriculumService.buscarCurriculum(curriculum_id);
		List<Educacion> edu = educacionService.getListaEducacion();
		LOGGER.info(curri);
		mav.addObject("educacion", edu);
		mav.addObject("curriculum",curri);
		/*
		 * mav.addObject("provincia", provinciaService.getListaProvincia());
		 * mav.addObject("usuario", ciudadano.getUsuario()); mav.addObject("curriculum",
		 * ciudadano.getCurriculum());
		 */
		
		return mav;
	}

}
