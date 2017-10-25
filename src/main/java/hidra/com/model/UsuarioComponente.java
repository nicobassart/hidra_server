package hidra.com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario_componente")
public class UsuarioComponente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUsuarioComponente;
	
	@NotNull
	private long idUsuario;
	@NotNull
	private long idComponente;
	public long getIdUsuarioComponente() {
		return idUsuarioComponente;
	}
	public void setIdUsuarioComponente(long idUsuarioComponente) {
		this.idUsuarioComponente = idUsuarioComponente;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public long getIdComponente() {
		return idComponente;
	}
	public void setIdComponente(long idComponente) {
		this.idComponente = idComponente;
	}
	  
} 