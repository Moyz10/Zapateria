package Negocio;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modelo.Producto;
import Modelo.Ticket;
import Presentacion.VistaCambiocalzado;
import Presentacion.VistaTicket;
import Presentacion.VistaVentacalzado;

public class Controlventa implements Printable {
	//Instanciamos nuestros atributos
	private VistaCambiocalzado vc;
	private VistaVentacalzado vvc;
	private VistaTicket vticket;
	private Servicioventa servent;

	//Agregamos las vistas y servicios.
	public void setVistaCambiocalzado(VistaCambiocalzado vc) {
		this.vc=vc;
		
	}
	
	public void setVistaVentacalzado(VistaVentacalzado vvc) {
		this.vvc=vvc;
		
	}

	public void setServicioventa(Servicioventa servent) {
		this.servent=servent;
		
	}
	//mostramos ventanas
	public void muestraventadecalzado() {
		vvc.setVisible(true);
		
	}

	public void muestracambiocalzado() {
		vc.setVisible(true);
		
	}
	//Agregamos vista ticket

		public void setVistaticket(VistaTicket vticket) {
			this.vticket=vticket;
			
		}

	
	//Este método nos permite agregar los datos que nos regresa el DAO a la tabla de consulta.

	public void buscaProducto(int id) {
		Object[] fila = new Object[vvc.modelo.getColumnCount()];
		ArrayList<Producto>productos= new ArrayList<Producto>();
		Producto p = servent.buscaProducto(id);
		productos.add(p);
		if(productos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No se encontraron productos");
		}
		
		for(int i=0; i<productos.size();i++) {
			fila[0]=productos.get(i).damemodelo();
			fila[1]=productos.get(i).dametipo();
			fila[2]=productos.get(i).damecolor();
			fila[3]=productos.get(i).dametalla();
			fila[4]=productos.get(i).damecosto();
			fila[5]=productos.get(i).cantidadproductos;
			vvc.modelo.addRow(fila);
			
		}
	}
	
	//Este método calcula el total sobre las unidades que se van a vender y su precio unitario.

	public void calculatotal() {
		if(vvc.modelo.getValueAt(0, 6)==null) {
			JOptionPane.showMessageDialog(null, "Agregue pares a vender y presione enter");			
		}else {
			double costo=(double) vvc.modelo.getValueAt(0, 4);
			int cantidadproductos=(int)( vvc.modelo.getValueAt(0, 5));
			int cantidadventa=Integer.parseInt((String) vvc.modelo.getValueAt(0, 6)) ;
			if(cantidadventa>cantidadproductos) {
				JOptionPane.showMessageDialog(null, "Cantidad insuficiente de productos en almacén");
			}else {
				double iva = (costo*0.16);
				double montototal=(costo*cantidadventa)+iva;
				
				
				
				vvc.setMontounitario(String.valueOf(costo));
				vvc.setIva(String.format("%.3f", iva));
				vvc.setMontototal(String.valueOf(montototal));
			}
			
			
		}
		
	}
	
	//Creamos el ticket de venta

	public void creaTicket() {
		vticket.setFolio(String.valueOf(Ticket.setFolio()));
		vticket.setFecha(Ticket.getFechaActual());
		vticket.setModelo((String) vvc.modelo.getValueAt(0, 1));
		vticket.setColor((String) vvc.modelo.getValueAt(0, 2));
		vticket.setTalla(String.valueOf( vvc.modelo.getValueAt(0, 3)));
		vticket.setCantidad((String) vvc.modelo.getValueAt(0, 6));
		vticket.setIva(vvc.getIva());
		vticket.setPrecioUnitario(String.valueOf(vvc.modelo.getValueAt(0, 4)));
		vticket.setTotal(vvc.getTotal());
		vticket.setVisible(true);
		
		
	}
	
	//Este método imprime el ticket.
	public void imprimeTicket() {
		try {
			PrinterJob gap = PrinterJob.getPrinterJob();
			gap.setPrintable(this);
			boolean top = gap.printDialog();
			if(top) {
				gap.print();
			}
		}catch(PrinterException e){
			JOptionPane.showMessageDialog(null, "Error al imprimir");
		}
		
	}
	
	//Valida y le da formato de impresión al ticket.

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		if(pageIndex>0) {
			return NO_SUCH_PAGE;
		}
		
		Graphics2D hub = (Graphics2D) graphics;
		hub.translate(pageFormat.getImageableX()+20, pageFormat.getImageableY()+20);
		hub.scale(1, 1);
		
		vticket.getTicket().printAll(graphics);
		return PAGE_EXISTS;
		
	}
		
	}


