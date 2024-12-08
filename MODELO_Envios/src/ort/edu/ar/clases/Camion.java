package ort.edu.ar.clases;

import edu.ort.tp1.u5.tda.Pila;
import edu.ort.tp1.u5.tda.nodos.PilaNodos;

public class Camion implements Detallable {
	private String patente;
	private Pila<Paquete> paquetes;

	public Camion(String patente) {
		this.patente = patente;
		this.paquetes = new PilaNodos<Paquete>();
	}
	
	public String getPatente() {
		return this.patente;
	}

	public void agregarPaquete(Paquete paquete) {
		this.paquetes.push(paquete);
	}

	public double verTotal() {

		Pila<Paquete> aux = new PilaNodos<Paquete>();
		double total = 0;
		
		while(!paquetes.isEmpty()) {
			total += paquetes.peek().getPrecio();
			aux.push(paquetes.pop());
		}
		while(!aux.isEmpty()) {
			this.paquetes.push(aux.pop());
		}
		return total;
	}

	@Override
	public void verDetalle() {
		System.out.println("Patente: " + this.getPatente());
		System.out.println("Total: $" + this.verTotal());
	}

}
