package Persistencia;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Modelo.Usuario;

public class DAOLogin {
	//Este método se encarga de validar si existe un usuario especifico en al base de datos.

	public boolean valida(Usuario usuario) {
		System.out.println(usuario.getNombre()+", "+usuario.getPass()+", "+usuario.getTipo()+", Usuario a buscar en DAO LOGIN");
		String sql = "SELECT * FROM Loginpersonal WHERE tipo='"+usuario.getTipo()+"'AND nombre ='"+usuario.getNombre()+"' AND contraseña = '"+usuario.getPass()+"'   ";
		try {
			//crea el statement
			Statement st =ManejadorBD.dameConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rs.next();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Surgio un error verifique sus datos");
			
		}
		return false;
		
		
	}

}
