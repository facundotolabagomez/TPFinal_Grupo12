package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	//este metodo carga los datos de la pagina de inicio del Ciudadano
	@GetMapping("/home")
	public String getHomeUsuarioPage(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		Ciudadano c = ciudadanoService.buscarCiudadanoPorEmail(username);
		boolean cvExiste = c.getCurriculum().isExisteCurriculum();
		LOGGER.info("CVEXISTE?"+cvExiste);
		model.addAttribute("curriculum",c.getCurriculum());
		model.addAttribute("ciudadano", c);
		model.addAttribute("cvexiste", cvExiste);
		return "home_usuario"; 
	}
	
	
	//carga los datos en el form
	@GetMapping("/edicion/{email}")
	public ModelAndView getEditarCiudadanoPage(@PathVariable(value="email")String email) {
		ModelAndView mav = new ModelAndView("edicion_ciudadano");
		Ciudadano ciudadano = ciudadanoService.buscarCiudadanoPorEmail(email);
		
		if (ciudadano.getCurriculum()==null) {
			Curriculum cv = curriculumService.getCurriculum();
			LOGGER.info(cv);
			cv.setExisteCurriculum(false);
			if(curriculumService.guardarCurriculum(cv)) {
				ciudadano.setCurriculum(cv);
				LOGGER.info("CV SAVE");
			}
			
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
		if(ciudadanoService.guardarCiudadano(ciudadano)) {
			LOGGER.info("CIUDADANO SAVE");
		}
		mav.addObject("ciudadano",ciudadano);
		mav.addObject("provincia", provinciaService.getListaProvincia());
		mav.addObject("usuario", ciudadano.getUsuario());
		mav.addObject("curriculum", ciudadano.getCurriculum());
		
		return mav;
	}
	
	//trae los datos del form y los actualiza en la BD
	@PostMapping("/modificar")
	public ModelAndView editarDatosCiudadano(@Validated @ModelAttribute("ciudadano") Ciudadano ciudadano, BindingResult bindingResult,RedirectAttributes redirectAttrs ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+ ciudadano);
			ModelAndView mav = new ModelAndView("edicion_ciudadano");
			mav.addObject("ciudadano", ciudadano);
			//--------------------------------------------
			mav.addObject("provincia", provinciaService.getListaProvincia());
			mav.addObject("usuario", ciudadano.getUsuario());
			mav.addObject("curriculum", ciudadano.getCurriculum());
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/ciudadano/home");
		LOGGER.info("EDAD: --------"+ciudadano.obtenerEdad());
		if(ciudadano.obtenerEdad()<18) {
			LOGGER.info("PROBLEMA CON LA EDAD - MENOR DE 18");
			ciudadano.setExisteCiudadano(false);
			Usuario user = usuarioService.buscarUsuario(ciudadano.getEmail(), true);
			try {
				String error = "Usuario eliminado por no tener la edad apropiada";
				redirectAttrs
	            	.addFlashAttribute("mensaje", error)
	            	.addFlashAttribute("clase", "error");
				mav.setViewName("redirect:/empleos/error");
				mav.addObject("error", error);
				
				Thread.sleep(1000); 
			}catch (Exception e) {	}
			SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
			user.setExisteUsuario(false);
			usuarioService.modificarUsuario(user);
			return mav;
		}
		
		//para empresa ----
		Usuario us = usuarioService.buscarUsuario(ciudadano.getEmail(), true); 
		
		if(ciudadano.getUsuario().getEmailUser()==null) {
			ciudadano.getUsuario().setEmailUser(us.getEmailUser());
			ciudadano.getUsuario().setPasswordUser(us.getPasswordUser());
			ciudadano.getUsuario().setEmpleador(us.getEmpleador());
			ciudadano.getUsuario().setCiudadano(us.getCiudadano());
			ciudadano.getUsuario().setTipoUsuario(us.getTipoUsuario());
		}
		LOGGER.info("-------------AQUI---------");
		Ciudadano ciud = ciudadanoService.buscarCiudadanoPorEmail(ciudadano.getEmail());
		LOGGER.info("------- ID CURRI -----"+ciud.getCurriculum().getCurriculum_id());
		Curriculum cv = curriculumService.buscarCurriculum(ciud.getCurriculum().getCurriculum_id()); 
		
		
		if(ciudadano.getCurriculum().isExisteCurriculum()) {
			//ciudadano.setCurriculum(cv);
			  ciudadano.getCurriculum().setCiudadano(cv.getCiudadano());
			  ciudadano.getCurriculum().setConocInfor(cv.getConocInfor());
			  ciudadano.getCurriculum().setCurriculum_id(cv.getCurriculum_id());
			  ciudadano.getCurriculum().setEducacion(cv.getEducacion());
			  ciudadano.getCurriculum().setExisteCurriculum(cv.isExisteCurriculum());
			  ciudadano.getCurriculum().setExpLab(cv.getExpLab());
			  ciudadano.getCurriculum().setIdioma(cv.getIdioma());
			  ciudadano.getCurriculum().setInfoComplem(cv.getInfoComplem());
		}
		
		ciud.setApellidoCiudadano(ciudadano.getApellidoCiudadano());
		ciud.setCurriculum(ciudadano.getCurriculum());
		//ciud.setCursos(null)
		ciud.setDni(ciudadano.getDni());
		//ciud.setEmpleadores(null)
		ciud.setEstadoCivil(ciudadano.getEstadoCivil());
		ciud.setFechaNac(ciudadano.getFechaNac());
		ciud.setNombresCiudadano(ciudadano.getNombresCiudadano());
		ciud.setNumeroTramite(ciudadano.getNumeroTramite());
		//ciud.setOfertas(null)
		ciud.setProvincia(ciudadano.getProvincia());
		ciud.setTelefono(ciudadano.getTelefono());
		
		
		ciudadanoService.modificarCiudadano(ciud);
		LOGGER.info("Se modificó ciudadano");
		mav.addObject("ciudadano", ciudadano);
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
