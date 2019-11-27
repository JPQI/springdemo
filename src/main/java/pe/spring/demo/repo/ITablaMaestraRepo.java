package pe.spring.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.spring.demo.entities.TablaMaestra;

public interface ITablaMaestraRepo extends JpaRepository<TablaMaestra, Integer> {

}
