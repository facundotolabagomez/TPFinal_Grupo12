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
import ar.edu.unju.fi.entity.Curriculum;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.ICurriculumService;
import ar.edu.unju.fi.service.IEducacionService;


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
	@Qualifier("CiudadanoServiceImpSql")
	private ICiudadanoService ciudadanoService;
		
	private static final Log LOGGER = LogFactory.getLog(CurriculumController.class);
	
	//carga el form de editar cv
		@GetMapping("/edicion/{curriculum_id}/{email}")
		public ModelAndView getEditarCiudadanoPage(@PathVariable(value = "curriculum_id")long curriculum_id,@PathVariable(value = "email")String email) {
			ModelAndView mav = new ModelAndView("edicion_curriculum");
			Curriculum curri = curriculumService.buscarCurriculum(curriculum_id);
			Ciudadano ciud = ciudadanoService.buscarCiudadanoPorEmail(email);
			
			//Si el curriculum tiene cargado la educacion e idioma, entonces 
			//lo ponemos en existe y podra buscar ofertas laborales
			if ((curri.getEducacion()!=null)&&(curri.getIdioma()!=null)) {
				curri.setExisteCurriculum(true);
			}
			
			LOGGER.info(curri);
			
			if(curriculumService.guardarCurriculum(curri)) {
				LOGGER.info("CURRICULUM SAVE");
			}
			mav.addObject("educacion", educacionService.getListaEducacion());
			mav.addObject("curriculum",curri);
			mav.addObject("ciudadano",ciud);
				
			return mav;
		}
	
	//captura lo que envia el formulario de editar cv
	@PostMapping("/guardar/{curriculum_id}/{email}")
	public ModelAndView getDatosCurriculumPage(@Validated @ModelAttribute("curriculum")Curriculum curriculum,@PathVariable(value = "curriculum_id")long curriculum_id,@PathVariable(value = "email")String email, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_curriculum");
			mav.addObject("curriculum", curriculum);
			return mav;
		}
		ModelAndView mavcurriculum = new ModelAndView("redirect:/ciudadano/home");
		Ciudadano ciud = ciudadanoService.buscarCiudadanoPorEmail(email);
		Curriculum curri = curriculumService.buscarCurriculum(curriculum_id);
		
		if ((curriculum.getEducacion()!=null)&&(curriculum.getIdioma()!=null)) {
			curri.setExisteCurriculum(true);
		}
		
		curri.setConocInfor(curriculum.getConocInfor());
		curri.setEducacion(curriculum.getEducacion());
		curri.setExpLab(curriculum.getExpLab());
		curri.setIdioma(curriculum.getIdioma());
		curri.setInfoComplem(curriculum.getInfoComplem());
		curri.setCiudadano(ciud);
		
		LOGGER.info(curri);
		
		if(curriculumService.guardarCurriculum(curri)) {
			LOGGER.info("CURRICULUM UPDATE");
		}
		
		mavcurriculum.addObject("curriculum", curri);
		return mavcurriculum;
	}
	
	@GetMapping("/verCv/{curriculum_id}")
	public String getListaCursosPage(@PathVariable(value = "curriculum_id")long curriculum_id,Model model) {
		Curriculum cv = curriculumService.buscarCurriculum(curriculum_id);
		model.addAttribute("curriculum", cv);
		return "mostrar_curriculum";
	}
	
		
	
	
}
