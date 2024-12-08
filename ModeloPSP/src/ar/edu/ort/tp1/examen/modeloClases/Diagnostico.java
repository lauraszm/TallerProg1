package ar.edu.ort.tp1.examen.modeloClases;

import ar.edu.ort.tp1.tdas.interfaces.Mostrable;

public class Diagnostico implements Mostrable{

	private String codigoDiagnostico;
	private Severidad severidad;
	private Evaluacion[][] evaluaciones;

	public Diagnostico(String codigo, Severidad severidad){
		this.codigoDiagnostico = codigo;
		this.severidad = severidad;
		this.evaluaciones = new Evaluacion[Jornada.values().length][Guardia.values().length];
	}
	
	public void agregarEvaluacion(Evaluacion e, Jornada j, Guardia g) {
		if(this.evaluaciones[j.ordinal()][g.ordinal()] == null) {
			this.evaluaciones[j.ordinal()][g.ordinal()] = e;
		} else {
			throw new RuntimeException("Ya hay una Evaluacion almacenada para el " + j + "--" + g + "\n");
		}
	}
	
	public void mostrarEvaluaciones() {
		
		Evaluacion evaluacion;
		for (int i = 0; i < evaluaciones.length; i++) {
			for (int j = 0; j < evaluaciones[i].length; j++){
				evaluacion = this.evaluaciones[i][j];
				if(evaluacion != null) {					
					System.out.println("\tEVALUACION NRO: " + evaluacion.getNroEvaluacion() + "REALIZADA EL " + evaluacion.getFecha() + " POR " + evaluacion.getExaminador() + "\n\tPUNTAJE: " + evaluacion.getPuntaje());
					evaluacion.mostrar();
				}
			}
		}
	}
	
	public int getNivelSeveridad() {
		return this.severidad.ordinal();
	}
	
	
	@Override
	public void mostrar() {
		System.out.println("\nCODIGO: " + codigoDiagnostico + " /SEVERIDAD: " + severidad + "\nEVALUACIONES");
		this.mostrarEvaluaciones();
		
	}



	
	
	
	


	
}
