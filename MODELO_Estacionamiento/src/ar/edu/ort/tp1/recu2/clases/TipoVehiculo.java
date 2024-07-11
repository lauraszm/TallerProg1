package ar.edu.ort.tp1.recu2.clases;

public enum TipoVehiculo {

	MOTO("Moto"), AUTO("Auto"), AUTO_ELECTRICO("Auto Eléctrico");

	private String descripcion;

	private TipoVehiculo(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
