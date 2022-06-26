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

import ar.edu.unju.fi.entity.Idioma;
import ar.edu.unju.fi.service.IIdiomaService;


@Controller
@RequestMapping("/idioma")
public class IdiomasController {
	
	@Autowired
	@Qualifier("IdiomaServiceImpSql")
	private IIdiomaService idiomaService;

	
	private static final Log LOGGER = LogFactory.getLog(ProvinciasController.class);
	
	@GetMapping("/nuevo_idioma")
	public String getFormIdiomaPage(Model model) {
		//System.out.println(cursoService.getListaCurso().size());
		//model.addAttribute("curso", cursoService.getListaCurso());
		model.addAttribute("idioma", idiomaService.getIdioma());
		return "nuevo_idioma";
	}

	
	@PostMapping("/guardar")
	public ModelAndView getListaIdiomaPage(@Validated @ModelAttribute("idioma")Idioma idioma, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_idioma");
			mav.addObject("idioma", idioma);
			return mav;
		}
		
		ModelAndView mavidioma = new ModelAndView("redirect:/idioma/lista_idio");
		
		if (idiomaService.guardarIdioma(idioma)) {
			LOGGER.info("Se guardo nueva provincia");
		}
		mavidioma.addObject("idioma", idiomaService.getListaIdioma());
		return mavidioma; 
		
	} 
	
	@GetMapping("/lista_idio")
	public String getListaIdiomasPage(Model model) {
		//ListaAlumno listaAlumnos = new ListaAlumno();
		model.addAttribute("idioma", idiomaService.getListaIdioma());
		return "idiomas_lista";
	}
	
	
	@GetMapping("/editar/{nombreIdioma}")
	public ModelAndView getEditarIdiomaPage(@PathVariable(value="nombreIdioma")String nombreIdioma) {
		ModelAndView mav = new ModelAndView("edicion_idioma");
		Idioma idioma = idiomaService.buscarIdioma(nombreIdioma);
		mav.addObject("idioma",idioma);
		return mav;
	}
	
	
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosIdioma(@Validated @ModelAttribute("idioma") Idioma idioma, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+ idioma);
			ModelAndView mav = new ModelAndView("edicion_idioma");
			mav.addObject("idioma", idioma);
			return mav;
		}
		
		
		ModelAndView mav = new ModelAndView("redirect:/idioma/lista_idio");
		idiomaService.modificarIdioma(idioma);
		mav.addObject("idioma", idiomaService.getListaIdioma());		
		return mav;
	} 
	
	
	
	@GetMapping("/eliminar/{idioma_id}")
	public ModelAndView getEliminarIdiomaPage(@PathVariable(value = "idioma_id") long idioma_id) {
		ModelAndView mavIdioma = new ModelAndView("redirect:/idioma/lista_idio");
		idiomaService.eliminarIdioma(idioma_id);
		LOGGER.info("Se eliminó el alumno");
		return mavIdioma;
	}
	
}
	


