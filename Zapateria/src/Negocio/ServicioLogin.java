package Negocio;

import javax.swing.JOptionPane;

import Modelo.Usuario;
import Persistencia.DAOLogin;

public class ServicioLogin {
	//Declaramos atributos de nuestro servicio
	private ControlLogin control;
	DAOLogin dao = new DAOLogin();

	//Agregamos una instancia de control al servicio.
	public void setControl(ControlLogin controllog) {
		this.control=controllog;
		
	}
	//Este método realiza la consulta al DAO, y lo retorna como falso o verdadero. si es falso el login falla

	public boolean validaingreso(Usuario usuario) {
		if(dao.valida(usuario)) {
			return true;
			
		}else {
			
			return false;
		}
	
		
	}

}
