package trogol;

/**
 *Esta clase almacena los datos de usuario y contrase�a para ser comprobados en la clase Principal 
 *
 */
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
	public String CualesmiContrase�a() {
		return password;
	}
}
