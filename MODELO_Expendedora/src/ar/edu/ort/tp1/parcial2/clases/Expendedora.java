package ar.edu.ort.tp1.parcial2.clases;

import java.util.ArrayList;

import ort.tp1.tdas.implementaciones.ColaNodos;
import ort.tp1.tdas.interfaces.Cola;

public class Expendedora {

	private final static String MSJ_NOMBRE_INVALIDO = "Nombre Invalido";
	private final static String MSJ_ID_INVALIDO = "ID de producto Invalido";
	private static final String MSJ_ACTUALIZACION_NULA = "La actualizacion no puede ser nula";
	private static final String MSJ_PRODUCTO_NULO = "El producto no puede ser nulo";
	private static final String MSJ_PRODUCTO_REPETIDO = "ID de producto ya existente";
	// TODO Completar estructuras faltantes
	private ListaOrdenadaPorId productosPorId;
	private ListaOrdenadaPorNombre productosPorNombre;
	private Cola<String> erroresDeActualizacion;
	private String nombre;
	private ArrayList<Producto> productos;

	public Expendedora(String nombre) {
		this.setNombre(nombre);
		this.productosPorId = new ListaOrdenadaPorId();
		this.productosPorNombre = new ListaOrdenadaPorNombre();
		this.erroresDeActualizacion = new ColaNodos<String>();
		this.productos = new ArrayList<>();
	}
	
	private void setNombre(String nombre) {
		if(nombre == null) {
			throw new IllegalArgumentException(MSJ_NOMBRE_INVALIDO);
		}
		this.nombre = nombre;
	}
	
	
	public void agregarProducto(Producto p) {
		// TODO
		if(p == null) {
			throw new IllegalArgumentException(MSJ_PRODUCTO_NULO);
		} else {			
			if(obtenerProductoPorId(p.getId()) != null) {
				throw new IllegalArgumentException(MSJ_PRODUCTO_REPETIDO);
			} else {
				this.productos.add(p);
				this.productosPorId.add(p);
				this.productosPorNombre.add(p);
			}
		}
	}

	public void ajustarPrecio(int idProducto, Actualizacion actualizacion) {
		Producto producto = obtenerProductoPorId(idProducto);
		if (producto == null) {
			agregarError(MSJ_ID_INVALIDO, idProducto, actualizacion);
		} else if (actualizacion == null) {
			agregarError(MSJ_ACTUALIZACION_NULA, idProducto, actualizacion);
		} else {
			try {
				producto.aplicarActualizacion(actualizacion);
			} catch (RuntimeException re) {
				agregarError(re.getMessage(), idProducto, actualizacion);
			}
		}
	}
	
	private Producto obtenerProductoPorId(int idProducto) {
		Producto producto = null;
		int pos = 0;
		
		while (pos < this.productos.size() && producto == null) {
			if(this.productos.get(pos).getId() == idProducto) {
				producto = this.productos.get(pos);
			} pos++;
		}
		
		return producto;
	}

	private void agregarError(String mensaje, int idProducto, Actualizacion actualizacion) {
		erroresDeActualizacion.add(String.format("%s - %s - %s", mensaje, idProducto, actualizacion));
	}

	public void mostrarHistoricoActualizaciones() {
		for(Producto p: this.productos) {
			p.listarActualizacionesDePrecio();
		}
		
	}

	public void mostrarErrores() {
		String cent = null;
		String aux;
		this.erroresDeActualizacion.add(cent);
		
		aux = this.erroresDeActualizacion.remove();
		while (aux != cent) {
			System.out.println(this.erroresDeActualizacion.get());
			this.erroresDeActualizacion.add(aux);
			this.erroresDeActualizacion.remove();
		}	}

	// Solo si te toco la lista por nombre
	public void listarProductosPorNombre() {
		for(Producto p: this.productosPorNombre) {
			System.out.println(p.toString());
		}
	}

	// Solo si te toco la lista por ID
	public void listarProductosPorId() {
		for (Producto p: this.productosPorId) {
			System.out.println(p.toString());
		}
	}

}
