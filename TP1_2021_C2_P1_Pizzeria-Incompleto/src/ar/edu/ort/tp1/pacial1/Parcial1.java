package ar.edu.ort.tp1.pacial1;

import ar.edu.ort.tp1.pacial1.clases.Pizzeria;
import ar.edu.ort.tp1.pacial1.clases.Rectangular;
import ar.edu.ort.tp1.pacial1.clases.TipoDeMasa;
import ar.edu.ort.tp1.pacial1.clases.Tradicional;
import ar.edu.ort.tp1.pacial1.clases.Especial;
import ar.edu.ort.tp1.pacial1.clases.TamanioDePizza;
import ar.edu.ort.tp1.pacial1.clases.AdicionalQueso;

public class Parcial1 {

	private static final String MSG_ERROR = "Error fabricando una pizza %s\n";

	public static void main(String[] args) {

		Pizzeria laPizzeria = new Pizzeria("Pizzaiola Baratelli");

		fabricarTradicional(laPizzeria, "Mozarella", 500, 20, TipoDeMasa.A_LA_PIEDRA);
		fabricarTradicional(laPizzeria, "Margarita", 600, 20, TipoDeMasa.A_LA_PIEDRA);
		fabricarTradicional(laPizzeria, "", 600, 20, TipoDeMasa.A_LA_PIEDRA);
		fabricarTradicional(laPizzeria, "Peperoni", 700, 10, TipoDeMasa.MEDIA_MASA);
		fabricarTradicional(laPizzeria, "Peperoni", -700, 10, TipoDeMasa.MEDIA_MASA);

		fabricarEspecial(laPizzeria, "4 Quesos", 800, 20, 0, TamanioDePizza.PERSONAL);
		fabricarEspecial(laPizzeria, "4 Quesos", 800, 15, 2, TamanioDePizza.MEDIANA);
		fabricarEspecial(laPizzeria, null, 800, 15, 2, TamanioDePizza.MEDIANA);
		fabricarEspecial(laPizzeria, "4 Quesos", 800, 15, 4, TamanioDePizza.FAMILIAR);
		fabricarEspecial(laPizzeria, "Super Fugazzeta", 1100, 25, 4, TamanioDePizza.FAMILIAR);
		fabricarEspecial(laPizzeria, "Super Fugazzeta", 00, 25, 4, TamanioDePizza.FAMILIAR);

		fabricarRectangular(laPizzeria, "Canchera", 800, 20, 2, 3, AdicionalQueso.QUESO_SIMPLE);
		fabricarRectangular(laPizzeria, "Canchera", 800, 15, 2, 4, AdicionalQueso.QUESO_DOBLE);
		fabricarRectangular(laPizzeria, "Canchera", 800, 15, -2, 4, AdicionalQueso.QUESO_DOBLE);
		fabricarRectangular(laPizzeria, "Canchera", 800, 15, 2, 5, AdicionalQueso.QUESO_TRIPLE);

		System.out.println("-".repeat(80));
		System.out.println(
				"El precio de la primer pizza '4 Quesos' es ?: " + laPizzeria.precioVentaDeLaPrimerPizza("4 Quesos"));
		System.out.println(
				"Cantidad de Pizzas vendidas entre $1000 y $2000?: " + (laPizzeria.vendidasConPrecioEntre(1000, 2000)));
		System.out.println("La sumatoria de ventas de todas las pizzas 'Canchera' es ?: "
				+ (laPizzeria.sumatoriaDePizzas("Canchera")));

		System.out.println("--------------------------------------------------------------------------------");
		laPizzeria.mostrar();
	}

	private static void fabricarTradicional(Pizzeria laPizzeria, String nombre, float costoBase,
			float porcentajeGanancia, TipoDeMasa tipoDeMasa) {
		//TODO Completar
		Tradicional t = new Tradicional(nombre, costoBase, porcentajeGanancia, tipoDeMasa);
		laPizzeria.fabricar(t);
	}

	private static void fabricarEspecial(Pizzeria laPizzeria, String nombre, float costoBase, float porcentajeGanancia,
			int cantidadFainas, TamanioDePizza tamanioDePizza) {
		Especial e = new Especial (nombre, costoBase, porcentajeGanancia, cantidadFainas, tamanioDePizza);
		laPizzeria.fabricar(e);
	}

	private static void fabricarRectangular(Pizzeria laPizzeria, String nombre, float costoBase,
			float porcentajeGanancia, long largo, long ancho, AdicionalQueso adicionalQueso) {
		//TODO Completar
		Rectangular r = new Rectangular (nombre, costoBase, porcentajeGanancia, largo, ancho, adicionalQueso);
		laPizzeria.fabricar(r);
	}

}
