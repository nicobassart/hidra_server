package hidra.com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUsuario;

	@NotNull
	@Column(unique = true)
	private String usuario;

	@OneToMany()
	@JoinTable(name = "usuario_perfil", joinColumns = @JoinColumn(name = "idUsuario"), inverseJoinColumns = @JoinColumn(name = "idPerfil"))
	private Collection<Perfil> perfiles;

	@OneToMany()
	@JoinTable(name = "usuario_componente", joinColumns = @JoinColumn(name = "idUsuario"), inverseJoinColumns = @JoinColumn(name = "idComponente"))
	private Collection<Componente> componentes;

	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL)
	private Collection<Password> passwords;

	
	public String getUltimoPassword(){
		return "valor";
	}
	public Usuario() {
		super();
		passwords =	 new ArrayList<Password>();
	}

	public Collection<Password> getPasswords() {
		return passwords;
	}

	public void setPasswords(Collection<Password> passwords) {
		this.passwords = passwords;
	}

	public Usuario(final long id) {
		this.idUsuario = id;
	}

	public Usuario(String user) {
		this.usuario = user;
	}

	public Usuario(String user, String password) {
		// TODO Auto-generated constructor stub
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Collection<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(Collection<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	public Collection<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(Collection<Componente> componentes) {
		this.componentes = componentes;
	}

}