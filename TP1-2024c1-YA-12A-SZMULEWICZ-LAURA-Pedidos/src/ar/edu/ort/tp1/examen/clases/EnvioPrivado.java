package ar.edu.ort.tp1.examen.clases;

public class EnvioPrivado extends Envio {
	public static final String NOMBRE = "Envio privado";
	public static final int PRECIO_MENOR_100 = 2;
	public static final int PRECIO_MAYOR_100 = 5;
	public static final int LIM_PESO = 100;
	
	public EnvioPrivado() {
		super(NOMBRE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getPrecioEnvio(float peso, float distancia) {
		float precio = 0;
		if(peso <= LIM_PESO) {
			precio = getPrecioBaseKm() * distancia * PRECIO_MENOR_100;
		} else {
			precio = getPrecioBaseKm() * distancia * PRECIO_MAYOR_100;
		}
		return precio;
	}

}
