package ar.edu.ort.tp1.recu2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Cola;

public class Estacionamiento implements EspacioInteligente<Vehiculo, String>, Mostrable {

	private static final int CANTIDAD_PISOS_MIN = 2;
	private static final int CAPACIDAD_PISOS_MIN = 2;
	private static final String MSJ_MIN_PISOS = "Cantidad de pisos inválida"; 
	private static final String MSJ_CAPACIDAD_PISOS = "Capacidad Máxima inválida"; 

	private String nombre;
	private int cantPisos;
	private int capacidadPiso;
	private Cola<Piso> pisos;
//	TODO COMPLETAR

	public Estacionamiento(String nombre, int cantPisos, int capacidadPiso) {
		this.nombre = nombre;
		this.setCantPisos(cantPisos);
		this.setCapacidadPiso(capacidadPiso);
		this.pisos = new ColaNodos<Piso>();
		this.crearPisos(cantPisos);
//		TODO COMPLETAR
	}
	
	private void crearPisos(int cantPisos) {
		for(int i = 0; i < this.cantPisos; i++) {
			this.pisos.add(new Piso(this.capacidadPiso));
		}
	}
	
	public void setCantPisos(int cantPisos) {
		if(cantPisos < CANTIDAD_PISOS_MIN) {
			throw new RuntimeException(MSJ_MIN_PISOS);
		}
		this.cantPisos = cantPisos;
	}
	
	public void setCapacidadPiso(int capacidad) {
		if(capacidad < CAPACIDAD_PISOS_MIN) {
			throw new RuntimeException(MSJ_CAPACIDAD_PISOS);
		}
		this.capacidadPiso = capacidad;
	}

	@Override
	public void mostrar() {
		System.out.println("Estadisticas del garage: " + nombre);
		mostrarVehiculosPorPisoTipo();
		System.out.println("---------------------------------");
		System.out.println("Motos estacionadas por patente:");
		mostrarListaMotos();
//		TODO COMPLETAR
	}

	private void mostrarVehiculosPorPisoTipo() {
		int[][] informe = new int[this.cantPisos][TipoVehiculo.values().length];
		informe = crearInforme();
		String titulos = "PISO \t " + TipoVehiculo.MOTO.getDescripcion() + "\t" + TipoVehiculo.AUTO.getDescripcion() + "\t" + TipoVehiculo.AUTO_ELECTRICO.getDescripcion();
		System.out.println(titulos);
		for(int p = 0; p < this.cantPisos; p++) {
			String dataPorPiso = Integer.toString(p) + "\t";
			dataPorPiso.concat((p + 1) + "\t");
			for (int t = 0; t < TipoVehiculo.values().length; t++) {
				dataPorPiso += (Integer.toString(informe[p][t]) + "\t");
			}
			System.out.println(dataPorPiso);
		}
		
	}
	
	private int[][] crearInforme(){
		int[][] informe = new int[this.cantPisos][TipoVehiculo.values().length];
		int cont = 0;
			int[] vehPorPiso = new int[TipoVehiculo.values().length];
			Piso piso, cent = null;
			this.pisos.add(cent);
			piso = this.pisos.remove();
			while (piso != null) {
				vehPorPiso = piso.informePorTipo();
				this.pisos.add(piso);
				piso = this.pisos.remove();
				informe[cont] = vehPorPiso;
				if(cont < this.cantPisos-1) {					
					cont++;
				}
			}
		return informe;
	}
	
	private ListaOrdenadaPorPatente crearLista() {
		ListaOrdenadaPorPatente listaMotos = new ListaOrdenadaPorPatente();
		
		Piso pisoMotos = this.pisos.get();
		listaMotos = pisoMotos.ordenarVehiculos();
		
		return listaMotos;
	}
	
	private void mostrarListaMotos() {
		ListaOrdenadaPorPatente listaMotos = crearLista();
		for(Vehiculo v: listaMotos) {
			System.out.println("Vehiculo tipo: " + v.getDescripcionTipoVehiculo() + " " + v.toString());
		}
	}

	@Override
	public Vehiculo retirar(String id) {
		Vehiculo buscado = null, v;
		Piso p, centinela = null;
		if(id.contains(TipoVehiculo.MOTO.getDescripcion())) {
			p = this.pisos.get();
			v = p.retirar(id);
			if(v != null) {
				buscado = v;
			}
		} else {
			this.pisos.add(centinela);
			p = this.pisos.remove();
			while (p!= null) {
				if(buscado == null) {					
					v = p.retirar(id);
					if(v != null) {
						buscado = v;
					} 
				}
				this.pisos.add(p);
				p = this.pisos.remove();
			}
		}
		
		return buscado;
	}

	@Override
	public void agregar(Vehiculo elemento) {
		Piso p, centinela = null, pisoMotos;
		boolean estacionado = false;
		if(elemento.getDescripcionTipoVehiculo().equals(TipoVehiculo.MOTO.getDescripcion())) {
			p = this.pisos.get();
			if(p.puedeEstacionar()) {
				p.agregar(elemento);
			} else {
				throw new RuntimeException("No se pudo estacionar la moto");
			}
		} else {
			//remuevo el primer piso y lo agrego despues del centinela
			pisoMotos = this.pisos.remove();
			this.pisos.add(centinela);
			this.pisos.add(pisoMotos);
			p = this.pisos.remove();
			while(p != null) {
				if(!estacionado) {
					if(p.puedeEstacionar()) {
						p.agregar(elemento);
						estacionado = true;
					}
				}
				this.pisos.add(p);
				p = this.pisos.remove();
			}
			if(!estacionado) {
				throw new RuntimeException("No se pudo estacionar el auto");
			}
		}
		
	}

	@Override
	public int lugarDisponible() {
		int suma = 0;
		Piso centinela = null;
		Piso p;
		this.pisos.add(centinela);
		p = this.pisos.remove();
		while(p != null) {
			suma += p.lugarDisponible();
			this.pisos.add(p);
			p = this.pisos.remove();
		}
		
		return suma;
	}
}
