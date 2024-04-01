package clubSocios;

public class Test {

	public static void main(String[] args) {
		
		Socio unSocio1 = new Socio ("Laura S", new Fecha(18,03,2000), "Calle 1234", "1161234567", TipoSocio.VITALICIO);
		Socio unSocio2 = new Socio ("Nombre Apellido", new Fecha(17,03,2024), "Calle 4567", "1159876543", TipoSocio.TRADICIONAL);
		Socio unSocio3 = new Socio ("Apellido Nombre", new Fecha(18,03,2024), "Calle 7890", "1145671234", TipoSocio.VIP);
		Socio unSocio4 = new Socio ("Apellido Nombre2", new Fecha(18,03,2024), "Calle 7890", "1145671234", TipoSocio.VITALICIO);

		CasaClub unClub = new CasaClub();
		
		unClub.AgregarSocio(unSocio1);
		unClub.AgregarSocio(unSocio2);
		unClub.AgregarSocio(unSocio3);
		unClub.AgregarSocio(unSocio4);

		
		unClub.ListarSocios();
		unClub.mostrarVitalicios();
		unClub.eliminarSocio(4);
		
		System.out.println("*****ELIMINADO UN SOCIO*****");
		unClub.ListarSocios();
		unClub.mostrarVitalicios();
		
	}

}
