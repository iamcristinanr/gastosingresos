import java.util.Scanner;

public class Main {
	//Variable para leer las respuestas
	private static Scanner respuestas = new Scanner(System.in);
	

	
	//Declaramos la variable con valor vacío, debe tenemos valor aunque sea vacío de otro modo sería nulo
	private static String opcion="";
	
	// Declaramos la misma variable pero para el valor númerico
	// Con valor -1(fuera del rango while), Para que al saltar la excepcion (Ej: el usuario introduzca un parámetro que no pueda pasar a int)
	// Vuelva a iniciar el while.
	private static int opcionUsuario=-1;
	
	//USUARIO
	//Variable para almacenar los objetos de tipo Usuario:
	private static Usuario nuevoUsuario = new Usuario();
	//Variable para el nombre de Usuario
	private static String nombreUsuario = "";
	//EdadUser en formato string
	private static String edadUser = "";
	//EdadUsuario =edadUser formato int
	private static int edadUsuario = 0;
	//Variable para introducir el dni
	private static String dniUser = "";
	
	//Variable para comprobar el dni
	private static boolean dniCorrecto = false;
	//Variable para comprobar que el usuario se ha creado correctamente
	
	
	//CUENTA
	//Variable que almacena objetos(llamados nuevaCuenta) de tipo Cuenta.
	private static Cuenta nuevaCuenta = null;
	
	private static String description="";
	
	//Variable donde almacenaremos el importe introducido por el usuario.
	private static String importe = "";
	//Variable para almacenar el importe transformado en double
	private static double importeMovimiento = 0;
	
	 //METODO PARA MOSTRAR MENU
	 private static void Menu() {
	      do { 	
	    	      System.out.println("Por favor, elige una de las siguientes opciones:");   
			      System.out.println("1. Introduce un nuevo gasto");
			      System.out.println("2. Introduce un nuevo ingreso");
			      System.out.println("3. Mostrar gastos");
			      System.out.println("4. Mostrar ingresos");
			      System.out.println("5. Mostrar saldo");
			      System.out.println("0. Salir");


				  opcion = respuestas.nextLine();
				  // Creamos excepcion
				  try {
					  //Intentamos pasar el valor que introduce el usuario (siempre será string) a un número entero.
					  opcionUsuario = Integer.parseInt(opcion);
					  //si no puede, le mostrará el siguiente mensaje
				  } catch (Exception e) {
						 System.out.println("Debes introducir un número ");	
				  }
				  
				  //Validamos que es una de las opciones que le damos a elegir
				  if (opcionUsuario<0 || opcionUsuario>5) {
					 System.out.println("Opción no válida. ");	
				  }
				  //y volvemos a mostrar el menú, opcionUsuario esta inicializada en -1 para que repita la accion.
			    } while (opcion.isEmpty() || opcionUsuario<0 || opcionUsuario>5);
			    
		  }
	
	
	// MÉTODO PARA INTRODUCIR LOS DATOS DEL USUARIO
	private static boolean introducirDatosUsuario() {
		
		//NOMBRE
		do {
			System.out.print("Nombre: ");
			nombreUsuario=respuestas.nextLine();
			//Pasamos el nombre de usuario a mayúsculas
			nombreUsuario = nombreUsuario.toUpperCase();
			//Repetimos la acción hasta el usuario inserte un nombre                            
		} while(nombreUsuario.isEmpty());
		
		//EDAD
		do {
			System.out.print("Edad: ");
			edadUser=respuestas.nextLine();
			
			//Intentamos pasar la edad a número, si no deja es un carácter no númerico y pedirá al usuario introducir un número
			try {
				edadUsuario = Integer.parseInt(edadUser);
			}catch(Exception e) {
				System.out.print("Debes introducir un número: ");
			}
			//Repetimos mientras esté vacío o sea menor o igual que cero
		}while(edadUser.isEmpty() || edadUsuario<=0);
		
		
		//DNI
		do {
			System.out.print("DNI: ");
			dniUser=respuestas.nextLine();
			//Llamamos al metodo set creado en la clase Usuario que comprueba el DNI, inicializado en False
			if (nuevoUsuario.setDNI(dniUser)==false) {
				//Si no es conforme se ha diseñado la expresión regular pedirá introducir el valor de nuevo
				dniCorrecto=false;
				System.out.print("EL DNI introducido no es válido, los primeros 8 caracteres deben ser númericos seguidos de una letra en mayúscula. ");
			}//Si todo es correcto dniCorrecto cambiará a true.
			else {
				dniCorrecto=true;
				
			}
		//Se repetirá hasta que deje de estar vacío o no pase la expresión regular creada en clase Usuario
		}while (dniUser.isEmpty()||dniCorrecto==false);
		
		System.out.println("Usuario registrado correctamente");
		
		nuevoUsuario.setNombre(nombreUsuario);
		nuevoUsuario.setEdad(edadUsuario);
		return true;
	}
	
	
	//METODO PARA INTRODUCIR LOS INGRESOS
	private static void introducirIngresos() {
		
		//Pedimos la descripcion del ingreso hasta que deje de estar vacía.
		do {
			System.out.println("Introduce la descripcion del ingreso: ");
			description = respuestas.nextLine();
		}while(description.isEmpty());
		
		
		//Pedimos el importe al usuario
		do {
			System.out.println("Introduce el importe: ");
			importe = respuestas.nextLine();
			
			//El usuario introduce un string, intentaremos pasarlo a double
			try {
				importeMovimiento=Double.parseDouble(importe);
			//Si no puede pasarlo saltará la excepcion.
			}catch(Exception e) {
				System.out.print("Debes introducir un valor númerico para el importe del ingreso");	
			}
			
		 //Repetiremos hasta que deje de estar vacío o el importe sea 0 o menor.
		}while(importe.isEmpty() || importeMovimiento<=0);
		
		
		//Agregamos el ingreso a la cuenta
		nuevaCuenta.addIngresos(description, importeMovimiento);
		System.out.println("Ingreso registrado correctamente");
	}
	
