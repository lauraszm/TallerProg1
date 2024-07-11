package ar.edu.ort.tp1.recu2.clases;

public abstract class Vehiculo implements Mostrable{
	private static final String MSJ_PAT_NULA = "La patente no puede ser nula";
	private String patente;
	private String marca;
	private String modelo;
	

	public Vehiculo(String patente, String marca, String modelo) {
		this.setPatente(patente);
		this.marca = marca;
		this.modelo = modelo;
		//TODO Completar
	}
	
	
	public void setPatente(String patente) {
		if (patente == null || patente.isEmpty() ) {
			throw new IllegalArgumentException(MSJ_PAT_NULA);
		}
		this.patente = patente;
	}
	
	public String getPatente() {
		return this.patente;
	}
	
	public boolean coincidePatente(String id) {
		return this.patente.equals(id);
	}
	
	
	
	@Override
	public String toString() {
		return "Vehiculo [patente=" + patente + ", marca=" + marca + ", modelo=" + modelo + "]";
	}


	public abstract double calcularIndiceCostoHora();
	public abstract String getDescripcionTipoVehiculo();
	public abstract TipoVehiculo getTipo();
	
	@Override
	public void mostrar() {
		System.out.println(this.toString());
	}
}
