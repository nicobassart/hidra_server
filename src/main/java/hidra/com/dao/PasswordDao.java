package hidra.com.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import hidra.com.model.Password;

@Transactional
public interface PasswordDao extends CrudRepository<Password, Long> {

	//public Perfil findByIdPerfil(long owner);

}