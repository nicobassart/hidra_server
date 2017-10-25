package hidra.com.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import hidra.com.model.Componente;

@Transactional
public interface ComponenteDao extends CrudRepository<Componente, Long> {

	//public Usuario findBy(String user);

	//public List<Componente> findByUser(Usuario unUser);

}