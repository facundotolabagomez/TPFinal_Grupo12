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
import ar.edu.unju.fi.entity.Curriculum;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.ICurriculumService;
import ar.edu.unju.fi.service.IProvinciaService;
import ar.edu.unju.fi.service.IUsuarioService;


@Controller
@RequestMapping("/ciudadano")
public class CiudadanoController {
	
	@Autowired
	@Qualifier("CiudadanoServiceImpSql")
	private ICiudadanoService ciudadanoService;
	@Autowired
	@Qualifier("ProvinciaServiceImpSql")
	private IProvinciaService provinciaService;
	@Autowired
	@Qualifier("UsuarioServiceImpSql")
	private IUsuarioService usuarioService;
	@Autowired
	@Qualifier("CurriculumServiceImpSql")
	private ICurriculumService curriculumService;
	
	
	private static final Log LOGGER = LogFactory.getLog(CiudadanoController.class);
	
	@GetMapping("/home")
	public String getHomeUsuarioPage(Model model) {
		return "home_usuario"; 
	}
	
	/*
	@GetMapping("/nuevo_ciud")
	public String getFormCiudadanoPage(Model model) {
		model.addAttribute("ciudadano", ciudadanoService.getCiudadano());
		model.addAttribute("provincia", provinciaService.getListaProvincia());
		return "nuevo_ciudadano";
	}

	*/
	
	@PostMapping("/guardar")
	public ModelAndView getDatosCiudadanoPage(@Validated @ModelAttribute("ciudadano")Ciudadano ciudadano, BindingResult bindingResult) {
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
		mavciudadano.addObject("ciudadano", ciudadano);
		return mavciudadano;
	}
	
	
	//comento el lista ciudadano, porque solo lo usaría el admin
	/*
	@GetMapping("/lista_ciud")
	public String getListaCiudadanosPage(Model model) {
		//ListaAlumno listaAlumnos = new ListaAlumno();
		model.addAttribute("ciudadano", ciudadanoService.getListaCiudadano());
		return "ciudadanos_lista";
	}
	*/
	
	@GetMapping("/edicion/{email}")
	public ModelAndView getEditarCiudadanoPage(@PathVariable(value="email")String email) {
		ModelAndView mav = new ModelAndView("edicion_ciudadano");
		Ciudadano ciudadano = ciudadanoService.buscarCiudadanoPorEmail(email);
		
		if (ciudadano.getCurriculum()==null) {
			Curriculum cv = curriculumService.getCurriculum();
			cv.setExisteCurriculum(false);
			ciudadano.setCurriculum(cv);
			LOGGER.info("CV VACIO");
		}else {
			LOGGER.info("CV EXISTE");
			long idcv = ciudadano.getCurriculum().getCurriculum_id();
			Curriculum cv = curriculumService.buscarCurriculum(idcv);
			ciudadano.setCurriculum(cv);
		}
		
		Usuario user = usuarioService.buscarUsuario(email, true);
		ciudadano.setUsuario(user);
		LOGGER.info(ciudadano.getUsuario());
		
		mav.addObject("ciudadano",ciudadano);
		mav.addObject("provincia", provinciaService.getListaProvincia());
		mav.addObject("usuario", ciudadano.getUsuario());
		mav.addObject("curriculum", ciudadano.getCurriculum());
		
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosCiudadano(@Validated @ModelAttribute("ciudadano") Ciudadano ciudadano, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+ ciudadano);
			ModelAndView mav = new ModelAndView("edicion_ciudadano");
			mav.addObject("ciudadano", ciudadano);
			
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/ciudadano/home");
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
