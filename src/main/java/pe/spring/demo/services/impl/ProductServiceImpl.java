package pe.spring.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pe.spring.demo.entities.Product;
import pe.spring.demo.repo.IProductRepo;
import pe.spring.demo.services.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IProductRepo repo;

	@Override
	public Product registrar(Product obj) {
		return repo.save(obj);
	}

	@Override
	public Product modificar(Product obj) {
		return repo.save(obj);
	}

	@Override
	public Product listarPorId(Integer id) {
		Optional<Product> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Product();
	}

	@Override
	public List<Product> listar() {
		return (List<Product>) repo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public void increasePrice(int percentage) {
        List<Product> products = this.listar();
        if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice().doubleValue() * 
                                    (100 + percentage)/100;
                product.setPrice(newPrice);
                repo.save(product);
            }
        }
	}

}
