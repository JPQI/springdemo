package pe.spring.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import pe.spring.demo.entities.Empleado;
import pe.spring.demo.entities.TablaMaestra;
import pe.spring.demo.services.IEmpleadoService;
import pe.spring.demo.services.ITablaMaestraService;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/appconfig-root.xml"})
@WebAppConfiguration
public class EmpleadoControllerTest {
	
	@InjectMocks
	EmpleadoController empleadoController;
	
	@Mock
	private IEmpleadoService service;
	
	@Mock
	private ITablaMaestraService tablaService;
	
	@Mock
	private BindingResult binding;
	
	@Mock
	private Model model;
	
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void postEmpleado_ValidEmpleado() throws Exception {
		
		when(binding.hasErrors()).thenReturn(true);
		
	    String view = empleadoController.processForm(new Empleado(), binding, model);
	    assertEquals("empleado", view);
	}
	
	@Test
	public void postEmpleado_NotValidEmpleado() throws Exception {
		
		when(binding.hasErrors()).thenReturn(false);
		when(tablaService.listar()).thenReturn(new ArrayList<TablaMaestra>());
		
	    String view = empleadoController.processForm(new Empleado(), binding, model);
	    assertEquals("redirect:/planilla", view);
	}
}
