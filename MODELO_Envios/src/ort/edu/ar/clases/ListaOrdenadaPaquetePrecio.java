package ort.edu.ar.clases;

import edu.ort.tp1.u5.tda.nodos.ListaOrdenadaNodos;

public class ListaOrdenadaPaquetePrecio extends ListaOrdenadaNodos<Double, Paquete> {

	@Override
	public double compare(Paquete dato1, Paquete dato2) {
		// TODO Auto-generated method stub
		return dato1.getPrecio() - dato2.getPrecio();
	}

	@Override
	public int compareByKey(Double clave, Paquete elemento) {
		// TODO Auto-generated method stub
		return (int) (clave - elemento.getPrecio());
	}

	
	
}
