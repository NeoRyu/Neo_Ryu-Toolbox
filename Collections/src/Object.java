// GÉNÉRICITÉ SUR UN OBJECT (GENERALISATION)
public class Object<T> {	
	  //Variable d'instance
	  private T valeur;
	        
	  // Constructeur par défaut
	  public Object(){
	    this.valeur = null;
	  }
	
	// Surcharge du constructeur avec type de paramètre inconnu pour l'instant (polymorphique)
	  public Object(T val){
	  	this.valeur = val;
	  }
	      
	  // (GETTER) Accesseur : Pour retourner la valeur déjà « castée » par la signature de la méthode
	  public T getValeur(){
	    return this.valeur;
	  }  
	  // (SETTER) Mutateur : Pour définir la valeur avec le paramètre val
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
		super(value);	// Ne reinstancie pas la classe mère (on garde le même objet)
		this.data = donnee;
	}
	
	// Redéfinition de la méthode de la classe mère dans la classe dérivée
	public String decrisToi()
	{
		return super.decrisToi() +" data : "+this.data.toString()+"\n";
	}
	
	// Methode de la classe
		  public String toString(){
				return this.data.toString();
		  }

}