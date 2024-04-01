package ejercicio1;

import java.util.ArrayList;

public class Grupo {
	private String nombreGrupo;
	private ArrayList<String> listaIntegrantes;
	
	public Grupo(String nombreGrupo) {
		this.setNombre(nombreGrupo);
		listaIntegrantes = new ArrayList<String>();
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	private void setNombre(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}
	
	public int getCantidadIntegrantes() {
		return this.listaIntegrantes.size();
	}
	
	private String buscarIntegrante(String nombreIntegrante) {
		int i = 0;
		String nombreBuscado = null;
		while (i < this.getCantidadIntegrantes() && nombreBuscado == null) {
			if (this.listaIntegrantes.get(i).equals(nombreIntegrante)) {
				nombreBuscado = nombreIntegrante;
			}
			i++;
		}
		return nombreBuscado;
	}
	
	public void agregarIntegrante(String nombreIntegrante) {
		if (this.getCantidadIntegrantes() == 0) {
			this.listaIntegrantes.add(nombreIntegrante);
		} else {			
			if(buscarIntegrante(nombreIntegrante) == null) {
				this.listaIntegrantes.add(nombreIntegrante);
				System.out.println("Se agrego a " + nombreIntegrante + " al grupo " + this.getNombreGrupo());
			} else {
				System.out.println("El nombre " + nombreIntegrante + " ya existe en el grupo " + this.getNombreGrupo());
			}
		}
	}
	
	private int obtenerPosicionIntegrante(String nombreIntegrante) {
		return this.listaIntegrantes.indexOf(nombreIntegrante);
	}
	
	public String obtenerIntegrante(int posicion) {
		String nombreBuscado = null;
		if (posicion > 0 && posicion <= this.getCantidadIntegrantes()) {
			nombreBuscado = this.listaIntegrantes.get(posicion-1);
		}
		return nombreBuscado;
	}
	
	public String removerIntegrante(String nombreIntegrante) {
		String nombreARemover = null;
		if(this.obtenerPosicionIntegrante(nombreIntegrante)> -1) {
			nombreARemover = nombreIntegrante;
			this.listaIntegrantes.remove(this.obtenerPosicionIntegrante(nombreIntegrante));
		}
		return nombreARemover;
	}
	
	private void mostrarIntegrantes() {
		for(String nombre: this.listaIntegrantes) {
			System.out.println(nombre);
		}
	}
	
	public void mostrar() {
		System.out.println("Nombre del grupo: " +this.getNombreGrupo());
		System.out.println("Cantidad de integrantes: " + this.getCantidadIntegrantes());
		if (this.getCantidadIntegrantes()>0) {			
			this.mostrarIntegrantes();
		}
	}
	
	public void vaciar() {
		this.listaIntegrantes.clear();
	}
}
