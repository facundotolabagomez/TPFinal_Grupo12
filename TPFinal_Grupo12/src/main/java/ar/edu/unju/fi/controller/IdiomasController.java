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
import ar.edu.unju.fi.entity.Curriculum;
import ar.edu.unju.fi.entity.Idioma;
import ar.edu.unju.fi.service.ICurriculumService;
import ar.edu.unju.fi.service.IIdiomaService;


@Controller
@RequestMapping("/idioma")
public class IdiomasController {
	
	@Autowired
	@Qualifier("IdiomaServiceImpSql")
	private IIdiomaService idiomaService;
	
	@Autowired
	@Qualifier("CurriculumServiceImpSql")
	private ICurriculumService cvService;

	private static final Log LOGGER = LogFactory.getLog(IdiomasController.class);
	
	@GetMapping("/nuevo_idioma")
	public String getFormIdiomaPage(Model model) {
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
			LOGGER.info("Se guardó nuevo idioma");
		}
		mavidioma.addObject("idioma", idiomaService.getListaIdioma());
		return mavidioma; 
	} 
	
	@GetMapping("/lista_idio")
	public String getListaIdiomasPage(Model model) {
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
		LOGGER.info("Se modificó el idioma");
		mav.addObject("idioma", idiomaService.getListaIdioma());		
		return mav;
	} 
	
	@GetMapping("/eliminar/{idioma_id}")
	public ModelAndView getEliminarIdiomaPage(@PathVariable(value = "idioma_id") long idioma_id) {
		ModelAndView mavIdioma = new ModelAndView("redirect:/idioma/lista_idio");
		idiomaService.eliminarIdioma(idioma_id);
		LOGGER.info("Se eliminó el idioma");
		return mavIdioma;
	}
	
	
	// De aqui para arriba es del admin
	// Para abajo es del cv - ciudadano
	
	
	@GetMapping("/nuevolist/{cv}")
	public String getFormIdiomaListPage(@PathVariable(value = "cv") long cv, Model model) {
		model.addAttribute("idioma", idiomaService.getListaIdioma());
		model.addAttribute("idiomalistacv", idiomaService.getIdioma());
		model.addAttribute("cv", cvService.buscarCurriculum(cv));
		return "nuevoidiomacv";		
	}
	
	
	@PostMapping("/guardarlist/{curriculum_id}")
	public ModelAndView getIDiomaListLabPage(@PathVariable(value = "curriculum_id") long curriculum_id,@ModelAttribute("idioma")Idioma idioma) {
		ModelAndView mavidi = new ModelAndView("redirect:/cv/editarIdiomaList/"+curriculum_id);
		Curriculum cv = cvService.buscarCurriculum(curriculum_id);
		Idioma idi = idiomaService.buscarIdiomaPorId(idioma.getIdioma_id());
		cv.getIdiomas().add(idi);
		
		if (cvService.guardarCurriculum(cv)) {
			LOGGER.info("Se guardo nuevo idioma en lista");
		}
		mavidi.addObject("idiomas", cv.getIdiomas());
		return mavidi; 
	} 
	
	@GetMapping("/eliminarlist/{idioma_id}/{curriculum_id}")
	public ModelAndView getEliminarListaIdiomaPage(@PathVariable(value = "idioma_id")long idioma_id,@PathVariable(value = "curriculum_id")long curriculum_id) {
		LOGGER.info(idioma_id);
		LOGGER.info(curriculum_id);
		ModelAndView mavidi = new ModelAndView("redirect:/cv/editarIdiomaList/"+curriculum_id);
		Curriculum cv = cvService.buscarCurriculum(curriculum_id);
				
		for(int i=0;i<cv.getIdiomas().size();i++) {
			if(cv.getIdiomas().get(i).getIdioma_id()==idioma_id) {
				cv.getIdiomas().remove(i);
			}
		}
		
		if (cvService.guardarCurriculum(cv)) {
			LOGGER.info("Se guardo eliminacion en idioma en cv");
		}
		
		return mavidi;
	}
	/*
	@PostMapping("/guardarListaIdiomaEnCv/{curriculum_id}")
	public ModelAndView getIdiomaEnCvPage(@PathVariable(value = "curriculum_id") long curriculum_id,@ModelAttribute("idioma")Idioma idioma) {
		ModelAndView mavidi = new ModelAndView("redirect:/cv/edicion/"+curriculum_id);
		Curriculum cv = cvService.buscarCurriculum(curriculum_id);
		//Idioma idi = idiomaService.buscarIdiomaPorId(idioma.getIdioma_id());
		
		cv.getIdiomas().addAll(idiomas);
		
		if (cvService.guardarCurriculum(cv)) {
			LOGGER.info("Se guardo nuevo idioma en lista");
		}
		mavidi.addObject("idiomas", cv.getIdiomas());
		return mavidi; 
	} */
//	/cv/guardarListaIdiomaEnCv/{curriculum_id}(curriculum_id=${curriculum_id})
//	/cv/edicion/{curriculum_id}(curriculum_id=${curriculum_id})
	
	//lo de abajo es un intento fallido
	/*  @PostMapping("/guarda/{curriculum_id}")
	public ModelAndView getExpLabPage(@PathVariable(value = "curriculum_id") long curriculum_id,@ModelAttribute("idioma")List<Idioma> idioma) {
		ModelAndView mavIdioma = new ModelAndView("redirect:/cv/edicion/"+curriculum_id);
		Curriculum cv = cvService.buscarCurriculum(curriculum_id);
		//List<Idioma> lista_idioma;
		
		LOGGER.info("cv---------"+cv);
		LOGGER.info("idiomas--------"+idiomas);
		for(int i=0;i<idiomas.size();i++) {
			LOGGER.info(idiomas.size());
			Idioma idi = idiomaService.buscarIdioma(idiomas.get(i).getNombreIdioma());
			LOGGER.info("get i get nombre idioma-----"+idiomas.get(i).getNombreIdioma());
			cv.addIdioma(idi);
		}
		
		if(cvService.guardarCurriculum(cv)) {
			LOGGER.info("Lista idioma guardada correctamente");
		}
		
		//@RequestParam(value = "param") List<String> param
		//@ModelAttribute("idioma")List<Idioma> idioma
		//@RequestParam(value = "idiomas") List<Idioma> idiomas
		
		//mavIdioma.addObject("idioma", lista_idioma);
		return mavIdioma; 
	}*/
}
	


