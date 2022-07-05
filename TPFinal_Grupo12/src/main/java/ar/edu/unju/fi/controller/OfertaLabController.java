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
import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.entity.OfertaLaboral;
import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.IEmpleadorService;
import ar.edu.unju.fi.service.IOfertaLaboralService;

@Controller
@RequestMapping("/ofertalab")
public class OfertaLabController {
	
	@Autowired
	@Qualifier("OfertaLabServiceImpSql")
	private IOfertaLaboralService ofertalabService;
	
	@Autowired
	@Qualifier("EmpleadorServiceImpSql")
	private IEmpleadorService empleadorService;
	
	@Autowired
	@Qualifier("CiudadanoServiceImpSql")
	private ICiudadanoService ciudadanoService;
	
	private static final Log LOGGER = LogFactory.getLog(OfertaLabController.class);
	
	@GetMapping("/nueva/{email}")
	public String getFormNuevoOfertaPage(@PathVariable(value="email")String email,Model model) {
		Empleador emp = empleadorService.buscarEmpleadorPorEmail(email);
		model.addAttribute("empleador", emp );
		model.addAttribute("ofertalab", ofertalabService.getOfertaLaboral());
		LOGGER.info("Nueva Oferta exitosa");
		return "nuevo_ofertalab";
	}
	
	@GetMapping("/lista_ofertas/{email}")
	public String getListaOfertasPage(@PathVariable(value="email")String email,Model model) {
		Empleador emp = empleadorService.buscarEmpleadorPorEmail(email);
		model.addAttribute("ofertalab", ofertalabService.buscarOfertaPorEmpleador(emp));
		return "lista_ofertas";
	}
	
	@PostMapping("/guardaroferta/{email}")
	public ModelAndView getGuardarOfertaLabPage(@Validated @ModelAttribute("ofertalab")OfertaLaboral ofertalab,@PathVariable(value="email")String email, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_ofertalab");
			mav.addObject("ofertalab", ofertalab);
			return mav;
		}
		ModelAndView mavoferta = new ModelAndView("redirect:/ofertalab/lista_ofertas/"+email);
		Empleador emp = empleadorService.buscarEmpleadorPorEmail(email);
		ofertalab.setEmpleador(emp);
		LOGGER.info(ofertalab);
		LOGGER.info(emp);
		
		if(ofertalabService.guardarOfertaLab(ofertalab)) {
			LOGGER.info("Oferta guardada-----------------");
		}
		emp.getOferLaborales().add(ofertalab);
		
		if (empleadorService.guardarEmpleador(emp)) {
			LOGGER.info("Se guardo nueva oferta laboral");
		}
		mavoferta.addObject("ofertalab", ofertalabService.buscarOfertaPorEmpleador(emp));
		return mavoferta; 
	}
	
	@GetMapping("/lista_ofertas_prov/{email}")
	public String getListaOfertasDelCiudadanoProvinciaPage(@PathVariable(value="email")String email,Model model) {
		Ciudadano ciud = ciudadanoService.buscarCiudadanoPorEmail(email);
		Provincia prov = ciud.getProvincia();
		model.addAttribute("ofertalab", ofertalabService.buscarOfertaPorProv(prov));
		model.addAttribute("ciudadano", ciud);
		return "listaOfertaProv";
	}
	@GetMapping("/lista_ofertas_all/{email}")
	public String getListaOfertasDelCiudadanoTodasPage(@PathVariable(value="email")String email,Model model) {
		Ciudadano ciud = ciudadanoService.buscarCiudadanoPorEmail(email);
		
		model.addAttribute("ofertalab", ofertalabService.buscarTodasOferta());
		model.addAttribute("ciudadano", ciud);
		return "listaOfertasTodas";
	}
	

}
