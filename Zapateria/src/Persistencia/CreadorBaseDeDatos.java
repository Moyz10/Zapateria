package Persistencia;


import java.sql.Connection;
import java.sql.Statement;

public class CreadorBaseDeDatos {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		try
		{
			Connection connection = ManejadorBD.dameConnection();

			Statement statement = connection.createStatement();
			//statement.execute("CREATE TABLE Loginpersonal(nombre varchar(40), contraseña varchar(40), tipo varchar(40))");
		    //statement.execute("INSERT INTO Loginpersonal VALUES ('Edgar','Feikel10','Vendedor')");
			//statement.execute("CREATE TABLE Producto(ID integer, modelo varchar(40), tipo varchar(40), color varchar(40), costo double, talla double)");
			//statement.execute("INSERT INTO Producto VALUES(1,'Nike airmax', 'Calzado deportivo', 'Blanco', 789.60,27.5)");
		    //statement.execute("DROP TABLE Tickets");
			statement.execute("CREATE TABLE Tickets(folio integer, fecha Date, modelo varchar (40), color varchar(40), talla varchar(40), cantidad varchar(40), preciounitario varchar(40), iva varchar(40), totalapagar varchar(40))");
			System.out.println("datos agregados");

			ManejadorBD.termina();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}




	}

}
