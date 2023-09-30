
import java.util.List;
import java.util.ArrayList;

public class Cuenta {
	//Variables de la clase cuenta
	private double saldo;
	private Usuario usuario;
	private List<Gasto> gastos; //Lista que almacena objeto de tipo Gasto llamada gastos
	private List<Ingreso> ingresos; //Lista que almacena objeto de tipo Ingreso llamada ingresos
	

	//Método constructor
	public Cuenta(Usuario usuario) {
		this.saldo = 0;
		this.usuario=usuario;
		this.ingresos=new ArrayList<Ingreso>();
		this.gastos=new ArrayList<Gasto>();
		
	}
	//setters y getters
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	public List<Gasto> getGastos() {
		return gastos;
	}


	public List<Ingreso> getIngresos() {
		return ingresos;
	}

	// Metodo para añadir un nuevo ingreso a la lista ingresos
	public double addIngresos(String description, double cantidad) {
		//Se crea el nuevo ingreso pasandole cantidad y descripcion
		Ingreso nuevoIngreso = new Ingreso(cantidad, description);
		//Agrega el ingreso a la lista
		this.ingresos.add(nuevoIngreso);
		//Sumamos el ingreso a la cantidad total de la cuenta
		this.saldo=this.saldo + cantidad;
		return saldo;
		
	}
	// Metodo para añadir un nuevo ingreso a la lista gastos
	public double addGastos(String description, double cantidad) {
		//Intentamos introducir el gasto
		try {
			//Si el saldo es menor que la cantidad que añadimos, no dejará hacer el movimiento y saltará la excepcion
			if(this.getSaldo()<cantidad) {
				throw new GastoException();		
			}
			//Si tiene crédido para los gastos el programa puede añadirlo.
			//Se resta la cantidad al saldo total
			this.saldo-=cantidad;
			Gasto nuevoGasto = new Gasto(cantidad, description);
			//Añadimos el gasto a la lista
			this.gastos.add(nuevoGasto);
			
		}catch(GastoException ex) {
			return -1;
		//Salta la excepción pero el programa continúa.
		}
		
		return this.saldo;
	}
	
	//Metodo para obtener la informacion de la cuenta. Opcion 5.
	public String toString () {
		return "Hola " + usuario.getNombre () + " el saldo de tu cuenta es: " + this.saldo;
	}
	

}
