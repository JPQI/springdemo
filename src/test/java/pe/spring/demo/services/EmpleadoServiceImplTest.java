package pe.spring.demo.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import pe.spring.demo.entities.Empleado;
import pe.spring.demo.repo.IEmpleadoRepo;
import pe.spring.demo.services.impl.EmpleadoServiceImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/appconfig-root.xml"})
@WebAppConfiguration
public class EmpleadoServiceImplTest {

	@InjectMocks
	private EmpleadoServiceImpl empleadoServiceImpl;
	
	@Mock
	private IEmpleadoRepo repo;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
    public void listarPorId_GetId() {
		Empleado empleadoMock = new Empleado();
		empleadoMock.setId(1);
		
		Optional<Empleado> op = Optional.of(empleadoMock);
		
		when(repo.findById(1)).thenReturn(op);

		Empleado result = empleadoServiceImpl.listarPorId(1);
        assertEquals(result.getId(), empleadoMock.getId());
    }
	
	@Test
    public void listarPorId_GetEmptyObject() {
		Empleado empleadoMock = new Empleado();
		
		Optional<Empleado> op = Optional.of(empleadoMock);
		
		when(repo.findById(any())).thenReturn(op);

		Empleado result = empleadoServiceImpl.listarPorId(20);
		assertNotNull(result);
    }
}
