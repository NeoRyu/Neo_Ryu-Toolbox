/*	GESTIONNAIRES DE CONVERSION ANDROID
 *
 *	Auteur 		: COUPEZ Fr�d�ric
 *  Date 		: 31 AO�T 2016 
 *	Compatible 	: Tout programme Andro�d
 *
 * Utilit� 		: Permettre de convertir divers type de donn�es.
 * 
 * Il est possible d'ajouter de nouvelles fonctionnalit�es selon vos besoins.
 */

// LIBRAIRIES
//import android.net.ParseException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Shell {	
	
		// aleatoire() : RANDOM (Surcharge de methode + Anti-Cons)
		public static int aleatoire(int max) {
			return (int) Math.floor((Math.random() * (max+1)));
		}	// Random (int) entre 0 et max
		
		public static int aleatoire(int min, int max) {
			int portee = Math.abs(max - min) + 1; 
			return (int)(Math.random() * portee) + (min <= max ? min : max);
		}	// Random (int) entre min et max (avec tri en cas d'inversion min/max)	
		
		public static float aleatoire(float max) {
			return (float) Math.floor((Math.random() * (max+1)));
		}	// Random (float) entre 0 et max
		
		public static float aleatoire(float min, float max) {
		   double portee = Math.abs(max - min);     
		   return (float)(Math.random() * portee) + (min <= max ? min : max);
		}	// Random (float) entre min et max (avec tri en cas d'inversion min/max)
		
		public static double aleatoire(double max) {
			return (double) Math.floor((Math.random() * (max+1)));
		}	// Random (double) entre 0 et max
		
		public static double aleatoire(double min, double max) {
		   double portee = Math.abs(max - min);     
		   return (double)(Math.random() * portee) + (min <= max ? min : max);
		}	// Random (double) entre min et max (avec tri en cas d'inversion min/max)
		 
		
		 
		// ASCII???() : TYPE INT TO CHAR (ASCII)
		// Rappel : 0 a 127 = ASCII / 128 a 255 = ASCII Etendu (UTF-8)
		public static char ASCII(int i) {
			return (char)(i);
		}	// Convertir 0(int) en NUL(char)
		
		public static char ASCIIChiffre(int i) {
			return (char)(i+48);
		}	// Convertir 0(int) en 0(char)	
		
		public static char ASCIILettreMaj(int i) {
			return (char)(i+65);
		} 	// Convertir 0(int) en A(char)
		
		public static char ASCIILettreMin(int i) {
        return (char)(i+97);
    } 	// Convertir 0(int) en a(char)

    public static void checkLetterASCII(char c) {
	System.out.println(c + ((! ( (c>64 && c<91) || (c>96 && c<123)))?" n'est pas" : " est")+" une lettre");

	return (((c>64 && c<91) || (c>96 && c<123)) ? true : false);
    }

    //UNICODE
    public int convertHEX(int entier) {

	return Integer.parseInt(Integer.toHexString(entier), 32);

    }   // Convertir 16(int) en F(hexadecimal)

    public int convertBIN(int entier) {
	return Integer.parseInt(Integer.toBinaryString(entier));

    }
   // Convertir 3(int) en 0011(binaire)

    public List convertUNICODE() {
	List caractere = new ArrayList();
	int max = 16769055;
	for (int i = 0; i < max ; i++) {
		caractere.add(Integer.parseInt(Integer.toHexString(i), 32));
	}

	return caractere;
    }
   // Affichage de la liste (complete/partielle) des caracteres UNICODE

    public int convertUNICODE(int decimal) {
	int caractere = Integer.parseInt(Integer.toHexString(decimal), 32);
	return caractere;
    }

    public int convertUNICODE(int decimal, int base) {
	int caractere = Integer.parseInt(Integer.toHexString(decimal), base);

	return caractere;
    }

	
		
		
		
		// Sysdate() : TYPE DATE TO STRING (Surcharge de methode)
		public static String Sysdate() {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			return dateFormat.format(date);
		}	// Obtenir le timedate actuel en String	
		
		public static String Sysdate(String format) {
			DateFormat dateFormat = new SimpleDateFormat(format);
			Date date = new Date();
			return dateFormat.format(date);
		}	// Obtenir la date actuelle en String sous un format donn� (Exemple "yyyy/MM/dd HH:mm:ss")
		
		public static String Sysdate(Date userdate) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			return dateFormat.format(userdate);
		}	// Obtenir une date en String
		
		public static String Sysdate(String format, Date userdate) {
			DateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.format(userdate);
		}	// Obtenir une date en String sous un format donn� (Exemple "yyyy/MM/dd")
		
		public static String Sysdate(Date userdate, String format) {
			DateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.format(userdate);
		}	// > Identique � la pr�c�dente (juste la signature qui change)
		// Sysdate() : TYPE STRING TO DATE (Surcharge de methode)
    		public static Date Sysdate(String userdate, String format) {
        		SimpleDateFormat dateFormat = new SimpleDateFormat(format);//"yyyy-MM-dd'T'HH:mm:ss'Z'");
        		Date temp = null;   // /!\ Gestion nullException a faire pour l'appel de cette methode !
        		try {
            			Date date = dateFormat.parse(userdate);
            			temp = date;
            			return date;
        		} catch (java.text.ParseException e) {
            			e.printStackTrace();
        		}
        		return temp;
    		}
		
		
		// ConvertStringToBool() : TYPE STRING TO BOOLEAN
		public static boolean ConvertStringToBool(String s) {		
			switch (s.toUpperCase()) {
				// Possible d'ajouter d'autres termes (en majuscule)...
				case "1" :
				case "TRUE":
				case "OUI" :
				case "YES" :			
					return true;
				default:
					return false;
			}
		}	// Convertir un String en Boolean (evite les exceptions en cas de mauvaise saisie)
		 
		
		
		// ConvertStringToStringArray() : TYPE STRING TO STRING[]
		public static String[] ConvertStringToStringArray(String s) {	
			return s.split("");
		}
}
