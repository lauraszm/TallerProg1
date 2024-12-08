package ar.edu.ort.tp1.pacial1.clases;

public abstract class Pizza implements Mostrable {

	private static final String MSG_GANANCIA_INVALIDA = "Ganancia inv�lida";
	private static final String MSG_COSTO_INVALIDO = "Costo inv�lido";
	private static final String MSG_NOMBRE_INVALIDO = "Nombre inv�lido";
	//TODO A completar
	private String nombre;
	private float costoDeProduccion;
	private float porcentajeGanancia;

	public Pizza(String nombre, float costoDeProduccion, float porcentajeGanancia) {
		//TODO A completar
		this.nombre = nombre;
		this.costoDeProduccion = costoDeProduccion;
		this.porcentajeGanancia = porcentajeGanancia;
	}

	//TODO A completar
	public abstract float getPrecioDeCosto();


	public float getPrecioDeVenta() {	
		float gananciaASumar = porcentajeGanancia * getPrecioDeCosto()/100;
		return getPrecioDeCosto() + gananciaASumar;
	}


	public boolean modeloCorrecto(String modelo) {
	
		return modelo == this.nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	abstract String getTipo();
	
	public String getMensajeErrorNombre() {
		return MSG_NOMBRE_INVALIDO;
	}
	
	public String getMensajeErrorCosto() {
		return MSG_COSTO_INVALIDO;
	}
	
	public String getMensajeErrorGanancia() {
		return MSG_GANANCIA_INVALIDA;
	}
	
	public float getCostoBase() {
		return this.costoDeProduccion;
	}
	
	public float getPorcGanancia() {
		return this.porcentajeGanancia;
	}

	@Override
	public String toString() {
		return "Pizza [nombre=" + nombre + ", costoDeProduccion=" + costoDeProduccion + ", porcentajeGanancia="
				+ porcentajeGanancia + "]";
	}
	
	
}
