package pe.spring.demo.services;

import org.springframework.stereotype.Service;

import pe.spring.demo.entities.Product;

public interface IProductService extends ICRUD<Product> {

	void increasePrice(int percentage);
}
