package Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Modelo.Ticket;

public class DAOTicket {
	//Permite realizar una búsqueda de ticket especifico en la base de datos.
	public Ticket buscaTicket(int folio) {

		Ticket ticket = null;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Recibe los resutados
		ResultSet rs = statement.executeQuery("SELECT * FROM Tickets WHERE folio='"+folio+"'");

			if(rs.next())
			{
				// Crea una nueva instancia del objeto
				ticket = new Ticket(rs.getInt("folio"),rs.getDate("fecha"), rs.getString("modelo"), rs.getString("color"), rs.getString("talla"), rs.getString("cantidad"), rs.getString("preciounitario"),rs.getString("iva"),rs.getString("totalapagar"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticket;

	}
}
