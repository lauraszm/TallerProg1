package tareaAlumno;

public class Test {

	public static void main(String[] args) {
		
		ListaAlumnos unaLista = new ListaAlumnos();
		
		unaLista.insertarNuevoAlumno("Laura S", 37);
		unaLista.insertarNuevoAlumno("Pepe P", 35);
		unaLista.insertarNuevoAlumno("Jose S", 25);
		
		unaLista.mostrarAlumnos();
		
		unaLista.eliminarAlumno("Jose S");
		System.out.println("****** BORRADO ******");
		unaLista.mostrarAlumnos();
		
		unaLista.modificarDatosAlumno("Laura S", "Laura L", 38);
		System.out.println("****** CAMBIADO ******");
		unaLista.mostrarAlumnos();

	}

}
