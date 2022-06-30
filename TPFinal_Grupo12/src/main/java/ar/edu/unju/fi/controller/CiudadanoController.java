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
import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.IProvinciaService;


@Controller
@RequestMapping("/ciudadano")
public class CiudadanoController {
	
	@Autowired
	@Qualifier("CiudadanoServiceImpSql")
	private ICiudadanoService ciudadanoService;
	@Autowired
	@Qualifier("ProvinciaServiceImpSql")
	private IProvinciaService provinciaService;
	
	private static final Log LOGGER = LogFactory.getLog(CiudadanoController.class);
	
	@GetMapping("/home")
	public String getHomeUsuarioPage(Model model) {
		return "home_usuario"; 
	}
	
	@GetMapping("/nuevo_ciud")
	public String getFormCiudadanoPage(Model model) {
		model.addAttribute("ciudadano", ciudadanoService.getCiudadano());
		model.addAttribute("provincia", provinciaService.getListaProvincia());
		return "nuevo_ciudadano";
	}

	
	@PostMapping("/guardar")
	public ModelAndView getListaCiudadanoPage(@Validated @ModelAttribute("ciudadano")Ciudadano ciudadano, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_ciudadano");
			mav.addObject("ciudadano", ciudadano);
			return mav;
		}
		ModelAndView mavciudadano = new ModelAndView("redirect:/ciudadano/home");
		if (ciudadanoService.guardarCiudadano(ciudadano)) {
			LOGGER.info("Se guardo nuevo ciudadano");
		}
		mavciudadano.addObject("ciudadano", ciudadanoService.getListaCiudadano());
		return mavciudadano; 
	}
	
	
	@GetMapping("/lista_ciud")
	public String getListaCiudadanosPage(Model model) {
		//ListaAlumno listaAlumnos = new ListaAlumno();
		model.addAttribute("ciudadano", ciudadanoService.getListaCiudadano());
		return "ciudadanos_lista";
	}
	
	/*@GetMapping("/editar/{ciudadano_id}")
	public ModelAndView getEditarCiudadanoPage(@PathVariable(value="ciudadano_id")int dni) {
		ModelAndView mav = new ModelAndView("edicion_ciudadano");
		Ciudadano ciudadano = ciudadanoService.buscarCiudadano(dni);
		mav.addObject("ciudadano",ciudadano);
		return mav;
	}*/
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosCiudadano(@Validated @ModelAttribute("ciudadano") Ciudadano ciudadano, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+ ciudadano);
			ModelAndView mav = new ModelAndView("edicion_ciudadano");
			mav.addObject("ciudadano", ciudadano);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/ciudadano/lista_ciud");
		ciudadanoService.modificarCiudadano(ciudadano);
		LOGGER.info("Se modificó ciudadano");
		mav.addObject("ciudadano", ciudadanoService.getListaCiudadano());
		return mav;
	} 
	
	/*@GetMapping("/eliminar/{ciudadano_id}")
	public ModelAndView getEliminarCiudadanoPage(@PathVariable(value = "ciudadano_id") long ciudadano_id) {
		ModelAndView mav = new ModelAndView("redirect:/ciudadano/lista_ciud");
		ciudadanoService.eliminarCiudadano(ciudadano_id);
		LOGGER.info("Se eliminó el ciudadano");
		return mav;
	}*/
}
