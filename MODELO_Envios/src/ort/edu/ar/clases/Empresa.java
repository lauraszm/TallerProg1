package ort.edu.ar.clases;

public class Empresa implements Detallable{
	private final static int MAX_PAQ_POR_CAMION = 3;
	private final static String MSG_MAX_CAMIONES = "NO PUEDES AGREGAR MAS CAMIONES";
	private final static String MSG_CAMIONES_LLENOS = "TODOS LOS CAMIONES ESTAN LLENOS. NO PUEDE AGREGAR PAQUETES";
	private String nombre;
	private String[][] paquetesDirecciones;
	private Camion[] camiones;
	private ListaOrdenadaPaquetePrecio listaPaquetePrecio;
	
	public Empresa(String nombre, int cantCamiones) {
		this.nombre = nombre;
		this.paquetesDirecciones = new String[cantCamiones][MAX_PAQ_POR_CAMION];
		this.camiones = new Camion[cantCamiones];
		this.listaPaquetePrecio = new ListaOrdenadaPaquetePrecio();
	}

	public void agregarCamion(String patente) {
		boolean encontrado = false;
		int pos = 0;
		while(pos < camiones.length && encontrado == false) {
			if(this.camiones[pos]== null) {
				encontrado = true;
			} else if(this.camiones[pos].getPatente().equals(patente)) {
				throw new IllegalArgumentException("El camion con patente " + patente  + "ya esta en uso");
			} else {				
				pos++;
			}
		}
		if(!encontrado) {
			throw new IllegalArgumentException(MSG_MAX_CAMIONES);
		} else {
			this.camiones[pos] = new Camion(patente);
		}
	}

	public void agregarPaquete(Paquete paquete) {
		boolean encontrado = false;
		int contCamiones = 0;
		int contDirecciones = 0;
		
		while(contCamiones < this.paquetesDirecciones.length && encontrado == false) {
			contDirecciones = 0;
			while(contDirecciones < this.paquetesDirecciones[contCamiones].length && encontrado == false) {
				if(this.paquetesDirecciones[contCamiones][contDirecciones] == null) {
					encontrado = true;
				} 					
				contDirecciones++;
			}
			contCamiones++;
		}
		if(encontrado == false) {
			throw new IllegalArgumentException(MSG_CAMIONES_LLENOS);
		} else {
			this.paquetesDirecciones[contCamiones-1][contDirecciones-1] = paquete.getDestino();
			this.camiones[contCamiones-1].agregarPaquete(paquete);
			this.listaPaquetePrecio.add(paquete);
		}
	}

	public void verPaquetes() {
		System.out.println("Detalle de paquetes a enviar:\n");
		for(Paquete paq: this.listaPaquetePrecio) {
			paq.verDetalle();
		}
	}

	public void camionMayorGanancias() {
		Camion camionMaxGanancia = null;
		double maxGanancia = 0;
		for(Camion c:this.camiones) {
			if(c != null) {				
				if(c.verTotal() > maxGanancia) {
					maxGanancia = c.verTotal();
					camionMaxGanancia = c;
				}
			}
		}
		System.out.println("Ver camion mayor ganancias\n");
		for(Camion c: this.camiones) {
			c.verDetalle();
		}
		System.out.println("El camión con más ganancias es el de patente:" + camionMaxGanancia.getPatente() + ", con $" + camionMaxGanancia.verTotal());
		
	}

	@Override
	public void verDetalle() {
		// TODO Auto-generated method stub

		this.verPaquetes();
		this.camionMayorGanancias();
		
	}

}
