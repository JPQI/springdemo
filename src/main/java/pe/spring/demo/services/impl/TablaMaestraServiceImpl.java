package pe.spring.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.spring.demo.entities.TablaMaestra;
import pe.spring.demo.repo.ITablaMaestraRepo;
import pe.spring.demo.services.ITablaMaestraService;

@Service
public class TablaMaestraServiceImpl implements ITablaMaestraService {
	
	@Autowired
	private ITablaMaestraRepo repo;

	@Override
	public TablaMaestra registrar(TablaMaestra obj) {
		return repo.save(obj);
	}

	@Override
	public TablaMaestra modificar(TablaMaestra obj) {
		return repo.save(obj);
	}

	@Override
	public TablaMaestra listarPorId(Integer id) {
		Optional<TablaMaestra> op = repo.findById(id);
		return op.isPresent() ? op.get() : new TablaMaestra();
	}

	@Override
	public List<TablaMaestra> listar() {
		return (List<TablaMaestra>) repo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

}
