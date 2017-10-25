package hidra.com.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import hidra.com.model.Usuario;

@Transactional
public interface UsuarioDao extends CrudRepository<Usuario, Long> {

	public Usuario findByUsuario(String user);
	public Usuario findByIdUsuario(long idUser);

}