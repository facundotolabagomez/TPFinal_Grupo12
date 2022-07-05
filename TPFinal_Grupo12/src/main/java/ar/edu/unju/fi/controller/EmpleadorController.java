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
import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IEmpleadorService;
import ar.edu.unju.fi.service.IOfertaLaboralService;
import ar.edu.unju.fi.service.IProvinciaService;
import ar.edu.unju.fi.service.IUsuarioService;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {
	
	@Autowired
	@Qualifier("EmpleadorServiceImpSql")
	private IEmpleadorService empleadorService;
	
	@Autowired
	@Qualifier("ProvinciaServiceImpSql")
	private IProvinciaService provinciaService;
	
	@Autowired
	@Qualifier("UsuarioServiceImpSql")
	private IUsuarioService usuarioService;
	
	@Autowired
	@Qualifier("OfertaLabServiceImpSql")
	private IOfertaLaboralService oferService;

	private static final Log LOGGER = LogFactory.getLog(EmpleadorController.class);
	
	@GetMapping("/home")
	public String getHomeEmpleadorPage(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		Empleador e = empleadorService.buscarEmpleadorPorEmail(username);
		model.addAttribute("empleador", e);
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
	
	/*
	 * @PostMapping("/modificar") public ModelAndView
	 * editarDatosEmpleador(@Validated @ModelAttribute("empleador") Empleador
	 * empleador, BindingResult bindingResult ) { if(bindingResult.hasErrors()) {
	 * LOGGER.info("ocurrió un error "+ empleador); ModelAndView mav = new
	 * ModelAndView("edicion_empleador"); mav.addObject("empleador", empleador);
	 * return mav; } ModelAndView mav = new
	 * ModelAndView("redirect:/empleador/home");
	 * empleadorService.modificarEmpleador(empleador);
	 * LOGGER.info("Se modificó empleador"); mav.addObject("empleador",
	 * empleadorService.getEmpleador()); return mav; }
	 */ 
	
	@GetMapping("/edicion/{email}")
	public ModelAndView getEditarEmpleadorPage(@PathVariable(value="email")String email) {
		ModelAndView mav = new ModelAndView("edicion_empleador");
		Empleador empleador = empleadorService.buscarEmpleadorPorEmail(email); 
		LOGGER.info(empleador.getEmail());		
		Usuario user = usuarioService.buscarUsuario(email, true);
		
		empleador.setUsuario(user);
		
		if(empleadorService.guardarEmpleador(empleador)) {
			LOGGER.info("CIUDADANO SAVE");
		}
		mav.addObject("empleador", empleador);
		mav.addObject("provincia", provinciaService.getListaProvincia());
		mav.addObject("usuario", empleador.getUsuario());
		
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosEmpleador(@Validated @ModelAttribute("empleador") Empleador empleador, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+ empleador);
			ModelAndView mav = new ModelAndView("edicion_empleador");
			mav.addObject("empleador", empleador);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("redirect:/empleador/home");
		Empleador emp = empleadorService.buscarEmpleadorPorEmail(empleador.getEmail());
		
		if (empleador.getCiudadanos()==null) {
			
		}else {
			emp.setCiudadanos(empleador.getCiudadanos());
		}
		
		
		if (empleador.getCuit()!=null) {
			emp.setCuit(empleador.getCuit());
		}
		if(empleador.getDescripcion()!=null) {
			emp.setDescripcion(empleador.getDescripcion());
		}
		if(empleador.getDomicilio()!=null) {
			emp.setDomicilio(empleador.getDomicilio());
		}
		if(empleador.getInicioActividad()!=null) {
			emp.setInicioActividad(empleador.getInicioActividad());
		}
		if(empleador.getNombreComercial()!=null) {
			emp.setNombreComercial(empleador.getNombreComercial());
		}
		
		//----------------------------------
		if (empleador.getOferLaborales()==null) {
			
		}else {
			emp.setOferLaborales(empleador.getOferLaborales());
		}
		
		
		if(empleador.getPagWeb()!=null) {
			emp.setPagWeb(empleador.getPagWeb());
		}
		
		if(empleador.getRazonSocial()!=null) {
			emp.setRazonSocial(empleador.getRazonSocial());
		}
		if(empleador.getTelefono()!=null) {
			emp.setTelefono(empleador.getTelefono());
		}
		
		emp.setProvincia(empleador.getProvincia());
		
		empleadorService.modificarEmpleador(emp);
		LOGGER.info("Se modificó empleador");
		
		mav.addObject("empleador", empleador);
		return mav;
	} 
	
	 
}
