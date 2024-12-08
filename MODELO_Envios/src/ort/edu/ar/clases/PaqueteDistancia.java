package ort.edu.ar.clases;

public class PaqueteDistancia extends Paquete {
	
	private double distancia;
	private double precioDistancia;
	public PaqueteDistancia(String destino, double distancia, double precioDistancia) {
		super(destino);
		this.distancia = distancia;
		this.precioDistancia = precioDistancia;
		this.calcularPrecio();
	}

	@Override
	public void calcularPrecio() {
		// TODO Auto-generated method stub
		this.setPrecio(this.distancia * this.precioDistancia);
	}

}
