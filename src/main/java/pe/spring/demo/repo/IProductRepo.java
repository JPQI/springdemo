package pe.spring.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.spring.demo.entities.Product;

public interface IProductRepo extends JpaRepository<Product, Integer> {

}
