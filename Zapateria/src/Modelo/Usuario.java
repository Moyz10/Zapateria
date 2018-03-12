package Modelo;

public class Usuario {
	//Declaramos atributos de usuario.
	private String nombre;
	private String pass;
	private String tipo;
	
	//Constructor que hace referencia al constructor debajo
	public Usuario() {
		this("","","");
	}
	
	public Usuario(String nombre, String pass, String tipo) {
		this.nombre = nombre;
		this.pass = pass;
		this.tipo=tipo;
	}
	
	//Implementamos estos métodos para consultarlos en el DAOLogin.

	public String getNombre() {
		return nombre;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	//Implementamos estos métodos para crear el objeto de tipo usuario a validar.

	public void setTipo(String tipo) {
		this.tipo=tipo;
		
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", pass=" + pass + ", tipo=" + tipo + "]";
	}

	
	
	

}
