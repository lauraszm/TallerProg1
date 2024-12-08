package ar.edu.ort.tp1.examen.clases;

public abstract class Envio {
	private static final int PRECIO_BASE_KM = 150;
	public String nombre;
	private float distancia;
	private float peso;
	
	public Envio(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPrecioBaseKm() {
		return PRECIO_BASE_KM;
	}
	
	public float getDistancia() {
		return this.distancia;
	}
	
	public float getPeso() {
		return this.peso;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public abstract float getPrecioEnvio(float peso, float distancia);
}
