package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empleos")
public class IndexController {		
		@GetMapping("/inicio")
		public String getIndexPage(Model model) {
			return "index"; 
		}
		
		@GetMapping("/home")
		public String getHomePage(Model model) {
			return "home"; 
		}

		@GetMapping("/admin")
		public String getAdminPage(Model model) {
			return "admin-acces"; 
		}
	}

