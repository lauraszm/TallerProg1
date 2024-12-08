package ar.edu.ort.tp1.pacial1.clases;

import java.util.ArrayList;

public class Pizzeria implements Mostrable {

	private static final String MSG_TOTALES = "La venta total fue: $%8.2f\n";
	private static final String MSG_CANTIDADES = "Se han fabricado: %d Tradicionales, %d Especiales y %d Rectangulares\n";
	private static final String MSG_FABRICANDO = "Fabricando la Pizza: ";
	//TODO A completar
	private ArrayList<Pizza> pizzas;
	private String nombre;
	
	public Pizzeria(String nombre) {
		this.nombre = nombre;
		this.pizzas = new ArrayList<>();
	}
	

	public boolean fabricar(Pizza m) {
		boolean sePudo = false;
		String error = "Error fabricando una pizza ";
		if(m.getNombre() == "" | m.getNombre() == null) {
			System.out.println(error + m.getMensajeErrorNombre());
		} else if (m.getCostoBase() <= 0) {
			System.out.println(error + m.getMensajeErrorCosto());
		} else if (m.getPorcGanancia() <= 0) {
			System.out.println(error + m.getMensajeErrorGanancia());
		} else {
			sePudo = this.pizzas.add(m);
			System.out.println(MSG_FABRICANDO);
			m.mostrar();
		}
		return sePudo;
	}


	/**
	 * Retorna la sumatoria de los precios de Venta de nombre de la pizza enviado por parametro. 
	 * @param nombre
	 * @return
	 */
	public float sumatoriaDePizzas(String nombre) {
		//TODO A completar
		float total = 0;
		
		for(Pizza pizza: this.pizzas) {
			if(pizza.getNombre().equals(nombre)) {
				total += pizza.getPrecioDeVenta();
			}
		}
		return total;
	}
	
	public long sumatoriaDePizzasPorTipo(String tipo) {
		//TODO A completar
		long cant = 0;
		
		for(Pizza pizza: this.pizzas) {
			if(pizza.getTipo().equals(tipo)) {
				cant++;
			}
		}
		return cant;
	}
	
	public float getVentaTotal() {
		float total = 0;
		
		for (Pizza pizza: this.pizzas) {
			total += pizza.getPrecioDeVenta();
		}
		
		return total;
	}
	
	/**
	 * 	Retorna la cantidad de pizzas vendidas con el precio de venta entre los parametros enviados.
	 * 	Los valores enviados son inclusivos.
	 * @param precioInferior
	 * @param precioSuperior
	 * @return
	 */
	
	public int vendidasConPrecioEntre(float precioInferior, float precioSuperior) {
		//TODO A completar
		int 	cantidad = 0;
		
		for (Pizza pizza: this.pizzas) {
			if(pizza.getPrecioDeVenta() >= precioInferior && pizza.getPrecioDeVenta() <= precioSuperior) {
				cantidad++;
			}
		}
		
		return cantidad;
	}
	
	/**
	 * Retorna el precio de venta de la primer pizza enviada por parametro.
	 * En caso de no encontrarse retorna 0.
	 * @param nombre
	 * @return
	 */
	public float precioVentaDeLaPrimerPizza(String nombre) {
		//TODO A completar
		float precio = 0;
		int pos = 0;
		while (pos < this.pizzas.size() && precio == 0) {
			if(this.pizzas.get(pos).getNombre().equals(nombre)) {
				precio = this.pizzas.get(pos).getPrecioDeVenta();
			} pos++;
		}
		return precio;
	}

//resumen que indique su nombre (razón social), la cantidad de pizzas fabricadas de cada tipo 
	//y el importe total de las ventas de las pizzas fabricados.
	

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.println("Pizzeria: " + this.nombre);
		System.out.println(String.format(MSG_CANTIDADES, sumatoriaDePizzasPorTipo("Tradicional"), sumatoriaDePizzasPorTipo("Especial"), sumatoriaDePizzasPorTipo("Rectangular")));
		System.out.println(String.format(MSG_TOTALES, getVentaTotal()));
	}
}
