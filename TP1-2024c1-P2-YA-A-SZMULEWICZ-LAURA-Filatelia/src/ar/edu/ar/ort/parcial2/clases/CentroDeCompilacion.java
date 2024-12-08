package ar.edu.ar.ort.parcial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Pila;

public class CentroDeCompilacion implements Visualizable{
	private static final int MIN_VALOR_CRITICO = 25;
	private static final int MAX_VALOR_CRITICO = 35;
	private ListaOrdenadaPorValor listaPorValorComercial;
	private int[] cantSellosPorImp;
	private Pila<Venta> ventas;
	private double[][] totalRecaudado;
	
	public CentroDeCompilacion() {
		this.listaPorValorComercial = new ListaOrdenadaPorValor();
		this.cantSellosPorImp = new int[Impresion.values().length];
		this.ventas = new PilaNodos<Venta>();
		this.totalRecaudado = new double[Impresion.values().length][Formato.values().length];
	}
	
	public void agregarSellos(Sello s) {
		this.listaPorValorComercial.add(s);
		this.cantSellosPorImp[s.getTipoImpresion().ordinal()]++;
	}
	
	private Sello buscarPorPie(String pie) {
		Sello selloBuscado = null;
		
		for(Sello s: this.listaPorValorComercial) {
			if(s.getPie().equals(pie)) {
				selloBuscado = s;
			}
		}
		return selloBuscado;
	}
	
	public void realizarVentaSello(String pie, int cred, String contacto) {
		Sello s = buscarPorPie(pie);
		if(s == null) {
			throw new IllegalArgumentException(Visualizable.ERROR_SELLO);
		} else {
			this.ventas.push(new Venta(s, cred, contacto));
			this.totalRecaudado[s.getTipoImpresion().ordinal()][s.getTipoFormato().ordinal()]+= s.getValorComercial();
			this.listaPorValorComercial.remove(s);
		}
	}
	
	private float calcularRecaudacion(double [][] ventas) {
		float suma = 0;
		
		for(int i = 0; i < ventas.length; i++) {
			for (int j = 0; j < ventas[i].length; j++) {
				suma += ventas[i][j];
			}
		}
		
		return suma;
		
	}
	
	private String verificarRecaudacion(double recaudacion) {
		
		String mensaje = "";
		RangoNumeros rango = new RangoNumeros(MIN_VALOR_CRITICO, MAX_VALOR_CRITICO);
		if(rango.incluye((float) recaudacion)) {
			mensaje = Visualizable.MSG_VENTAS_CRITICAS;
		}
		
		return mensaje;
	}

	public void actualizarVendidosPorTipo() {
		for (int i = 0; i < this.cantSellosPorImp.length; i++) {
			this.cantSellosPorImp[i] = 0;
		}
		
		Pila<Venta> aux = new PilaNodos<Venta>();
		while(!this.ventas.isEmpty()) {
			Venta v = this.ventas.pop();
			aux.push(v);
			this.cantSellosPorImp[v.getSello().getTipoImpresion().ordinal()]++;
		}
		while(!aux.isEmpty()) {
			this.ventas.push(aux.pop());
		}
	}
	
	
	@Override
	public void verDatos() {
		System.out.println("SELLOS SIN VENDER");
		System.out.println("----------------");
		for(Sello s: this.listaPorValorComercial) {
			s.verDatos();
		}
		System.out.println("----------------");
		System.out.println("VENTAS EFECTUADAS CON EXITO");
		System.out.println("----------------");
		
		Pila<Venta> aux = new PilaNodos<Venta>();
		while(!this.ventas.isEmpty()) {
			Venta v = this.ventas.pop();
			aux.push(v);
			v.verDatos();
		}
		while(!aux.isEmpty()) {
			this.ventas.push(aux.pop());
		}
		System.out.println("----------------");
		System.out.println(String.format(MSG_TIPO_IMPRESION, this.cantSellosPorImp[0], this.cantSellosPorImp[1], this.cantSellosPorImp[2],this.cantSellosPorImp[3],this.cantSellosPorImp[4]));
		System.out.println("----------------");
		System.out.println(String.format(Visualizable.MSG_RECAUDACION_TOTAL, calcularRecaudacion(this.totalRecaudado)));
		System.out.println("----------------");
		System.out.println(verificarRecaudacion(calcularRecaudacion(this.totalRecaudado)));
	}
}
	

