package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	@Qualifier("UsuarioServiceImpSql")
	private IUsuarioService usuarioService;
	
	private static final Log LOGGER = LogFactory.getLog(UsuarioController.class);

	@GetMapping("/registro")
	public String getFormUsuarioRegistroPage(Model model) {
		model.addAttribute("usuario", usuarioService.getUsuario());
		return "registro_usuario";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getRegistroPage(@Validated @ModelAttribute("usuario")Usuario usuario, BindingResult bindingResult,ModelMap model) {
		if (bindingResult.hasErrors()) {
			LOGGER.info(usuario.getTipoUsuario()+"asdasas");
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("registro");
			mav.addObject("usuario", usuario);
			return mav;
		}else {
			LOGGER.info(usuario.getTipoUsuario()+"asdasas");
			try {
				LOGGER.info(usuario.getTipoUsuario());
				usuarioService.crearUsuario(usuario);
				model.addAttribute("usuario", usuario);
				LOGGER.info("Se guardo nuevo usuario");
				
			}catch (Exception e){
				model.addAttribute("formUsuarioErrorMessage", e.getMessage());
				LOGGER.error("ERROR AL REGISTRAR");
			}
		}
		ModelAndView mavUs = new ModelAndView("/empleos/inicio");
		return mavUs; 
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
