package ejercicio2y3;

public class JJOO {

	public static void main(String[] args) {
		Carrera unaCarrera = new Carrera ("Atletismo");
		
		Atleta atleta1 = new Atleta("nombre1", 22.50);
		Atleta atleta2 = new Atleta("nombre2", 21.50);
		Atleta atleta3 = new Atleta("nombre3", 20.50);
		Atleta atleta4 = new Atleta("nombre4", 19.50);
		Atleta atleta5 = new Atleta("nombre5", 18.50);
		Atleta atleta6 = new Atleta("nombre6", 17.50);
		Atleta atleta7 = new Atleta("nombre7", 16.50);
		Atleta atleta8 = new Atleta("nombre8", 15.50);
		Atleta atleta9 = new Atleta("nombre9", 15.40);
		Atleta atleta10 = new Atleta("nombre10", 15.30);
		Atleta atleta11 = new Atleta("nombre11", 15.20);
		Atleta atleta12 = new Atleta("nombre12", 15.20);
		Atleta atleta13 = new Atleta("nombre13", 15.10);
		Atleta atleta14 = new Atleta("nombre14", 14.9);
		Atleta atleta15 = new Atleta("nombre15", 14.9);
		Atleta atleta16 = new Atleta("nombre16", 14.9);

		
		unaCarrera.agregarAtletaACarrera(atleta1);
		unaCarrera.agregarAtletaACarrera(atleta2);
		unaCarrera.agregarAtletaACarrera(atleta3);
		unaCarrera.agregarAtletaACarrera(atleta4);
		unaCarrera.agregarAtletaACarrera(atleta5);
		unaCarrera.agregarAtletaACarrera(atleta6);
		unaCarrera.agregarAtletaACarrera(atleta7);
		unaCarrera.agregarAtletaACarrera(atleta8);
		unaCarrera.agregarAtletaACarrera(atleta9);
		unaCarrera.agregarAtletaACarrera(atleta10);
		unaCarrera.agregarAtletaACarrera(atleta11);
		unaCarrera.agregarAtletaACarrera(atleta12);
		unaCarrera.agregarAtletaACarrera(atleta13);
		unaCarrera.agregarAtletaACarrera(atleta14);
		unaCarrera.agregarAtletaACarrera(atleta15);
		unaCarrera.agregarAtletaACarrera(atleta16);

		
		unaCarrera.mostrarGanadores();
	}

}
