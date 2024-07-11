package ar.edu.ort.tp1.recu2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaOrdenadaPorPatente extends ListaOrdenadaNodos<String, Vehiculo> {

	@Override
	public int compare(Vehiculo dato1, Vehiculo dato2) {
		// TODO Auto-generated method stub
		return dato1.getPatente().compareTo(dato2.getPatente());
	}

	@Override
	public int compareByKey(String clave, Vehiculo elemento) {
		// TODO Auto-generated method stub
		return clave.compareTo(elemento.getPatente());
	}

}
