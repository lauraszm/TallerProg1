package ar.edu.ort.tp1.examen.modeloClases;

import java.util.List;

import ar.edu.ort.tp1.tdas.interfaces.Mostrable;

public class Centro implements Mostrable{
	private String nombre;
	private ListaOrdenadaDiagnosticoPorSeveridad diagnosticosOrdenados;

	
	
	public Centro(List<Diagnostico> diagnosticos, String nombre) {
		this.setNombre(nombre);
		this.diagnosticosOrdenados = new ListaOrdenadaDiagnosticoPorSeveridad();
		this.agregarDiagnostico(diagnosticos);
	}

	
	
	public void agregarDiagnostico(List<Diagnostico> diagnosticos) {
		for(Diagnostico d: diagnosticos) {			
			this.diagnosticosOrdenados.add(d);
		}
	}
	
	
	private void setNombre(String nombre) {
		if(nombre == null || nombre == "") {
			throw new IllegalArgumentException("El nombre del Centro no puede estar vacio o ser nulo");
		} else {
			this.nombre = nombre;
		}
	}
	
	

	@Override
	public void mostrar() {
		System.out.println("\nMOSTRANDO DIAGNOSTICOS -----");
		for(Diagnostico diag: this.diagnosticosOrdenados) {
			diag.mostrar();
		}
		System.out.println("\nFINALIZANDO PROCESO -- FUNDACION ORT-PSP");
	}
}
	
	
	
	
	

