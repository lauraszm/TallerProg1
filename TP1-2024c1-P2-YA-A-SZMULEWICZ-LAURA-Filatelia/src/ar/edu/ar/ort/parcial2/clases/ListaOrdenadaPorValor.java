package ar.edu.ar.ort.parcial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaOrdenadaPorValor extends ListaOrdenadaNodos<Float, Sello> {

	@Override
	public int compare(Sello dato1, Sello dato2) {
		// TODO Auto-generated method stub
		return (int) (dato1.getValorComercial() - dato2.getValorComercial());
	}

	@Override
	public int compareByKey(Float clave, Sello elemento) {
		// TODO Auto-generated method stub
		return (int) (clave - elemento.getValorComercial());
	}

}
