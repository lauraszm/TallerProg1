package clubSocios;

import java.util.ArrayList;

public class CasaClub {

	private ArrayList<Socio> socios;

	public CasaClub() {
		this.socios = new ArrayList<Socio>();
	}
	
	public void AgregarSocio(Socio unSocio) {
		boolean existeSocio = this.buscarSocio(unSocio.getNombre_completo()) != null;
		if (!existeSocio) {			
			this.socios.add(unSocio);
		} else {
			System.out.println("Socio existente");
		}
	}
	
	public void ListarSocios() {
		for (Socio unSocio: this.socios) {
			System.out.println(unSocio.toString());
		}
	}
	
	private Socio buscarSocio(String nombre) {
		Socio socioBuscado = null, socioActual;
		int index = 0;
		
		while (index < this.socios.size() && socioBuscado == null) {
			socioActual = this.socios.get(index);
			if (socioActual.getNombre_completo().equals(nombre)) {
				socioBuscado = socioActual;
			} else {
				index++;
			}
		}
		return socioBuscado;
	}
	
	private Socio buscarSocio(int nroSocio) {
		Socio socioBuscado = null, socioActual;
		int index = 0;
		
		while (index < this.socios.size() && socioBuscado == null) {
			socioActual = this.socios.get(index);
			if (socioActual.getNro_socio() == nroSocio) {
				socioBuscado = socioActual;
			} else {
				index++;
			}
		}
		return socioBuscado;
	}
	
	public void mostrarVitalicios() {
		int cantVitalicios = 0;
		System.out.println("*****SOCIOS VITALICIOS*****");
		for (Socio socio: this.socios) {
			if(socio.esVitalicio()) {
				cantVitalicios++;
				System.out.println(socio.toString());
			}
		}
		System.out.println("Cantidad de socios vitalicios: " + cantVitalicios);
	}
	
	public void eliminarSocio(int nroSocio) {
		Socio socioBuscado = this.buscarSocio(nroSocio);
		if (socioBuscado != null) {
			this.socios.remove(socioBuscado);
		} else {
			System.out.println("No existe el socio");
		}
	}
	
}
