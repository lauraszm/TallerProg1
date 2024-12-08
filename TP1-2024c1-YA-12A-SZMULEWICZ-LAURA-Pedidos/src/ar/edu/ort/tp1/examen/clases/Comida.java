package ar.edu.ort.tp1.examen.clases;

public class Comida extends Producto {

	private static final float COEF_COCIDA = 1.08f;
	private boolean cocida;
	private int cantIngredientes;

	public Comida(String nombre, float precioBase, int peso, int cantIngredientes, boolean cocida, int idItem) {
		super(nombre, precioBase, peso, idItem);
		this.cocida = cocida;
		this.cantIngredientes = cantIngredientes;
	}

	@Override
	public float obtenerPrecio() {

		return getPrecioBase() * cantIngredientes * (cocida ? COEF_COCIDA : 1);
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		//Comida: Patitas (13) Cocida: true - Cantidad de ingredientes: 2 - Precio base: $280.0
		System.out.println("Comida: " + getNombre() + " (" + getCantidad() + ") + Cocida: " + cocida + " - Cantidad de ingredientes: " + cantIngredientes + " - Precio base: $" + getPrecioBase());
	}

}