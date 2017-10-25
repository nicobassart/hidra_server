package hidra.com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario_perfil")
public class UsuarioPerfil implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUsuarioPerfil;
	  
	@NotNull
	private long idUsuario;
	@NotNull
	private long idPerfil;
	
	
	public long getIdUsuarioPerfil() {
		return idUsuarioPerfil;
	}
	public void setIdUsuarioPerfil(long idUsuarioPerfil) {
		this.idUsuarioPerfil = idUsuarioPerfil;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public long getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(long idPerfil) {
		this.idPerfil = idPerfil;
	}


} 