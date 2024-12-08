package ar.edu.ort.tp1.examen.clases;

public class Bebida extends Producto {

	private static final int PESO_X_CM3 = 53;
	private Tamanio tamanio;

	public Bebida(String nombre, float precioBase, int peso, Tamanio tamanio, int idItem) {
		super(nombre, precioBase, peso, idItem);
		this.tamanio = tamanio;
	}

	@Override
	public float obtenerPrecio() {

		return getPrecioBase() * tamanio.getCoefPrecio();
	}

	@Override
	public int obtenerPeso() {

		return super.obtenerPeso() + PESO_X_CM3 * tamanio.getCapacidadCM3();
	}

	@Override
	public void mostrar() {
		//Bebida: Coca Cola Mediana (10) Tamaño: MEDIANA - Precio base: $100.0
		System.out.println("Bebida: " + getNombre() + " (" + getCantidad() + ")"  + " Tamaño " + tamanio + " - Precio base: $" + getPrecioBase());
	}

}