
public class Usuario {
	// declaro las variables de la clase usuario
	  private String nombre;
	  private int edad;
	  private String DNI;

	  //Método constructor
	  public Usuario() {
		  this.nombre="";
		  this.edad=0;
		  this.DNI=null;	    
      }
	  //Método getter devuelven un valor.
	  public String getNombre() {
	  	return nombre;
	  }
	  //Método setter establece un valor
	  public void setNombre(String nombre) {
	  	this.nombre = nombre;
	  }
	  public int getEdad() {
	  	return edad;
	  }
	  public void setEdad(int edad) {
	  	this.edad = edad;
	  }
	  public String getDNI() {
	  	return DNI;
	  }

	  
	  //Método setter porque establece un valor y tambien comprueba si es valor es valido
	  //Comprobamos si el DNI añadido es correcto mediante dos expresiones regulares
	  public Boolean setDNI(String DNI) {
		  if(DNI.matches("^[0-9]{8}[-]?[A-Z]$")){
			 this.DNI=DNI;
			 return true;
	  		}
		  else {
			  return false;
		  }
	  }
	    //Método para devolver los datos del usuario.
	  public String toString() {
	    return "Nombre: " + this.nombre +"\n" + "Edad: " + this.edad + "\n" + "DNI : " + this.DNI;
	    		
	  }
}
