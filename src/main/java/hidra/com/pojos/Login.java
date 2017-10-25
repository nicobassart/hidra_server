package hidra.com.pojos;

public class Login {
    private String user;
    private String password;
    private	String estado;
    private	long idUsuario;
    private	String resultado;


    public Login() {

    }
    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

    public void setUser(String user) {
        this.user= user;
    }

    public void setPassword(String password) {
        this.password= password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	
	
}
