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

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.service.IEmpleadorService;
import ar.edu.unju.fi.service.IProvinciaService;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {
	
	@Autowired
	@Qualifier("EmpleadorServiceImpSql")
	private IEmpleadorService empleadorService;
	@Autowired
	@Qualifier("ProvinciaServiceImpSql")
	private IProvinciaService provinciaService;

	private static final Log LOGGER = LogFactory.getLog(EmpleadorController.class);
	
	@GetMapping("/home")
	public String getHomeEmpleadorPage(Model model) {
		return "home_empleador"; 
	}
	
	/*
	@GetMapping("/nuevo_emp")
	public String getFormEmpleadorPage(Model model) {
		model.addAttribute("empleador", empleadorService.getEmpleador ());
		model.addAttribute("provincia", provinciaService.getListaProvincia());
		return "nuevo_empleador";
	}	
	*/

	@PostMapping("/guardar")
	public ModelAndView getDatosEmpleadorPage(@Validated @ModelAttribute("empleador")Empleador empleador, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_ciudadano");
			mav.addObject("empleador", empleador);
			return mav;
		}
		ModelAndView mavciudadano = new ModelAndView("redirect:/empleador/home");
		if (empleadorService.guardarEmpleador(empleador)) {
			LOGGER.info("Se guardo el empleador");
		}
		mavciudadano.addObject("empleador", empleador);
		return mavciudadano;
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosCiudadano(@Validated @ModelAttribute("empleador") Empleador empleador, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+ empleador);
			ModelAndView mav = new ModelAndView("edicion_empleador");
			mav.addObject("empleador", empleador);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/empleador/home");
		empleadorService.modificarEmpleador(empleador);
		LOGGER.info("Se modificó empleador");
		mav.addObject("empleador", empleadorService.getEmpleador());
		return mav;
	} 
	
	@GetMapping("/edicion/{email}")
	public ModelAndView getEditarEmpleadorPage(@PathVariable(value="email")String email) {
		ModelAndView mav = new ModelAndView("edicion_empleador");
		Empleador empleador = empleadorService.buscarEmpleadorPorEmail(email);
		mav.addObject("empleador",empleador);
		mav.addObject("provincia", provinciaService.getListaProvincia());
		return mav;
	}
	
}
