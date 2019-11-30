package pe.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.spring.demo.entities.Empleado;
import pe.spring.demo.services.IEmpleadoCustomService;

@Controller
public class ConsultaController {
	
	@Autowired
	private IEmpleadoCustomService empleadoCustomService; 

	@GetMapping({"/consulta"})
    public String getView(Model model) {
		
		model.addAttribute("empl", new Empleado());
		
		return "consulta";
	}
	
	@RequestMapping(value = "/consulta", method=RequestMethod.POST)
	public String processForm(@ModelAttribute(value="empl") Empleado empleado, Model model) {
		
	  model.addAttribute("empleados", empleadoCustomService
			  								.getEmpleadoByNombreAndDepartamento(empleado.getNombre(), 
			  																	empleado.getDepartamento()));
		
	  return "consulta";
	}
}
