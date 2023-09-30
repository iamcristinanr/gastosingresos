//Hereda de la superclase dinero
public class Ingreso extends Dinero {
	//Método constructor
	public Ingreso(double ingreso, String description) {
		this.dinero=ingreso;
		this.description=description;
	}		
	//Método para mostrar los datos del ingreso. Opcion 4 del Menu
	public String toString() {
			return "Descripción del Ingreso: " + this.description + "\n" + "Importe del Ingreso: " + this.dinero;
	}

}
