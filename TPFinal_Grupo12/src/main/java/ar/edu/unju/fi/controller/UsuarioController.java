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

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.IEmpleadorService;
import ar.edu.unju.fi.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	@Qualifier("UsuarioServiceImpSql")
	private IUsuarioService usuarioService;
	@Autowired
	@Qualifier("CiudadanoServiceImpSql")
	private ICiudadanoService ciudadanoService;
	@Autowired
	@Qualifier("EmpleadorServiceImpSql")
	private IEmpleadorService empleadorService;
	
	private static final Log LOGGER = LogFactory.getLog(UsuarioController.class);

	@GetMapping("/registro")
	public String getFormUsuarioRegistroPage(Model model) {
		model.addAttribute("usuario", usuarioService.getUsuario());
		return "registro_usuario";
	}
	
	/* @PostMapping("/guardar")
	public ModelAndView getRegistroPage(@Validated @ModelAttribute("usuario")Usuario usuario, BindingResult bindingResult) {
		LOGGER.info(usuario.getTipoUsuario()+"asdasas");
		ModelAndView mav = new ModelAndView();
		if (bindingResult.hasErrors()) {
			LOGGER.info(usuario.getTipoUsuario()+"asdasas");
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mavError = new ModelAndView("registro");
			mavError.addObject("usuario", usuario);
			return mavError;
		}else {
			LOGGER.info(usuario.getTipoUsuario()+"asdasas");
			try {
				LOGGER.info(usuario.getTipoUsuario());
				if(usuarioService.guardarUsuario(usuario)) {
					mav.addObject("usuario", usuario);
					LOGGER.info("Se guardo nuevo usuario");
				}
				
			}catch (Exception e){
				mav.addObject("formUsuarioErrorMessage", e.getMessage());
				LOGGER.error("ERROR AL REGISTRAR");
			}
		}
		ModelAndView mavUs = new ModelAndView("/empleos/inicio");
		return mavUs; 
	} */
	
	@PostMapping("/guardar")
	public ModelAndView getHomePage(@Validated @ModelAttribute("usuario")Usuario usuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_provincia");
			mav.addObject("usuario", usuario);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/empleos/inicio");
		//preguntamos si el tipo de usuario es ciudadano
		if (usuario.getTipoUsuario().equals("CIUDADANO")) {
			//en caso de ser asi, le asignamos el id de un ciudadano nuevo
			Ciudadano ciudadano = ciudadanoService.getCiudadano();
			//y a este ciudadano nuevo le asignamos el mismo email y pass del usuario
			ciudadano.setEmail(usuario.getEmailUser());
			ciudadano.setPassword(usuario.getPasswordUser());
			ciudadano.setExisteCiudadano(true);
			usuario.setCiudadano(ciudadano);
		}else if (usuario.getTipoUsuario().equals("EMPLEADOR")) {
			//en caso de ser empleador, le asignamos el id de un empleador nuevo
			Empleador empleador = empleadorService.getEmpleador();
			//y a este empleador nuevo le asignamos el mismo email y pass del usuario
			empleador.setEmail(usuario.getEmailUser());
			empleador.setPassword(usuario.getPasswordUser());
			empleador.setExisteEmpleador(true);
			usuario.setEmpleador(empleador);
		}else {
			LOGGER.error("NO SE PUDO VINCULAR NI CON CIUDADANO NI CON EMPLEADOR");
		}
			
		if (usuarioService.guardarUsuario(usuario)) {
			LOGGER.info("Se guardo el nuevo usuario");
		}
		mav.addObject("usuario");
		return mav; 
	}
	
	@GetMapping({"/", "/login"})
	public String getLoginPage(Model model) {
		model.addAttribute("usuario", usuarioService.getUsuario());
		return "login";
	}
	
	/*
	@PostMapping("/ingresar")
	public ModelAndView getLoginPage(@Validated @ModelAttribute("usuario")Usuario usuario, BindingResult bindingResult,RedirectAttributes redirAttrs) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("redirect:/usuario/login");
			mav.addObject("usuario", usuario);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("");
		//Ciudadano ciudadano = ciudadanoService.getCiudadano();
		
		if (usuarioService.buscarUsuario(usuario.getEmailUser(), true)==null) {
			redirAttrs.addFlashAttribute("error", "No existe el usuario, debe registrarse");
			mav.setViewName("redirect:/usuario/registro");
		}else {
			
			if (usuario.getTipoUsuario()=="EMPLEADOR") {
				//mav.setViewName("redirect:/empleador/home");
				
			}else if (usuario.getTipoUsuario()=="CIUDADANO") {
				mav.setViewName("redirect:/ciudadano/home");
							
			}else {
				LOGGER.error("ERROR EN EL TIPO DE USUARIO");
			}
			
		}
		
		mav.addObject("usuario");
		return mav; 
	}*/

}
