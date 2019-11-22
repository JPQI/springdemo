package pe.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.spring.demo.services.IEmpleadoService;

@Controller
public class PlanillaController {
	
	@Autowired
	private IEmpleadoService empleadoService;
    
	@GetMapping({"/", "/planilla"})
    public String getView(Model model) {
        model.addAttribute("empleados", empleadoService.listar());
        //model.addAttribute("empl", new Empleado());
        
        return "planilla";
    }
	
	@GetMapping({"/delete"})
    public String delete(@RequestParam(value = "id", required = true) Integer id, Model model) {
        
		empleadoService.eliminar(id);
		model.addAttribute("empleados", empleadoService.listar());
		
		return "redirect:/planilla";
    }
}
