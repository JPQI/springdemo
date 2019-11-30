package pe.spring.demo.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import pe.spring.demo.entities.Empleado;
import pe.spring.demo.services.IEmpleadoCustomService;

@Service
public class EmpleadoCustomServiceImpl implements IEmpleadoCustomService{

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public List<Empleado> getEmpleadoByNombreAndDepartamento(String nombre, String departamento) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Empleado> cq = cb.createQuery(Empleado.class);

		Root<Empleado> empl = cq.from(Empleado.class);
        Predicate nombrePredicate = cb.equal(empl.get("nombre"), nombre);
        Predicate departPredicate = cb.like(empl.get("departamento"), "%" + departamento + "%");
        
        Predicate mayorQuePredicate = cb.greaterThan(empl.get("id"), 1);
        cq.where(nombrePredicate, departPredicate, mayorQuePredicate);
        cq.orderBy(cb.asc(empl.get("nombre")));
 
        TypedQuery<Empleado> query = em.createQuery(cq);

		
        return query.getResultList();
        
	}

}
