package ort.edu.ar.clases;

public abstract class Paquete implements Detallable{
	
	private double precio;
	private String destino;
	
	public Paquete(String destino) {
		this.destino = destino;
	}
	
	public abstract void calcularPrecio();
	
	public double getPrecio() {
		return this.precio;
	}
	
	public String getDestino() {
		return this.destino;
	}
	
	protected void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public void verDetalle() {
		System.out.println("Destino: " + this.getDestino() + " $" + this.getPrecio());
		
	}
}
