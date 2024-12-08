package ar.edu.ort.tp1.examen.modeloClases;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;

public class EvaluacionPorPedidoMedico extends Evaluacion {
	final static String TIPO = "PEDIDO MEDICO";
	private Paciente paciente;
	private String nombreMedico;
	private ColaNodos<Paciente> pacientes;


	public EvaluacionPorPedidoMedico (int nroEvaluacion, String fechaAplicacion, String examinador,
			Puntaje puntaje, String medico) {
		super(nroEvaluacion, fechaAplicacion, examinador, puntaje);
		this.nombreMedico = medico;
		this.pacientes = new ColaNodos<Paciente>();
	}

	@Override
	public void mostrar() {
		System.out.println("\tSOLICITA: " + this.nombreMedico);
	}

	@Override
	public void informarPacientes() {
		Paciente centinela = null;
		this.pacientes.add(centinela);
		Paciente pacienteBuscado = this.pacientes.remove();
		System.out.println("EVALUACION NRO: " + super.getNroEvaluacion() + "--" + TIPO);
		while(pacienteBuscado != centinela) {
			pacienteBuscado.mostrar();
			this.pacientes.add(pacienteBuscado);
			pacienteBuscado = this.pacientes.remove();
		}
		
	}

	@Override
	public void evaluarPaciente(Paciente p) {
		this.pacientes.add(p);	
	}
	
	

}
