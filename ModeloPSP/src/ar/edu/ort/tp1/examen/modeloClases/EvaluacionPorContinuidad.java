package ar.edu.ort.tp1.examen.modeloClases;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Pila;

public class EvaluacionPorContinuidad extends Evaluacion {
	final static String TIPO = "CONTINUIDAD";
	private String motivo;
	private PilaNodos<Paciente> pacientes;
	
	//new EvaluacionPorContinuidad(4, "09/05/2023", "FERNANDA P.", Puntaje.PROMEDIO, "FALTA EVALUAR MOTRICIDAD");

	public EvaluacionPorContinuidad(int nroEvaluacion, String fechaAplicacion, String examinador,
			Puntaje puntaje, String motivo) {
		super(nroEvaluacion, fechaAplicacion, examinador, puntaje);
		this.motivo = motivo;
		this.pacientes = new PilaNodos<Paciente>();
	}

	@Override
	public void mostrar() {
		System.out.println("\t"+this.motivo.toUpperCase());
	}

	@Override
	public void informarPacientes() {

		Pila<Paciente> aux = new PilaNodos<Paciente>();
		System.out.println("EVALUACION NRO: " + super.getNroEvaluacion() + "--" + TIPO);
		while(!this.pacientes.isEmpty()) {
			
			this.pacientes.peek().mostrar();
			aux.push(this.pacientes.pop());
		}
		
		while(!aux.isEmpty()) {
			this.pacientes.push(aux.pop());
		}
		
	}

	@Override
	public void evaluarPaciente(Paciente p) {
		// TODO Auto-generated method stub
		this.pacientes.push(p);
	}

}
