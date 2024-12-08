package ar.edu.ort.tp1.examen.clases;

public abstract class Producto extends Item {

	private float precioBase;
	private int peso;

	public Producto(String nombre, float precioBase, int peso, int idItem) {
		
		super(nombre, idItem);
		this.precioBase = precioBase;
		this.peso = peso;
	}

	protected float getPrecioBase() {
		
		return this.precioBase;
	}

	@Override
	public int obtenerPeso() {

		return peso;
	}

}