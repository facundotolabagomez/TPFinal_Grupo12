package ar.edu.unju.fi.controller;

import java.util.List;

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


import ar.edu.unju.fi.entity.Curriculum;
import ar.edu.unju.fi.entity.ExperienciaLaboral;
import ar.edu.unju.fi.entity.Idioma;
import ar.edu.unju.fi.service.ICurriculumService;
import ar.edu.unju.fi.service.IEducacionService;
import ar.edu.unju.fi.service.IExperienciaLaboralService;
import ar.edu.unju.fi.service.IIdiomaService;


@Controller
@RequestMapping("/cv")
public class CurriculumController {
	
	@Autowired
	@Qualifier("CurriculumServiceImpSql")
	private ICurriculumService curriculumService;
	
	@Autowired
	@Qualifier("EducacionServiceImpSql")
	private IEducacionService educacionService;
	
	@Autowired
	@Qualifier("IdiomaServiceImpSql")
	private IIdiomaService idiomaService;
	
	@Autowired
	@Qualifier("ExperienciaLaboralServiceImpSql")
	private IExperienciaLaboralService explabService;
	
	
	private static final Log LOGGER = LogFactory.getLog(CurriculumController.class);
	
	@PostMapping("/guardar/{curriculum_id}")
	public ModelAndView getDatosCurriculumPage(@Validated @ModelAttribute("curriculum")Curriculum curriculum,@PathVariable(value="curriculum_id")long curriculum_id, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_curriculum");
			mav.addObject("curriculum", curriculum);
			return mav;
		}
		ModelAndView mavcurriculum = new ModelAndView("redirect:/ciudadano/home");
		Curriculum curri = curriculumService.buscarCurriculum(curriculum_id);
		//curri.getIdiomas().
		//Idioma idi = idiomaService.buscarIdiomaPorId(idioma.getIdioma_id());
		
		LOGGER.info("curriculum get educacion"+curriculum.getEducacion());
		LOGGER.info("curriculum get explist"+curriculum.getExpLaboral());
		if ((curriculum.getEducacion()!=null)&&(curriculum.getIdiomas()!=null)) {
			curri.setExisteCurriculum(true);
		}
		
		List<ExperienciaLaboral> list_explab;
		//Si tiene exp laboral, mantenemos la misma y la pasamos al mav
		//Si no tiene le creamos una para que pueda llenarla
		if (curri.getExpLaboral()==null) {
			list_explab = explabService.getListaExperienciaLaboral();
			curri.setExpLaboral(list_explab);
		}else {
			list_explab = curri.getExpLaboral();
		}
		
		List<Idioma> list_idioma;
		//Si tiene lista de idiomas, mantenemos la misma y la pasamos al mav
		//Si no tiene le creamos una para que pueda llenarla
		if (curri.getIdiomas()==null) {
			list_idioma = idiomaService.getListaIdioma();
			curri.setIdiomas(list_idioma);
		}else {
			list_idioma = curri.getIdiomas();
		}
		
		LOGGER.info(curri);
		if(curriculumService.guardarCurriculum(curri)) {
			LOGGER.info("CURRICULUM UPDATE");
		}
		
		mavcurriculum.addObject("curriculum", curri);
		mavcurriculum.addObject("educacion", educacionService.getListaEducacion());
		mavcurriculum.addObject("explab",list_explab);
		mavcurriculum.addObject("idioma",list_idioma);
		return mavcurriculum;
	}
	
	
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosCiudadano(@Validated @ModelAttribute("curriculum") Curriculum curriculum, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+ curriculum);
			ModelAndView mav = new ModelAndView("edicion_curriculum");
			mav.addObject("curriculum", curriculum);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/ciudadano/home");
		curriculumService.modificarCurriculum(curriculum);
		LOGGER.info("Se modificó curriculum");
		return mav;
	} 
	
	@GetMapping("/edicion/{curriculum_id}")
	public ModelAndView getEditarCiudadanoPage(@PathVariable(value="curriculum_id")long curriculum_id) {
		ModelAndView mav = new ModelAndView("edicion_curriculum");
		Curriculum curri = curriculumService.buscarCurriculum(curriculum_id);
		
		//Si el curriculum tiene cargado la educacion e idioma, entonces 
		//lo ponemos en existe y podra buscar ofertas laborales
		if ((curri.getEducacion()!=null)&&(curri.getIdiomas()!=null)) {
			curri.setExisteCurriculum(true);
		}
		
		List<ExperienciaLaboral> list_explab;
		//Si tiene exp laboral, mantenemos la misma y la pasamos al mav
		//Si no tiene le creamos una para que pueda llenarla
		if (curri.getExpLaboral()==null) {
			list_explab = explabService.getListaExperienciaLaboral();
			curri.setExpLaboral(list_explab);
		}else {
			list_explab = curri.getExpLaboral();
		}
		
		List<Idioma> list_idioma;
		//Si tiene lista de idiomas, mantenemos la misma y la pasamos al mav
		//Si no tiene le creamos una para que pueda llenarla
		if (curri.getIdiomas()==null) {
			list_idioma = idiomaService.getListaIdioma();
			curri.setIdiomas(list_idioma);
		}else {
			list_idioma = curri.getIdiomas();
		}
		
		LOGGER.info(curri);
		
		if(curriculumService.guardarCurriculum(curri)) {
			LOGGER.info("CURRICULUM SAVE");
		}
		mav.addObject("educacion", educacionService.getListaEducacion());
		mav.addObject("curriculum",curri);
		mav.addObject("explab",list_explab);
		mav.addObject("idioma",list_idioma);
			
		return mav;
	}
	
	
	@GetMapping("/editarExpLab/{curriculum_id}")
	public String getEditarExpLabListPage(@PathVariable(value="curriculum_id")long curriculum_id,Model model) {
		Curriculum cv = curriculumService.buscarCurriculum(curriculum_id);
		model.addAttribute("explab", cv.getExpLaboral());
		model.addAttribute("cv", curriculumService.buscarCurriculum(curriculum_id));
		return "edicion_explab";
	}
	
	@GetMapping("/editarIdiomaList/{curriculum_id}")
	public String getEditarIdiomaListPage(@PathVariable(value="curriculum_id")long curriculum_id,Model model) {
		Curriculum cv = curriculumService.buscarCurriculum(curriculum_id);
		model.addAttribute("idiomas", cv.getIdiomas());
		model.addAttribute("cv", curriculumService.buscarCurriculum(curriculum_id));
		model.addAttribute("idioma", idiomaService.getListaIdioma());
		return "lista_seleccionar";
	}

}
