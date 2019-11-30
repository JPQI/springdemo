package pe.spring.demo.services;

import java.util.List;

import pe.spring.demo.entities.Empleado;

public interface IEmpleadoCustomService {

	List<Empleado> getEmpleadoByNombreAndDepartamento(String nombre, String departamento);
}
