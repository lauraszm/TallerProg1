package tareaAlumno;

public class Alumno {
	private String nombre;
	private int edad;
	
	public Alumno(String nombre, int edad) {
		this.setNombre(nombre);
		this.setEdad(edad);
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	public void cambiarDatosAlumno(String nombre, int edad) {
		this.setNombre(nombre);
		this.setEdad(edad);
	}
	
}

