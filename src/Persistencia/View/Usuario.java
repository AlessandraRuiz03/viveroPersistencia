package Persistencia.View;

public class Usuario {
	int id;
	String correo;
	String password;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Usuario() {
		
	}
	
	public Usuario(String correo, String password) {
		this.correo=correo;
		this.password = password;
	}
	

}
