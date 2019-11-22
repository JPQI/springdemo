package pe.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	
	@GetMapping({"/inicio"})
    public String getView() {
        
        return "login";
    }
	
	@GetMapping({"/inicio-error"})
    public String getErrorView(Model model) {
		model.addAttribute("loginError", true);
        return "login";
    }
	
}
