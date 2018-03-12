package Principal;
import Negocio.ControlLogin;
import Negocio.Controlventa;
import Negocio.ServicioLogin;
import Negocio.Servicioventa;

import Presentacion.VistaCambiocalzado;
import Presentacion.VistaLogin;
import Presentacion.VistaTicket;
import Presentacion.VistaVendedor;
import Presentacion.VistaVentacalzado;

public class Aplicacion {
	/**
	 * Este metodo crea el objeto incial
	 */
	public static void main(String[] args) {
                // Crea la instancia de la aplicacion
		Aplicacion app = new Aplicacion();

                // La inicia
		app.inicia();

	}

	/**
	 * Este metodo es el constructor
	 *
	 */
        public Aplicacion() {
           // No hay nada que inicializar
        }
	
	/**
	 * Este metodo inicia la aplicaci�n
	 *
	 */
	public void inicia() {
		//declaramos las clases
		VistaLogin l;
		VistaCambiocalzado vc;
		VistaVendedor vv;
		VistaVentacalzado vvc;
		VistaTicket vticket;
		Controlventa controlvent;
		ControlLogin controllog;
		Servicioventa servent;
		ServicioLogin servlog;
		
		//instanciamos las clases(crear objetos de clases)
		l=new VistaLogin();
		vticket=new VistaTicket();
		vc = new VistaCambiocalzado();
		vv = new VistaVendedor();
		vvc=new VistaVentacalzado();
		controlvent=new Controlventa();
		controllog=new ControlLogin();
		servent=new Servicioventa();
		servlog=new ServicioLogin();
		
		
		//establecemos las relaciones entre clases
		l.setControl(controllog);
		vc.setControl(controlvent);
		vv.setControl(controlvent);
		vticket.setControl(controlvent);
		vvc.setControl(controlvent);
		servent.setControl(controlvent);
		servlog.setControl(controllog);
		
		//enviamos una instancia de cada clase al control
		controlvent.setVistaCambiocalzado(vc);
		controlvent.setVistaticket(vticket);
		controllog.setVistaVendedor(vv);
		controllog.setVistaLogin(l);
		controllog.setServicioLogin(servlog);
		controlvent.setVistaVentacalzado(vvc);
		controlvent.setServicioventa(servent);
		
		
		l.setVisible(true);
	}
	
	
}


