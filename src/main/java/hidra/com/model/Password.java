package hidra.com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "password")
public class Password implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPassword;
	
	@NotNull
	private String password;
	
	@NotNull
	private Date fechaAlta;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = true) 
	private Usuario usuario;


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public long getIdPassword() {
		return idPassword;
	}

	public void setIdPassword(long idPassword) {
		this.idPassword = idPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date date) {
		this.fechaAlta = date;
	}
	

}