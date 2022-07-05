package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//private static final Log LOGGER = LogFactory.getLog(CursoController.class);
	
	@GetMapping("/lista/{email}")
	public String getListaCursosPage(@PathVariable(value = "email")String email,Model model) {
		//ListaAlumno listaAlumnos = new ListaAlumno();
		Ciudadano ciud = ciudadanoService.buscarCiudadanoPorEmail(email);
		model.addAttribute("curso", cursoService.getListaCurso());
		model.addAttribute("ciudadano", ciud);
		return "lista_cursos";
	}

	@GetMapping("/miscursos/{email}")
	public ModelAndView getMisCursosPage(@PathVariable(value = "email")String email){
		ModelAndView mav = new ModelAndView("mis_cursos");
		
		Ciudadano ciud = ciudadanoService.buscarCiudadanoPorEmail(email);
		mav.addObject("curso", ciud.getCursos());
		mav.addObject("ciudadano", ciud);
		return mav;
	}
	
	//(@Validated @ModelAttribute("ofertalab")OfertaLaboral ofertalab,@PathVariable(value="email")String email
	
	@GetMapping("/inscripcion/{curso_id}/{email}")
	public ModelAndView getIncripcionCursosPage(@PathVariable(value = "curso_id")long curso_id,@PathVariable(value = "email")String email) {
		
		Ciudadano ciud = ciudadanoService.buscarCiudadanoPorEmail(email);
		Curso cur = cursoService.buscarCurso(curso_id);
		ModelAndView mavcurso = new ModelAndView("redirect:/cursos/lista/"+email);
		ciud.getCursos().add(cur);
		if (ciudadanoService.guardarCiudadano(ciud)) {
			//LOGGER.info("Inscripto en curso = "+cur.getNombreCurso());
		}
		return mavcurso;
		
		
	}
	
}
