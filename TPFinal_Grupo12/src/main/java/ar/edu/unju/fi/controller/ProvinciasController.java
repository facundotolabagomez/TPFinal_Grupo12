package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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


import ar.edu.unju.fi.entity.Provincia;

@Controller
@RequestMapping("/provincia")
public class ProvinciasController {
	
	private static final Log LOGGER = LogFactory.getLog(ProvinciasController.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoAlumnoPage(Model model) {
		//System.out.println(cursoService.getListaCurso().size());
		//model.addAttribute("curso", cursoService.getListaCurso());
		//model.addAttribute("provincia", provinciaService.getProvincia());
		return "nuevo_provincia";
	}

	@PostMapping("/guardar")
	public ModelAndView getListaAlumnosPage(@Validated @ModelAttribute("provincia")Provincia provincia, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");

			ModelAndView mav = new ModelAndView("nuevo_provincia");
			mav.addObject("provincia", provincia);
			//mav.addObject("curso", cursoService.getListaCurso());
			return mav;
		}
		
		ModelAndView mavprovincia = new ModelAndView("redirect:/provincia/lista");
		/*
		 * List <Curso> curso = null; for(int i=0;i < alumno.getCursos().size();i++) {
		 * Curso e = new Curso(); e.setCodigo(alumno.getCursos().get(i).getCodigo());
		 * cursoService.buscarCurso(e.getCodigo(), true); curso.add(e); }
		 */
		//Curso curso = cursoService.buscarCurso(alumno.getCursos().get(alumno.), true);
		//ListaAlumno listaAlumnos = new ListaAlumno();
		if (provinciaService.guardarProvincia(provincia)) {
			LOGGER.info("Se guardo nueva provincia");
		}
		mavalumno.addObject("provincia", provinciaService.getListaProvincia());
		return mavprovincia; 
		
	}
	
	@GetMapping("/lista")
	public String getListaProvinciasPage(Model model) {
		//ListaAlumno listaAlumnos = new ListaAlumno();
		model.addAttribute("provincia", provinciaService.getListaProvincias());
		return "provincias_lista";
	}
	
	@GetMapping("/editar/{provincia_id}")
	public ModelAndView getEditarAlumnoPage(@PathVariable(value="provincia_id")long provincia_id) {
		ModelAndView mav = new ModelAndView("edicion_provincia");
		Alumno alumno = alumnoService.buscarAlumno(dni);
		mav.addObject("alumno",alumno);
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosProvincia(@Validated @ModelAttribute("provincia") Provincia provincia, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+ provincia);
			ModelAndView mav = new ModelAndView("edicion_provincia");
			mav.addObject("provincia", provincia);
			return mav;
		}
		
		
		ModelAndView mav = new ModelAndView("redirect:/provincia/lista");
		provinciaService.modificarAlumno(provincia);
		//mav.addObject("alumno", listaAlumnos.getAlumnos());		
		return mav;
	}
	
	@GetMapping("/eliminar/{provincia_id}")
	public ModelAndView getEliminarProvinciaPage(@PathVariable(value = "provincia_id") long provincia_id) {
		ModelAndView mavAlumno = new ModelAndView("redirect:/provincia/lista");
		provinciaService.eliminarProvincia(provincia_id);
		LOGGER.info("Se eliminó el alumno");
		//mavAlumno.addObject("candidato", listaAlumnos.getAlumnos());
		return mavAlumno;
	}
}
	
