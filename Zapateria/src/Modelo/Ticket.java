package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
	//declaramos atributos de ticket
	static int folio=0;
	Date fecha = new Date();
	String modelo,color,talla,cantidad,preciounitario,iva,total;
	
	
	//Constructor para asignar valores al ticket.
public Ticket(int folio,Date fecha, String modelo, String color, String talla, String cantidad, String preciounitario,
			String iva, String total) {
		super();
		Ticket.folio=folio;
		this.fecha = fecha;
		this.modelo = modelo;
		this.color = color;
		this.talla = talla;
		this.cantidad = cantidad;
		this.preciounitario = preciounitario;
		this.iva = iva;
		this.total = total;
	}


//Este método nos permite obtener la fecha, para pasarla al ticket impreso.
public static String getFechaActual() {
	        Date ahora = new Date();
	        DateFormat formatoHora = new SimpleDateFormat("HH:mm");
	        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
			return formateador.format(ahora)+", "+formatoHora.format(ahora);
	    }

//De manera simpre, asignamos un folio consecutivo a cada ticket
public static int setFolio() {
	folio=folio+1;
	return folio;
}


}
