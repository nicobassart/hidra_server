package hidra.com.controllers;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import hidra.com.model.Prueba;

@RepositoryRestResource(collectionResourceRel = "prueba", path = "prueba")
public interface PruebaRepository  extends PagingAndSortingRepository<Prueba, Long> {
	
	List<Prueba> findByField1(@Param("name") String name);
}
