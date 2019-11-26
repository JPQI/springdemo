package pe.spring.demo.cross;

import static org.hamcrest.CoreMatchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
/*import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;*/
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pe.spring.demo.entities.Empleado;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/appconfig-root.xml"})
@WebAppConfiguration
@Transactional
@Rollback
public class EmpleadoControllerCross {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception {
		
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
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
		
	    this.mockMvc.perform(get("/empleado").param("id", "1")).andDo(print())
	      .andExpect(view().name("empleado"));
	}
	
	@Test
	public void procesarEmpleadoVista_Ok() throws Exception {
		
		Empleado empl = new Empleado();
		empl.setNombre("nombre no nulo");
		
	    this.mockMvc.perform(post("/empleado").flashAttr("empl", empl))
	      .andDo(print())
	      .andExpect(view().name("redirect:/planilla"))
	      .andExpect(model().attribute("empleados", not(IsEmptyCollection.empty())));
	      ;
	}
	
	@Test
	public void procesarEmpleadoVista_NotOk() throws Exception {
		
	    this.mockMvc.perform(post("/empleado").param("nombre", ""))
	      .andDo(print())
	      .andExpect(
	    		  model().attributeHasFieldErrors("empl", "nombre")
          )
	      .andExpect(view().name("empleado"))
	      ;
	}
	
	@Test
	public void obtenerEmpleadoVista_NotFound() throws Exception {
		
	    this.mockMvc.perform(get("/empleadoo")).andExpect(status().isNotFound());
	}

}
