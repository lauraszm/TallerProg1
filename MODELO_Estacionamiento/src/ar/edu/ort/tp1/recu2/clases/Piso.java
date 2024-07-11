package ar.edu.ort.tp1.recu2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Pila;

public class Piso implements EspacioInteligente<Vehiculo, String>{

	private static final int MINIMA_CAPACIDAD_MAXIMA = 2;
	private int capacidadMax;
	private Pila<Vehiculo> vehiculos;
	private int cantVehiculosEstacionados;
	
//	TODO COMPLETAR
	
	public Piso(int capacidadMaxima) {
		this.capacidadMax = capacidadMaxima;
		this.vehiculos = new PilaNodos<Vehiculo>();
		this.cantVehiculosEstacionados = 0;
//		TODO COMPLETAR
	}



	@Override
	public Vehiculo retirar(String id) {
		// TODO Auto-generated method stub
		Pila<Vehiculo> aux = new PilaNodos<Vehiculo>();
		Vehiculo v, vBuscado = null;
		while(!this.vehiculos.isEmpty()) {
			v = this.vehiculos.pop();
			if(v.coincidePatente(id)) {
				vBuscado = v;
				this.cantVehiculosEstacionados--;
			} else {
				aux.push(v);
			}
		}
		while (!aux.isEmpty()) {
			this.vehiculos.push(aux.pop());
		}
		return vBuscado;
	}

	@Override
	public void agregar(Vehiculo elemento) {
		this.vehiculos.push(elemento);
		this.cantVehiculosEstacionados++;
	}

	@Override
	public int lugarDisponible() {
		// TODO Auto-generated method stub
		return this.capacidadMax - this.cantVehiculosEstacionados;
	}
	
	public boolean puedeEstacionar() {
		return this.capacidadMax != this.cantVehiculosEstacionados;
	}
	
	public int[] informePorTipo() {
		int[] cantPorTipo = new int[TipoVehiculo.values().length];
		
		Pila<Vehiculo> aux = new PilaNodos<Vehiculo>();
		Vehiculo v;
		while(!this.vehiculos.isEmpty()) {
			v = this.vehiculos.pop();
			TipoVehiculo t = v.getTipo();
			cantPorTipo[t.ordinal()]++;
			aux.push(v);
		}
		while (!aux.isEmpty()) {
			this.vehiculos.push(aux.pop());
		}
		
		return cantPorTipo;
	}
	
	public ListaOrdenadaPorPatente ordenarVehiculos() {
		ListaOrdenadaPorPatente listaPorPatente = new ListaOrdenadaPorPatente();
		
		Pila<Vehiculo> aux = new PilaNodos<Vehiculo>();
		Vehiculo v;
		while(!this.vehiculos.isEmpty()) {
			v = this.vehiculos.pop();
			listaPorPatente.add(v);
			aux.push(v);
		}
		while (!aux.isEmpty()) {
			this.vehiculos.push(aux.pop());
		}
		
		return listaPorPatente;
	}

}
