public abstract class Dinero {
	//Es abstracta porque no creamos instancias de ella DIRECTAMENTE
	//Superclase de Gasto e Ingreso.
	//Definimos metodos y atributos en comunes en ambas subclases.

	
	  protected double dinero;
	  protected String description;
	  //Getter obtener valor dinero
	  public double getDinero() {
	    return dinero;
	  }
	  //Setter establecer valor dinero
	  public void setDinero(double dinero) {
	    this.dinero = dinero;
	  }
	  //Getter obtener description
	  public String getDescription() {
	    return description;
	  }
	  //Setter establecer description
	  public void setDescription(String description) {
	    this.description = description;
	  }
	}

