package pe.spring.demo.repo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import pe.spring.demo.entities.Empleado;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/appconfig-root.xml"})
@WebAppConfiguration
@Transactional
@Rollback
public class IEmpleadoRepoTest {
	
	@Autowired
	private IEmpleadoRepo empleadoRepo;
	
	@Test
    public void testFindAll() {
        List<Empleado> empleados = empleadoRepo.findAll();
        //assertThat(empleados.size(), equalTo("[Africa, Antarctica, Asia, Europe, North America, Oceania, South America]"));
        assertTrue(empleados.size() > 0);
    }
	
	@Test
	public void save() {
		Empleado entity = new Empleado();
		entity.setNombre("nombre");
		entity.setDepartamento("Ventas");
		entity.setTelefono("5498797");
		
		empleadoRepo.save(entity);
		
		assertNotNull( empleadoRepo.findById(entity.getId()) );
	}

}