	//MÉTODO PARA INTRODUCIR GASTOS
	private static void introducirGastos() {
		//Pedimos el importe al usuario
		do {
			System.out.println("Introduce la descripcion del gasto: ");
			description = respuestas.nextLine();
		//Se repetirá mientras esté vacío.
		}while(description.isEmpty());
		
		do {
			System.out.println("Introduce el importe: ");
			importe = respuestas.nextLine();
			
			//El usuario introduce un string, intentaremos pasarlo a double
			try {
				importeMovimiento=Double.parseDouble(importe);
			//Si no puede pasarlo saltará la excepcion.
			}catch(Exception e) {
				System.out.print("Debes introducir un valor númerico para el importe del gasto");
			}
			 //Repetiremos hasta que deje de estar vacío o el importe sea 0 o menor.	
			}while(importe.isEmpty());
			
			//Comprobaremos que tenemos saldo en la cuenta para poder ingresar el gasto
			//Si el saldo de la cuenta es menor al movimiento o si el saldo es 0 informará al usuario.
			if(nuevaCuenta.getSaldo()<importeMovimiento || nuevaCuenta.getSaldo()==0){
				System.out.print("Crédito insuficiente. Ingresa dinero para realizar el pago .");
				
			}
			else {
		         //De otro modo se agregará el gasto a la cuenta
	            nuevaCuenta.addGastos(description, importeMovimiento);

	            // Informamos al usuario que se ha registrado el gasto.
	            System.out.println("Gasto registrado correctamente."); 

			}
	}

	
	//METODO PARA MOSTRAR TODOS LOS INGRESOS REALIZADOS
	private static void mostrarListaIngresos() {
		//Si no ha habido ningun ingreso:
		if(nuevaCuenta.getIngresos().isEmpty()) {
			System.out.println("No ha habido ningún ingreso en su cuenta");	
		}
		//Si ha habido ingreso, recorrerá la lista ingresos
		else {
			for (int x=0;x<nuevaCuenta.getIngresos().size();x++) {
				System.out.println(nuevaCuenta.getIngresos().get(x).toString().replace('.', ',')); //Reemplazamos . por ,
			}
		}
	}
	
	
	//METODO PARA MOSTRAR LA LISTA DE GASTOS REALIZADOS
	private static void mostrarListaGastos() {
		//Si está vacía.
		if(nuevaCuenta.getGastos().isEmpty()) {
			System.out.println("No ha habido ningún gasto en su cuenta");	
		}//En caso contrario, se mostrará la lista de gastos
		else {
			for(int x=0;x<nuevaCuenta.getGastos().size();x++) {
				System.out.println(nuevaCuenta.getGastos().get(x).toString().replace('.', ','));
		}
	
	}
}
//MAIN	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//Comprobamos que los datos del usuario son correctos para crear la cuenta
			if (introducirDatosUsuario()==true ) {
				
				nuevaCuenta = new Cuenta(nuevoUsuario);
				
				//Cuando la cuenta esté creada enseñamos al usuario las opciones a elegir.
				
				do {
					Menu();
				
				
				    switch (opcionUsuario) {
			        case 1:
			          System.out.println("Has elegido opción 1. Introducir un nuevo gasto.");
			          introducirGastos();
			          break;
			        case 2:
			          System.out.println("Has elegido opción 2. Introducir un nuevo ingreso.");
			          introducirIngresos();
			          break;
			        case 3:
			          System.out.println("Has elegido opción 3. Mostrar gastos.");
			          mostrarListaGastos();
			          break;
			        case 4:
			          System.out.println("Has elegido opción 4. Mostrar ingresos.");
			          mostrarListaIngresos();
			          break;
			        case 5:
			          System.out.println("Has elegido opción 5. Mostrar saldo. " + "\n" + nuevaCuenta.toString().replace('.', ','));

			          break;
			        case 0:
			          System.out.println("Fin del programa.");
			          System.out.println("Gracias por utilizar la aplicación de M03B en el curso 2s2223.");
			          break;
			        /*default:
			          System.out.println("Please select a correct answer");*/
			        
				    }
				    //Cuando el usuario elija 0 sale del programa. En caso contrario siempre se mostrará
			      }while(opcionUsuario !=0);	
			}
	    
	}

		}
