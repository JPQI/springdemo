package pe.spring.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.spring.demo.entities.Empleado;
import pe.spring.demo.services.IEmpleadoService;

@Controller
public class EmpleadoController {
	
	@Autowired
	private IEmpleadoService empleadoService;
    
	@GetMapping({"/empleado"})
    public String getView(@RequestParam(value = "id", required = false) Integer id,
    					  Model model) {
        //model.addAttribute("empleados", empleadoService.listar());
        model.addAttribute("empl", empleadoService.listarPorId(id));
        //return "planilla";
        return "empleado";
    }
	
	@RequestMapping(value = "/empleado", method=RequestMethod.POST)
	public String processForm(@ModelAttribute(value="empl") @Valid Empleado empleado, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
            model.addAttribute("empl", empleado);
            return "empleado";
        }
		
		empleadoService.registrar(empleado);
		
		model.addAttribute("empleados", empleadoService.listar());
		
	  return "redirect:/planilla";
	}
}
