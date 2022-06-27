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

import ar.edu.unju.fi.entity.Educacion;
import ar.edu.unju.fi.service.IEducacionService;

@Controller
@RequestMapping("/educacion")
public class EducacionController {
	
	@Autowired
	@Qualifier("EducacionServiceImpSql")
	private IEducacionService educacionService;
	
	private static final Log LOGGER = LogFactory.getLog(EducacionController.class);
	
	@GetMapping("/nuevo_educ")
	public String getFormEducacionPage(Model model) {
		model.addAttribute("educacion", educacionService.getEducacion());
		return "nuevo_educacion";
	}

	@PostMapping("/guardar")
	public ModelAndView getListaEducacionPage(@Validated @ModelAttribute("educacion")Educacion educacion, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_educacion");
			mav.addObject("educacion", educacion);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:educacion/lista_educ");
		if (educacionService.guardarEducacion(educacion)) {
			LOGGER.info("Se guardo nuevo nivel educativo");
		}
		mav.addObject("educacion", educacionService.getListaEducacion());
		return mav; 
	} 
	
	@GetMapping("/lista_educ")
	public String getListaEducacionPage(Model model) {
		model.addAttribute("educacion", educacionService.getListaEducacion());
		return "educacion_lista";
	}
	
	@GetMapping("/editar/{nivelAlcanzado}")
	public ModelAndView getEditarEducacionPage(@PathVariable(value="nivelAlcanzado")String nivelAlcanzado) {
		ModelAndView mav = new ModelAndView("edicion_educacion");
		Educacion educ = educacionService.buscarEducacion(nivelAlcanzado);
		mav.addObject("educacion",educ);
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosEducacion(@Validated @ModelAttribute("educacion")Educacion educacion, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+ educacion);
			ModelAndView mav = new ModelAndView("edicion_educacion");
			mav.addObject("educacion", educacion);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/educacion/lista_educ");
		educacionService.modificarEducacion(educacion);
		LOGGER.info("Se modificó el nivel educativo");
		mav.addObject("educacion", educacionService.getListaEducacion());
		return mav;
	} 
	
	@GetMapping("/eliminar/{educacion_id}")
	public ModelAndView getEliminarEducacionPage(@PathVariable(value = "educacion_id") long educacion_id) {
		ModelAndView mav = new ModelAndView("redirect:/educacion/lista_educ");
		educacionService.eliminarEducacion(educacion_id);
		LOGGER.info("Se eliminó el nivel educativo");
		return mav;
	}
}
