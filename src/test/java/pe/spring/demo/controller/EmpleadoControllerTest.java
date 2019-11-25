package pe.spring.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pe.spring.demo.entities.Empleado;
import pe.spring.demo.services.IEmpleadoService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/appconfig-root.xml"})
@WebAppConfiguration
public class EmpleadoControllerTest {

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@InjectMocks
	EmpleadoController empleadoController;
	
	@Mock
	private IEmpleadoService service;
	
	@Mock
	private BindingResult binding;
	
	@Mock
	private Model model;
	
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	    //this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".html");
        
		mockMvc = MockMvcBuilders
                .standaloneSetup(empleadoController)
                .setViewResolvers(viewResolver)
                .build();
	}
	
	@Test
	public void givenWac_whenServletContext_thenItProvidesGreetController() {
	    ServletContext servletContext = wac.getServletContext();
	     
	    Assert.assertNotNull(servletContext);
	    Assert.assertTrue(servletContext instanceof MockServletContext);
	    Assert.assertNotNull(wac.getBean("empleadoController"));
	}
	
	@Test
	public void obtenerEmpleadoVista() throws Exception {
		
		//when(service.listarPorId(null)).thenReturn(new Empleado());
		
	    this.mockMvc.perform(get("/empleado")).andDo(print())
	      .andExpect(view().name("empleado"));
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
		
	    String view = empleadoController.processForm(new Empleado(), binding, model);
	    assertEquals("redirect:/planilla", view);
	}
}
