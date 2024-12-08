package ar.edu.ort.tp1.examen.clases;

import java.util.ArrayList;

public class Pedido {

	private ArrayList<Item> items;
	private Envio formaDeEnvio;
	private float distancia;
	
	public Pedido(Envio formaDeEnvio, float distancia) {
		this.formaDeEnvio = formaDeEnvio;
		this.distancia = distancia;
		this.items = new ArrayList<Item>();
	}
	
	private Item buscarItem(Item item) {
		Item itemBuscado = null;
		int pos = 0;
		
		while(pos < this.items.size() && itemBuscado == null) {
			if(this.items.get(pos).getIdItem() == item.getIdItem()) {
				itemBuscado = this.items.get(pos);
			} pos++;
		}
		return itemBuscado;
	}

	public void agregarItem(Item item, int cant) {
		if (item != null) {
			if(buscarItem(item) == null) {	
				this.items.add(item);
				item.sumarCantItem(cant);
			} else {
				item.sumarCantItem(cant);
			}
		}
		System.out.println("Se agrego la cantidad " + cant + " del item: ");
		item.mostrar();
	}
	
	public void quitarItems(Item item, int cant) {
		if(buscarItem(item) != null) {
			if(item.getCantidad() > cant) {
				item.restarCantItem(cant);
				System.out.println("Se quitó la cantidad " + cant + " del item " + item.getNombre());
			} else {
				this.items.remove(item);
				System.out.println("Se quito el total de " + item.getNombre());
			}
		} else {
			System.out.println("No se logró quitar el ítem porque no estaba en el pedido");
		}
	}

	public InfoVenta evaluar() {
		int peso = 0;
		float precio = 0;
		for (Item item : items) {
			peso += (item.obtenerPeso() * item.getCantidad());
			precio += (item.obtenerPrecio() * item.getCantidad());
		}
		return new InfoVenta(precio, peso);
	}
	
	public float precioTotalConEnvio() {
		InfoVenta info = evaluar();
		float precioEnvio = formaDeEnvio.getPrecioEnvio(info.getPeso(), this.distancia);
				
		return info.getPrecio() + precioEnvio;
	}
	
	

}