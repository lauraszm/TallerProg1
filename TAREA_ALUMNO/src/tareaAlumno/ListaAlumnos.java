package tareaAlumno;
import java.util.ArrayList;

public class ListaAlumnos {
	private ArrayList<Alumno> alumnos;
	
	public ListaAlumnos(){
		this.alumnos = new ArrayList<Alumno>();
	}
	
	private Alumno buscarAlumno(String nombre) {
		Alumno alumnoBuscado = null;
		int i = 0;
		
		while (alumnoBuscado == null && i < this.alumnos.size()) {
			if (this.alumnos.get(i).getNombre().equals(nombre)) {
				alumnoBuscado = this.alumnos.get(i);
			} else {				
				i++;
			}
		}
		return alumnoBuscado;
	}
	
	public void insertarNuevoAlumno(String nombre, int edad) {
		if(buscarAlumno(nombre) == null) {			
			Alumno nuevoAlumno = new Alumno (nombre, edad);
			this.alumnos.add(nuevoAlumno);
		}
	}
	
	public void eliminarAlumno(String nombre) {
		Alumno alumnoAEliminar = buscarAlumno(nombre);
		if(alumnoAEliminar != null) {
			this.alumnos.remove(alumnoAEliminar);
		}
	}
	
	public void modificarDatosAlumno (String nombreActual, String nombreNuevo, int edadNueva) {
		Alumno alumnoModificado = this.buscarAlumno(nombreActual);
		if (alumnoModificado != null) {
			alumnoModificado.cambiarDatosAlumno(nombreNuevo, edadNueva);
		}
	}
	
	public void mostrarAlumnos() {
		for(Alumno alumno: this.alumnos) {
			System.out.println(alumno.toString());
		}
	}
}
