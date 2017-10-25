package hidra.com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "componente")
public class Componente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idComponente;
	@NotNull
	@Column(unique=true)
	private String componente;

	
	public long getIdComponente() {
		return idComponente;
	}

	public void setIdComponente(long idComponente) {
		this.idComponente = idComponente;
	}

	public String getComponente() {
		return componente;
	}
	public void setComponente(String componente) {
		this.componente = componente;
	}
	  

} 