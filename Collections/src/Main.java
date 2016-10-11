import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		// AFFICHAGE DES OBJETS
		System.out.println("\n> TESTS BASIQUES :\n");
		
		/*// OBJET NULL = ERREUR
		System.out.println("Object obj0 = new Object();");
		Object obj0 = new Object();
		System.out.println(" obj0 = "+obj0.decrisToi());
		*/
		
		System.out.println("Object obj1 = new Object(String);");
		Object obj1 = new Object("une");
		System.out.println(" obj1 = "+obj1.decrisToi());
		
		System.out.println("ChildObject child0 = new ChildObject(String,Integer);");
		ChildObject child0 = new ChildObject("chaine",123456789);
		System.out.println(" child0 = "+child0.decrisToi());
		
		
		// PERMUTATION DANS UN OBJET
		System.out.println("\n> TESTS PERMUTATIONS :\n");
		ArraySort tri = new ArraySort();	// Instanciation de la classe
		
		System.out.print(obj1.getValeur()+" > ");
		String chaine = obj1.getValeur().toString();
		obj1.setValeur(tri.swap(chaine, 0, 1));
		System.out.println(obj1.getValeur()+"\n");
		
		
		// LISTE D'OBJETS
		System.out.println("\n> LISTE D'OBJETS :\n");
		
		//List<ChildObject> chiffres = new ArrayList<ChildObject>();
		
		List<ChildObject> chiffres = new ArrayList<ChildObject>(); 		
		ChildObject chiffre;
		
		for(int i=0;i<=20;i=(i+10))
		{
			chiffre = new ChildObject(Integer.toString(i),i);
			chiffres.add(chiffre);
			System.out.print(" > "+chiffre.toString());
		}
		for(int i=1;i<10;i++)
		{
			chiffre = new ChildObject(Integer.toString(i),i);
			chiffres.add(chiffre);
			System.out.print(" > "+chiffre.toString());
		}
		
		// TRI DANS UNE LISTE D'OBJETS
		System.out.println("\n\n\n> TRI DANS UNE LISTE DE "+chiffres.size()+" OBJETS :\n");
		
		//tri
		chiffres = tri.triBullesD(chiffres, 1, chiffres.size(), '<');
		
		//verif
		try {
			for(int i=0;i<chiffres.size();i++)
			{			
				System.out.print(" > "+chiffres.get(i).toString());
			}
		} catch (ClassCastException e) {
			System.out.print(" ERREUR ! ");
		}
		
		
		
		// comparaison de collection (string)
		Collections.sort(chiffres, new Comparator<ChildObject>() {
			@Override
			public int compare(ChildObject obj1, ChildObject obj2) {
				return  obj1.getData().toString().compareTo(obj2.getData().toString());
			}
		});
		System.out.println("\n------------\n");
		System.out.println(chiffres);
		
		// LOL : Pimp my List ! :D
		System.out.println("\n\n\n> TRI DANS UNE LISTE DE "+chiffres.size()+" CARACTERES :\n");
		List<ChildObject> charas = new ArrayList<ChildObject>(); 
		List<ChildObject> temp = new ArrayList<ChildObject>(); 
		ChildObject chara;		
		for(int i=65;i<=90;i++)
		{
			chara = new ChildObject(Integer.toString(i),(char) i);
			temp.add(chara);
		}
		System.out.println("\n"+temp);			
		Random trololo = new Random();
		int lol = 0;
		for (int i = 0 ; i < temp.size() ; i++) {
			while(lol == i) {
				lol = trololo.nextInt(89-66);
			}			

			tri.swap(temp, i, lol);	
		}
		charas = temp;
		System.out.println("\n"+charas);
		
		charas = tri.triBullesD(charas, 1, charas.size(), '<');
		
	}	
}