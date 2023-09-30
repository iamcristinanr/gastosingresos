//Hereda de la superclase Dinero
public class Gasto extends Dinero {
	//Método constructor que recibe gasto y descripcion
	public Gasto(double gasto, String description) {
		this.dinero=gasto;
		this.description=description;
		
	}
	//Método que saca por pantalla la descripción y el importe del gasto. Opcion 3 del
	public String toString() {
		return "Descripción del gasto: " + this.description + "\n" + "Importe del gasto: " + this.dinero;
	}
}
