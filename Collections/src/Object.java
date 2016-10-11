// G�N�RICIT� SUR UN OBJECT (GENERALISATION)
public class Object<T> {	
	  //Variable d'instance
	  private T valeur;
	        
	  // Constructeur par d�faut
	  public Object(){
	    this.valeur = null;
	  }
	
	// Surcharge du constructeur avec type de param�tre inconnu pour l'instant (polymorphique)
	  public Object(T val){
	  	this.valeur = val;
	  }
	      
	  // (GETTER) Accesseur : Pour retourner la valeur d�j� � cast�e � par la signature de la m�thode
	  public T getValeur(){
	    return this.valeur;
	  }  
	  // (SETTER) Mutateur : Pour d�finir la valeur avec le param�tre val
	  public void setValeur(T val){
	    this.valeur = val;
	  }
	        
	  // Methode de la classe
	  public String decrisToi(){
			return "valeur : "+this.valeur.toString()+"\n";
	  }
	  
	// Methode de la classe
	  public String toString(){
			return this.valeur.toString();
	  }
}


// HERITAGE POLYMORPHIQUE (SPECIALISATION)
class ChildObject<T> extends Object<T> { //T : java.lang.Object
	//Variable d'instance
	private T data;

	// GET / SET
	public T getData() {
		return data;
	}
	public void setData(T donnee) {
		this.data = donnee;
	}
	
	// Constructeur avec appel de la classe mere + passage de parametre
	public ChildObject(T value, T donnee){
		super(value);	// Ne reinstancie pas la classe m�re (on garde le m�me objet)
		this.data = donnee;
	}
	
	// Red�finition de la m�thode de la classe m�re dans la classe d�riv�e
	public String decrisToi()
	{
		return super.decrisToi() +" data : "+this.data.toString()+"\n";
	}
	
	// Methode de la classe
		  public String toString(){
				return this.data.toString();
		  }

}