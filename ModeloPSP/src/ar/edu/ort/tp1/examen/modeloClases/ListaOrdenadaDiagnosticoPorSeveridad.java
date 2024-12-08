package ar.edu.ort.tp1.examen.modeloClases;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaOrdenadaDiagnosticoPorSeveridad extends ListaOrdenadaNodos<Severidad, Diagnostico> {

	@Override
	public int compare(Diagnostico dato1, Diagnostico dato2) {
		// TODO Auto-generated method stub
		return dato2.getNivelSeveridad() - dato1.getNivelSeveridad();
	}

	@Override
	public int compareByKey(Severidad clave, Diagnostico elemento) {
		// TODO Auto-generated method stub
		return elemento.getNivelSeveridad() - clave.ordinal();
	}

}
