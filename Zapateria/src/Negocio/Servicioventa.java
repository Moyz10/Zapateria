package Negocio;

import Modelo.Producto;
import Persistencia.DAOProducto;

public class Servicioventa {
	//Declaramos atributos de nuestro servicio.

	private Controlventa control;
	DAOProducto dao = new DAOProducto();

	//Instanciamos el control de nuestro servicio.
	public void setControl(Controlventa control) {
		this.control=control;
		
	}
	//Este método consulta al DAOProducto si existe alguno con ese id. y lo retorna.

	public Producto buscaProducto(int id) {
		Producto producto=dao.buscaProducto(id);
		return producto;
	}
	
          
}
