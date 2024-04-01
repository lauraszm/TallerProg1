package ejercicio1;

public class Main {

	public static void main(String[] args) {
		Grupo unGrupo = new Grupo ("Grupo1");
		
		unGrupo.agregarIntegrante("nombre1");
		unGrupo.agregarIntegrante("nombre2");
		unGrupo.agregarIntegrante("nombre3");
		unGrupo.agregarIntegrante("nombre4");
		unGrupo.agregarIntegrante("nombre5");
		unGrupo.agregarIntegrante("nombre6");
		unGrupo.agregarIntegrante("nombre7");
		unGrupo.agregarIntegrante("nombre8");
		unGrupo.agregarIntegrante("nombre8");
		
		System.out.println("***** PRIMERA CARGA *****");
		unGrupo.mostrar();
		
		System.out.println("***** REMUEVO UN INTEGRANTE *****");
		String nombreARemover = unGrupo.removerIntegrante("nombre8");
		if(nombreARemover != null) {
			System.out.println(nombreARemover + " fue removido del grupo " + unGrupo.getNombreGrupo());
		}
		unGrupo.mostrar();
		
		System.out.println("***** BUSCAR POR POSICION *****");
		int pos = 4;
		String nombreABuscar = unGrupo.obtenerIntegrante(pos);
		if (nombreABuscar != null) {			
			System.out.println("La persona en la posicion " + pos + " es " + nombreABuscar);
		} else {
			System.out.println("El grupo es menor a " + pos + " personas");
		}
		
		unGrupo.vaciar();		
		System.out.println("***** GRUPO VACIADO *****");
		unGrupo.mostrar();
	}

}
