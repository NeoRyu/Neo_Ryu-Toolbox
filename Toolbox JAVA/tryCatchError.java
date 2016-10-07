/*	GESTIONNAIRES D'EXCEPTIONS
	 *	Auteur 		: COUPEZ Frédéric
	 *  Date 		: 31 AOÛT 2016 
	 *	Compatible 	: Tout programme Androïd
	 *
	 * Utilité 		: Permettre de gérer chaque exception de manière plus simple :
	 * 		(public static) tryCatchErrorAndroid Error = new tryCatchErrorAndroid();
	 * 		try { }(catch (typeexception e) { Error.gestionException(e); }
	 * 
	 * Il est possible de l'améliorer (ajout d'autres exceptions) ou de la modifier (toast/log) selon vos besoins
	 */

import javax.swing.JOptionPane;
import javax.naming.AuthenticationException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class tryCatchError {

		/* // Diverses Exceptions :
		AclNotFoundException, ActivationException, AlreadyBoundException, ApplicationException, AWTException, 
		BackingStoreException, BadAttributeValueExpException, BadBinaryOpValueExpException, BadLocationException, 
		BadStringOperationException, BrokenBarrierException, CertificateException, CloneNotSupportedException, 
		DataFormatException, DatatypeConfigurationException, DestroyFailedException, ExecutionException, ExpandVetoException,
		FontFormatException, GeneralSecurityException, GSSException, IllegalClassFormatException, InterruptedException, 
		IntrospectionException, InvalidApplicationException, InvalidMidiDataException, InvalidPreferencesFormatException, 
		InvalidTargetObjectTypeException, IOException, JAXBException, JMException, KeySelectorException, LastOwnerException, 
		LineUnavailableException, MarshalException, MidiUnavailableException, MimeTypeParseException, MimeTypeParseException, 
		NamingException, NoninvertibleTransformException, NotBoundException, NotOwnerException, ParseException, 
		ParserConfigurationException, PrinterException, PrintException, PrivilegedActionException, PropertyVetoException, 
		ReflectiveOperationException, RefreshFailedException, RemarshalException, RuntimeException, SAXException, ScriptException, 
		ServerNotActiveException, SOAPException, SQLException, TimeoutException, TooManyListenersException, TransformerException, 
		TransformException, UnmodifiableClassException, UnsupportedAudioFileException, UnsupportedCallbackException, 
		UnsupportedFlavorException, UnsupportedLookAndFeelException, URIReferenceException, URISyntaxException, UserException, 
		XAException, XMLParseException, XMLSignatureException, XMLStreamException, XPathException
		*/
		
	public void gestionException(AuthenticationException e){
		JOptionPane.showInternalMessageDialog(null, e.toString(), "Exception", JOptionPane.ERROR_MESSAGE);
        System.out.println("AuthenticationException : "+e.toString());
    }	// Exceptions liées à un objet d'authentification étant invalide pour une raison quelconque.
	
    public void gestionException(ClassNotFoundException e){
        JOptionPane.showInternalMessageDialog(null, e.toString(), "Exception", JOptionPane.ERROR_MESSAGE);
        System.out.println("ClassNotFoundException : "+e.toString());
    }	// getException() : Exception soulevée si une erreur est survenue lors de la tentative de charger une classe 
	
    /*
	public void gestionException(ClientProtocolException e){
        JOptionPane.showInternalMessageDialog(null, e.toString(), "Exception", JOptionPane.ERROR_MESSAGE);
        System.out.println("ClientProtocolException : "+e.toString());
    }	// Signale une erreur dans le protocole HTTP.
	*/
	public void gestionException(EOFException  e){
        JOptionPane.showInternalMessageDialog(null, e.toString(), "Exception", JOptionPane.ERROR_MESSAGE);
        System.out.println("EOFException  : "+e.toString());
    }	// Signale une fin innatendue de fichier ou de flux.
	
	public void gestionException(Exception e){
        JOptionPane.showInternalMessageDialog(null, e.toString(), "Exception", JOptionPane.ERROR_MESSAGE);
        System.out.println("Exception : "+e.toString());
    }	// Levée lorsqu'une tentative de récupérer le résultat d'une tâche échoue...
	
	public void gestionException(FileNotFoundException  e){
        JOptionPane.showInternalMessageDialog(null, e.toString(), "Exception", JOptionPane.ERROR_MESSAGE);
        System.out.println("FileNotFoundException  : "+e.toString());
    }	// Echec lors de la tentative d'ouvrerture d'une fichier désigné par un chemin d'accès spécifié.
	
    public void gestionException(IllegalAccessException e){
        JOptionPane.showInternalMessageDialog(null, e.toString(), "Exception", JOptionPane.ERROR_MESSAGE);
        System.out.println("IllegalAccessException : "+e.toString());
    }	// Lancée lorsqu'une application tente de créer reflexivement une instance (autre qu'un tableau), 
		// définir ou obtenir un champ, ou invoquer une méthode ; mais que la méthode en cours d'exécution 
		// n'a pas accès à la définition de la classe, au champ spécifié, à la méthode ou au constructeur.
	
	public void gestionException(IllegalArgumentException e) {
		JOptionPane.showInternalMessageDialog(null, e.toString(), "Exception", JOptionPane.ERROR_MESSAGE);
        System.out.println("IllegalArgumentException : "+e.toString());
	}	// Levée lorsque qu'une méthode a reçue un argument illégal ou inapproprié.
	
	public void gestionException(IllegalStateException e) {
		JOptionPane.showInternalMessageDialog(null, e.toString(), "Exception", JOptionPane.ERROR_MESSAGE);
        System.out.println("IllegalStateException : "+e.toString());
	}	// L'environnement Java ou l'application Java ne sont pas dans un etat approprie pour l'opération demandée.
	
	public void gestionException(IndexOutOfBoundsException e) {
		JOptionPane.showInternalMessageDialog(null, e.toString(), "Exception", JOptionPane.ERROR_MESSAGE);
        System.out.println("IndexOutOfBoundsException : "+e.toString());
	}	// L'indice est hors de portée (par exemple for(int i = 0;  ; i++))
	 	
	public void gestionException(InstantiationException e){
        JOptionPane.showInternalMessageDialog(null, e.toString(), "Exception", JOptionPane.ERROR_MESSAGE);
        System.out.println("InstantiationException : "+e.toString());
    }	// Levée lorsqu'une instanciation echoue (diverses raisons possibles...)
		// Exemples : la classe n'a pas de constructeur, l'objet de classe représente une
		// classe abstraite, une interface, une classe de tableau, un type primitif, null, ... 
	
	public void gestionException(IOException e){
        JOptionPane.showInternalMessageDialog(null, e.toString(), "Exception", JOptionPane.ERROR_MESSAGE);
        System.out.println("IOException : "+e.toString());
    }	// Un flux en entrée/sortie (I/O) a echoué ou a été interrompu
	
	public void gestionException(ParseException e){
        JOptionPane.showInternalMessageDialog(null, e.toString(), "Exception", JOptionPane.ERROR_MESSAGE);
        System.out.println("ParseException : "+e.toString());
    }	// Signale une erreur innatendue lors de l'analyse.
}
