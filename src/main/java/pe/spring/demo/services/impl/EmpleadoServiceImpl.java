package pe.spring.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.spring.demo.entities.Empleado;
import pe.spring.demo.repo.IEmpleadoRepo;
import pe.spring.demo.services.IEmpleadoService;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
	
	@Autowired
	private IEmpleadoRepo repo;

	@Override
	public Empleado registrar(Empleado obj) {
		return repo.save(obj);
	}

	@Override
	public Empleado modificar(Empleado obj) {
		return repo.save(obj);
	}

	@Override
	public Empleado listarPorId(Integer id) {
		Optional<Empleado> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Empleado();
	}

	@Override
	public List<Empleado> listar() {
		return (List<Empleado>) repo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

}
