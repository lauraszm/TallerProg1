package ejercicio2y3;

public class Atleta {
	private String nombre;
	private double tiempo;
	
	public Atleta(String nombre, double tiempo) {
		this.setNombre(nombre);
		this.setTiempo(tiempo);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTiempo() {
		return tiempo;
	}

	private void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public String toString() {
		return "Atleta [nombre=" + nombre + ", tiempo=" + tiempo + "]";
	}
	
}
