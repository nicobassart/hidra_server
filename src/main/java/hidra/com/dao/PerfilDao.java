package hidra.com.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import hidra.com.model.Perfil;

@Transactional
public interface PerfilDao extends CrudRepository<Perfil, Long> {

	public Perfil findByIdPerfil(long owner);

}