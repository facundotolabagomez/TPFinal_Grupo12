package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.ICursoService;


@Controller
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	@Qualifier("CursoServiceImpSql")
	private ICursoService cursoService;
	
	@Autowired
	@Qualifier("CiudadanoServiceImpSql")
	private ICiudadanoService ciudadanoService;
	
	private static final Log LOGGER = LogFactory.getLog(CursoController.class);
	
	@GetMapping("/lista/{email}")
	public String getListaCursosPage(Model model) {
		//ListaAlumno listaAlumnos = new ListaAlumno();
		model.addAttribute("curso", cursoService.getListaCurso());
		return "lista_cursos";
	}

	@GetMapping("/miscursos/{curso_id}/{email}")
	public ModelAndView getMisCursosPage(@PathVariable(value = "curso_id")long curso_id,@PathVariable(value = "email")String email){
		ModelAndView mav = new ModelAndView("mis_cursos");
		Curso cur = cursoService.buscarCurso(curso_id);
		Ciudadano ciud = ciudadanoService.buscarCiudadanoPorEmail(email);
		mav.addObject("curso", cur);
		mav.addObject("ciudadano",ciud);
		return mav;
	}
	
	//(@Validated @ModelAttribute("ofertalab")OfertaLaboral ofertalab,@PathVariable(value="email")String email
	
	@PostMapping("/inscripcion/{curso_id}/{email}")
	public ModelAndView getIncripcionCursosPage(@PathVariable(value = "curso_id")long curso_id,@PathVariable(value = "email")String email) {
		ModelAndView mavcurso = new ModelAndView("redirect:/cursos/lista"+email);
		Ciudadano ciud = ciudadanoService.buscarCiudadanoPorEmail(email);
		Curso cur = cursoService.buscarCurso(curso_id);
		ciud.getCursos().add(cur);
		return mavcurso;
		
		
	}
	
}
