package ort.edu.ar.clases;

public class PaqueteMasa extends Paquete {
	private double alto;
	private double ancho;
	private double largo;
	private double multiplicador;

	
	public PaqueteMasa(String destino, double alto, double ancho, double largo, double multiplicador) {
		super(destino);
		this.alto = alto;
		this.ancho = ancho;
		this.largo = largo;
		this.multiplicador = multiplicador;
		this.calcularPrecio();
	}


	@Override
	public void calcularPrecio() {
		this.setPrecio((this.alto * this.ancho * this.largo) * this.multiplicador);
	}


	

}
