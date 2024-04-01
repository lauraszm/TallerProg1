package ejercicio2y3;

import java.util.ArrayList;

public class Carrera {
	private String nombreDisciplina;
	private ArrayList<Atleta> atletas;
	private ArrayList<Podio> podio;
	
	public Carrera(String nombreDisciplina) {
		this.setNombreDisciplina(nombreDisciplina);
		this.atletas = new ArrayList<Atleta>();
		this.podio = new ArrayList<Podio>();
	}

	public String getNombreDisciplina() {
		return nombreDisciplina;
	}

	private void setNombreDisciplina(String nombreDisciplina) {
		this.nombreDisciplina = nombreDisciplina;
	}
	
	private Atleta buscarAtleta(String nombre) {
		Atleta atletaBuscado = null;
		int i = 0;
		while (i < this.atletas.size() && atletaBuscado == null) {
			if (this.atletas.get(i).getNombre().equals(nombre)) {
				atletaBuscado = this.atletas.get(i);
			}
			i++;
		}
		return atletaBuscado;
	}
	
	public void agregarAtletaACarrera(Atleta atleta) {
		if(buscarAtleta(atleta.getNombre()) == null) {
			this.atletas.add(atleta);
		}
	}
	
	public void buscarGanadores(int posicion, ArrayList<Atleta> lista){
		ArrayList<Atleta> ganadores = new ArrayList<Atleta>();
		double menorTiempo = this.atletas.get(0).getTiempo();
		
		for(Atleta atleta: lista) {
			if(atleta.getTiempo() < menorTiempo) {
				menorTiempo = atleta.getTiempo();
				ganadores.clear();
				ganadores.add(atleta);
			} else if(atleta.getTiempo() == menorTiempo) {
				ganadores.add(atleta);
			}
		}
		
		for(Atleta ganador: ganadores) {
			Podio unPodio = new Podio (posicion, ganador);
			this.podio.add(unPodio);
			lista.remove(ganador);
		}
		
	}

	public void crearPodio() {
		ArrayList<Atleta> atletasCopia = (ArrayList<Atleta>) this.atletas.clone();
		int pos;
		for (pos = 1; pos <=3; pos++) {
			buscarGanadores(pos, atletasCopia);
		}
	}
	
	public void mostrarGanadores() {
		crearPodio();
		if (this.podio.size() > 0) {
			for (Podio atleta: this.podio) {
				System.out.println(atleta.toString());
			}
		}
	}
	
	
	
	
	
}
