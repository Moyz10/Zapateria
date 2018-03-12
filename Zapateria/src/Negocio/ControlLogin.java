package Negocio;

import javax.swing.JOptionPane;

import Modelo.Usuario;
import Presentacion.VistaLogin;
import Presentacion.VistaVendedor;

public class ControlLogin {
	//declaramos los atributos de nuestro control.
	private VistaVendedor vv;
	private ServicioLogin servlog;
	private VistaLogin l;
	private Usuario usuario=new Usuario();

	//Agregamos una instancia de las vistas a nuesto control
	public void setVistaVendedor(VistaVendedor vv) {
		this.vv=vv;
		
	}
	//Hacemos la ventana visible
	public void muestravistavendedor() {
		vv.setVisible(true);
		
	}
	
	//Instanciamos la vista login.
	public void setVistaLogin(VistaLogin l) {
		this.l=l;
	}
	
	//Este metodo nos permite saber si el usuario ingresado existe en nuestra base de datos, pasandolo al servicio Login.
	public void validaingreso() {
		if(servlog.validaingreso(usuario)==true) {
			JOptionPane.showMessageDialog(null, "Ingresaste como: Vendedor, bienvenido");
			muestravistavendedor();
			l.dispose();
		}else {
			JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecta, ¿Seleccionó correctamente el campo cargo?");
		}
		
	}
	//Agregamos instancia de servicio login.
	public void setServicioLogin(ServicioLogin servlog) {
		this.servlog=servlog;
		
	}
	
	//Validamos que hay algo escrito en el textfield de usuario para consultarlo al DAO
	public void recibeUsuario(String texto) {
		if(texto.length()>1) {
			
			usuario.setNombre(texto);
			
		}
	
	}
	
	//Validamos que tipo de usuario trata de ingresar al sistema
	public void recibeTipo(String tipo) {
		usuario.setTipo(tipo);
	}
	
	//Validamos que hay algo escrito en el textfield de contraseña para la consulta.
	public void recibeContraseña(String texto) {
		if(texto.length()>1) {
			
			usuario.setPass(texto);
		}
	}
	

}
