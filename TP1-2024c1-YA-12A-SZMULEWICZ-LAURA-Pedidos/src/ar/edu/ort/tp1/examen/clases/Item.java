package ar.edu.ort.tp1.examen.clases;

public abstract class Item implements Mostrable, Enviable{
	private String nombre;
	private int cant;
	private int idItem;

	public Item(String nombre, int idItem) {
		this.nombre = nombre;
		this.idItem = idItem;
		this.cant = 0;
	}

	
	public int getIdItem() {
		return this.idItem;
	}
	
	public void sumarCantItem(int cantItems) {
		this.cant += cantItems;
	}
	
	public void restarCantItem(int cantItems) {
		this.cant -= cantItems;
	}
	
	public int getCantidad() {
		return this.cant;
	}
	
	public String getNombre() {
		return this.nombre;
	}


	public abstract int obtenerPeso();

	public abstract float obtenerPrecio();
	
	public abstract void mostrar();
}