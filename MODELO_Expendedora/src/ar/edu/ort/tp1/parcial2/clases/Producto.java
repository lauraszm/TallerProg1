package ar.edu.ort.tp1.parcial2.clases;

import ort.tp1.tdas.implementaciones.PilaNodos;
import ort.tp1.tdas.interfaces.Pila;

public class Producto implements Apreciable, Identificable<Integer> {

	private static final String MSJ_AJUSTE_INVALIDO = "Actualizacion Invalido";
	private final static String MSJ_PRECIO_INVALIDO = "Precio Invalido";
	private final static String MSJ_NOMBRE_INVALIDO = "Nombre Invalido";
	private static final String MSJ_ID_INVALIDO = "ID Invalido";

	private Integer id;
	private String nombre;
	private double precioInicial;

	private Pila<HistoricoActualizacion> historicoActualizaciones;

	public Producto(Integer id, double precioInicial, String nombre) {
		this.setId(id);
		this.setNombre(nombre);
		this.setPrecioInicial(precioInicial);
		this.historicoActualizaciones = new PilaNodos<HistoricoActualizacion>();
	}

	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public boolean mismoId(Integer otroId) {
		return otroId.equals(id);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private void setNombre(String nombre) {
		if(nombre == null) {
			throw new IllegalArgumentException(MSJ_NOMBRE_INVALIDO);
		}
		this.nombre = nombre;
	}
	
	private void setId(int id) {
		if(id <=0) {
			throw new IllegalArgumentException(MSJ_ID_INVALIDO);
		}
		this.id = id;
	}
	
	private void setPrecioInicial(double precio) {
		if(precio <= 0) {
			throw new IllegalArgumentException(MSJ_PRECIO_INVALIDO);
		}
		this.precioInicial = precio;
	}

	public double obtenerPrecio() {
		double ultimoPrecio = 0;
		if (!historicoActualizaciones.isEmpty()) {
			ultimoPrecio = historicoActualizaciones.peek().getPrecio();
		} else {
			ultimoPrecio = this.precioInicial;
		}
		return ultimoPrecio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", precio=" + obtenerPrecio() + ", nombre=" + nombre + "]";
	}

	@Override
	public void aplicarActualizacion(Actualizacion actualizacion) throws RuntimeException {
		if (actualizacion == null || actualizacion.getValor() <= 0) {
			throw new RuntimeException(MSJ_AJUSTE_INVALIDO);
		}
		double precio = obtenerPrecio();
		double nuevoPrecio = 0;
		// TODO Calcular el nuevo precio
		if(actualizacion.getTipo().equals("ActualizacionDirecta")) {
			nuevoPrecio = ((ActualizacionDirecta) actualizacion).obtenerValorCalculado();
		} else {
			nuevoPrecio = ((ActualizacionExtendida)actualizacion).obtenerValorCalculado(precio);
		}
		if (nuevoPrecio < 0) {
			throw new RuntimeException(MSJ_PRECIO_INVALIDO);
		}
		this.historicoActualizaciones.push(new HistoricoActualizacion(actualizacion, precio, nuevoPrecio));
	}

	public void listarActualizacionesDePrecio() {
		Pila<HistoricoActualizacion> aux = new PilaNodos<HistoricoActualizacion>();
		while(!this.historicoActualizaciones.isEmpty()) {
			System.out.println(this.historicoActualizaciones.peek());
			aux.push(this.historicoActualizaciones.pop());
		}
		while(!aux.isEmpty()) {
			this.historicoActualizaciones.push(aux.pop());
		}
		
	}
}