package trogol;


public class Usuario extends Principal{
	private String usuario;
	private String password;

	Usuario(String usuario, String password)
	{
		this.usuario=usuario;
		this.password=password;
	}
	public String CualesmiUsuario() {
		return usuario;
	}
	public String CualesmiContraseña() {
		return password;
	}
}
