package ar.edu.ort.tp1.examen.modeloClases;

import ar.edu.ort.tp1.tdas.interfaces.Mostrable;

public class Paciente implements Mostrable{
	
	private int nroInscripcion;
	private String nombreCompleto;
	private int[] edadCronologica;
	
	
	public Paciente(int nroInsc, String nombreCompleto) {
		this.nroInscripcion = nroInsc;
		this.nombreCompleto = nombreCompleto;
	}
		
	
    public void setEdadCronologica(int[] edad) {
    	this.edadCronologica =  edad;
    }


	@Override
	public void mostrar() {
		System.out.println("\tNumero de inscripcion: " + this.nroInscripcion + "--Nombre completo: " + this.nombreCompleto.toUpperCase()+ "\n\tEdad Cronologica: " + this.edadCronologica[0] + " años y " + this.edadCronologica[1] + " meses");
	}
	
	

}
