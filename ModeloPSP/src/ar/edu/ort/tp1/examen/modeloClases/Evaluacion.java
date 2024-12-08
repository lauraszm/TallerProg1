package ar.edu.ort.tp1.examen.modeloClases;

import ar.edu.ort.tp1.tdas.interfaces.Mostrable;

public abstract class Evaluacion implements Mostrable{

	private int nroEvaluacion;
	private String fechaAplicacion;
	private String examinador;
	private Puntaje puntaje;
	
	
	public Evaluacion(int nroEvaluacion, String fechaAplicacion, String examinador,
			Puntaje puntaje) {
		this.nroEvaluacion = nroEvaluacion;
		this.fechaAplicacion = fechaAplicacion;
		this.examinador = examinador;
		this.puntaje = puntaje;
	}
	
	public int getNroEvaluacion() {
		return this.nroEvaluacion;
	}
	
	public String getFecha() {
		return this.fechaAplicacion;
	}
	
	public String getExaminador() {
		return this.examinador;
	}
	
	public Puntaje getPuntaje() {
		return this.puntaje;
	}
	
	abstract public void informarPacientes();
	
	abstract public void evaluarPaciente(Paciente p);
}
