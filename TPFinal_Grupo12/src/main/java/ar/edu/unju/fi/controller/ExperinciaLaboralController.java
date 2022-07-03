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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.entity.ExperienciaLaboral;
import ar.edu.unju.fi.service.IExperienciaLaboralService;


@Controller
@RequestMapping("/exp")
public class ExperinciaLaboralController {
	
	@Autowired
	@Qualifier("ExperienciaLaboralServiceImpSql")
	private IExperienciaLaboralService expService;

	private static final Log LOGGER = LogFactory.getLog(ExperinciaLaboralController.class);
	
	@GetMapping("/nuevo_experincia")
	public String getFormExperinciaPage(Model model) {
		model.addAttribute("experiencia", expService.getExperiencia());
		return "nuevo_experincia";		
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaExperinciaPage(@Validated @ModelAttribute("experiencia")ExperienciaLaboral experiencia, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_experiencia");
			mav.addObject("experiencia", experiencia);
			return mav;
		}
		ModelAndView mavexperincia = new ModelAndView("redirect:/idioma/lista_idio");
		if (expService.guardarExperiencia(experiencia)) {
			LOGGER.info("Se guardó nuevo experincia");
		}
		mavexperincia.addObject("experincia", expService.getExperiencia());
		return mavexperincia; 
	} 
	
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosExperincia(@Validated @ModelAttribute("experiencia") ExperienciaLaboral experiencia, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+ experiencia);
			ModelAndView mav = new ModelAndView("edicion_experincia");
			mav.addObject("experincia", experiencia);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/ciudadano/home");
		expService.modificarExperiencia(experiencia);
		LOGGER.info("Se modificó experiencia");
		return mav;
	} 
}
