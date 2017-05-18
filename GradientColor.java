package gss2.tools;

// LIBRAIRIES
import java.util.List;
import java.util.ArrayList;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.shape.Rectangle;

/**
 * Brique en Java permettant de generer dynamiquement un composant jauge de niveau.
 * Ce composant permet de pouvoir evaluer le niveau de surete pour une cible.
 * Cette jauge est stockée dans un Pane parent, qui contiendra un node VBox.
 * Le node VBox contiendra quand à lui des Panes fusionnant des Rectangles ayant
 * un background de couleurs degradees et un node CheckBox, permettant de les
 * selectionner visuellement. 
 * Le nombre de cellule du VBox dependra du nombre de couleur dans la liste passee
 * en parametre (couleur-1). 
 * 
 * TODO : La methode queryInsertUpdate() sera a modifier dans votre application.
 * 
 * @author Frederic COUPEZ (Neo_Ryu) - License GPL
 */
public class GradientColor {
	
	/* EXEMPLE :
	   MyPane.heightProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(final ObservableValue<? extends Number> observableValue, final Number oldValue, final Number newValue) {
				MyPane.getChildren().clear();
				// Creation d'une jauge d'evaluation
		 		List<Color> listColor = new ArrayList<Color>();
					listColor.add(Color.LIME);
					listColor.add(Color.YELLOW);
					listColor.add(Color.ORANGE);
					listColor.add(Color.RED);
				GradientColor gradient = new GradientColor(listColor, MyPane) ;
				MyPane.getChildren().add(gradient.GradientRect(75, true));
			}
		});
	 */
	
	/**
	 * PERSITANCE DES DONNEES : Il s'agit ici de lui fournir les methodes 
	 * de DAO ou de parseur XML pour l'insertion/modification ou serialization.
	 * La methode fait appel à une methode externe a la classe afin de permettre
	 * que cette brique reste un composant exportable à d'autres projet
	 * @param note : (double) La note reçue dans le constructeur de la classe
	 */
	private void queryInsertUpdate(double note) {
		// TODO MODIFICATION : Methode externe a la classe GradientColor :
		NodeCreator.addPersistanceDataNote(note);
	}
	
	// DIMENSIONS DE L'OBJET CONTENANT LES GRADUATIONS DE COULEURS
	private final DoubleProperty x1 = new SimpleDoubleProperty();
		public final double getX1() { return x1.get(); }
		public final void setX1(double value) { x1.set(value); }
		public final DoubleProperty x1Property() { return x1; }
	private final DoubleProperty x2 = new SimpleDoubleProperty();
		public final double getX2() { return x2.get(); }
		public final void setX2(double value) { x2.set(value); }
		public final DoubleProperty x2Property() { return x2; }
	private final DoubleProperty y1 = new SimpleDoubleProperty();
		public final double getY1() { return y1.get(); }
		public final void setY1(double value) { y1.set(value); }
		public final DoubleProperty y1Property() { return y1; }
	private final DoubleProperty y2 = new SimpleDoubleProperty();
		public final double getY2() { return y2.get(); }
		public final void setY2(double value) { y2.set(value); }
		public final DoubleProperty y2Property() { return y2; }
		
	/**
	 * Liste de couleurs ordonnees
	 */
	private List<Color> listColor = new ArrayList<Color>();
		// Obtenir la liste de couleurs
		public List<Color> getListColor() {
			return listColor;
		}
		// Definir une liste de couleurs en reference
		public void setListColor(List<Color> listColor) {
			this.listColor = listColor;
		}
		// Ajouter d'une couleur à la liste
		public void addColor(Color color) {
			this.listColor.add(color);
		}
		// Nettoyage de la liste
		public void clearListColor() {
			this.listColor.clear();
		}
		
	/**
	 * Le Node parent de type Pane ou sera greffe le composant
	 */
	protected Pane parentPane = new Pane();
	
	/**
	 * INTERROGATIONS DES DONNEES SQL : 
	 * 0 = SELECT
	 * 1 = INSERT
	 * 2 = UPDATE
	 */
	List<String> reqSQL = new ArrayList<String>();
	
	/**
	 * INTERROGATIONS DES DONNEES XML : 
	 * 0 = DESERIALIZE (lecture)
	 * 1 = SERIALIZE   (ecriture)
	 */
	List<String> reqXML = new ArrayList<String>();
	
	/**
	 * Variable permettant le stockage de la note pour une selection dynamiqu du checkbox le plus proche
	 */
	public double note = 0.0;

//-------------------------------------------//	
	
	/**
	 * CONSTRUCTEURS DE LA CLASSE
	 * @param liste : (List<Color>) Une liste contenant des couleurs
	 */
	GradientColor (List<Color> liste) {
		setListColor(liste);		
	}
	/**
	 * SURCHARGE DU CONSTRUCTEUR
	 * @param liste : (List<Color>) Une liste contenant des couleurs
	 * @param parent : (Pane) Le noeud Pane parent
	 */
	GradientColor (List<Color> liste, Pane parent) {
		this.parentPane = parent;
		setListColor(liste);		
	}
	/**
	 * SURCHARGE DU CONSTRUCTEUR (SQL)
	 * @param liste : (List<Color>) Une liste contenant des couleurs
	 * @param parent : (Pane) Le noeud Pane parent
	 * @param note : (double) La note a attribuer
	 */
	GradientColor (List<Color> liste, Pane parent, double note) {
		this.parentPane = parent;
		setListColor(liste);
		this.note = note;
	}
	
	/**
	 * SURCHARGE DU CONSTRUCTEUR (SQL)
	 * @param liste : (List<Color>) Une liste contenant des couleurs
	 * @param parent : (Pane) Le noeud Pane parent
	 * @param querySQL : (List<String>) SELECT / INSERT / UPDATE
	 */
	GradientColor (List<Color> liste, Pane parent, List<String> querySQL) {
		this.parentPane = parent;
		setListColor(liste);
		this.reqSQL = querySQL;
	}
	/**
	 * SURCHARGE DU CONSTRUCTEUR (SQL + XML)
	 * @param liste : (List<Color>) Une liste contenant des couleurs
	 * @param parent : (Pane) Le noeud Pane parent
	 * @param querySQL : (List<String>) SELECT / INSERT / UPDATE
	 * @param parseXML : (List<String>) READ / SERIALIZE
	 */
	GradientColor (List<Color> liste, Pane parent, List<String> querySQL, List<String> parseXML) {
		this.parentPane = parent;
		setListColor(liste);
		this.reqSQL = querySQL;
		this.reqXML = parseXML;
	}
	
//-------------------------------------------//	
	
	/**
	 * Methode de generation d'une VBox de rectangles avec couleurs graduees
	 * La taille sera adaptée automatiquement au Pane parent
	 * @param widthPercent : (double) Largeur exprimee en pourcentage (100 par defaut)
	 * @param isVertical : (boolean) Orientation du degrade (false=horizontal/true=vertical)
	 * @return (VBox) Node VerticalBox
	 */
	protected VBox GradientRect(double widthPercent, boolean isVertical) {
		setX1(0);
		setY1(0);		
		setX2(parentPane.getWidth()*widthPercent/100);
		setY2(parentPane.getHeight() / (listColor.size()-1));
		return createVBoxRect(isVertical);		
	}
	/**
	 * Surcharge de methode de generation d'une VBox de rectangles avec couleurs graduees
	 * @param width : (double) Defini la Largeur de l'element rectangle
	 * @param heigh : (double) Defini la Hauteur de l'element rectangle
	 * @param isVertical : (boolean) Orientation du degrade (false=horizontal/true=vertical)
	 * @return (VBox) Node VerticalBox
	 */
	protected VBox GradientRect(double width, double height, boolean isVertical) {
		setX1(0);
		setY1(0);
		setX2(width);
		setY2(height);
		return createVBoxRect(isVertical);
	}

	


	/**
	 * Methode permettant de generer dynamiquement des objets Rectangle
	 * @param debut : (Color) La couleur par laquelle debutera le rectangle 
	 * @param fin : (Color) La couleur qui terminera le rectangle 
	 * @param isVertical : (boolean) Orientation de la graduation : False = Horizontal / True = Vertical
	 * @param width : (int) Largeur de l'element rectangle
	 * @param heigh : (int) Longueur de l'element rectangle
	 * @return (Rectangle) L'objet Rectangle genere
	 */
	private Rectangle rectGradient(Color debut, Color fin, boolean isVertical) {
	     // On genere une rampe de couleurs pour le niveau de surete eleve
        Stop[] stop = new Stop[] { new Stop(0, debut), new Stop(1, fin) };
        LinearGradient gradient = new LinearGradient(0, 0, (isVertical ? 0 : 1), (isVertical ? 1 : 0), true, CycleMethod.NO_CYCLE, stop);
        Rectangle rect = new Rectangle(x1.get(), y1.get(), x2.get(), y2.get()); // X, Y, width, height
        rect.setFill(gradient);
        //System.out.println("[VBoxGradientColor] areaGradient END");
		return rect;		
	}
	
	/**
	 * Methode permettant de generer une liste de notes selon le nombre d'element
	 * La liste est automatiquement triee du plus grand au plus petit.
	 * @param nbrLevel : (int) Quantite d'element different (checkbox)
	 * @param noteMaxi : (double) La note maximale
	 * @param noteMini : (double) La note minimale
	 * @return (List<Double>) La liste de notes
	 */
	public List<Double> generateNotes(int nbrLevel, double noteMaxi, double noteMini) {
		// On genere une liste de notes selon le nombre de niveau pour la jauge
		// 2 = 0 / 1
		// 3 = 0 / 0.5 / 1 [PAR DEFAUT]
		// 4 = 0 / 0.33 / 0.66 / 1
		// 5 = 0 / 0.25 / 0.5 / 0.75 / 1		
		List<Double> listNotes = new ArrayList<>();
		listNotes.add(noteMaxi);	// HIGH SECURITY
		if(nbrLevel > 2) {
			// CALCUL DES NOTES ENTRE 1 ET 0 :
			for(int i=(nbrLevel-2); i>0 ; i--) {				
				listNotes.add((noteMaxi/(nbrLevel-1))*i);
			}
		}
		listNotes.add(noteMini);	// LOW SECURITY
		return listNotes;
	}
	
	/**
	 * Methode permettant de selectionner le bon checkbox (notation)
	 * > Attribution d'une note (liste) a chaque CheckBox
	 * > Recherche de la checkbox ayant la note la plus proche ou egale a noteCible  
	 * @param noteCible : (double) Note pour la cible en cours
	 * @param listNotes : (List<Double>) Une liste de notes (+ -> -)
	 * @return (int) L'identifiant du checkbox ayant été jugé environs egal a la note
	 */
	private int selectCheckBox(double noteCible, List<Double> listNotes) {
		// On recherche ensuite la valeur la plus proche de noteCible dans la liste
		// > valeur plus proche : en cas de nombre de niveaux differents
		double noteTemp = listNotes.get(0);
		int listPosNote = 0;
		boolean isEqual = false;
		for (int i=0 ; i < listNotes.size() ; i++) { 
			//On verifie au préalable si les valeurs sont egales
			if (!isEqual) {
				// Si c'est egal, on n'analysera plus les autres valeurs
				if(listNotes.get(i) == noteCible) {
					listPosNote = i;
					isEqual = true;
				} else {
					// Si le nombre (liste) est plus grand que noteCible et plus petit que noteTemp 
					if((listNotes.get(i) > noteCible) && (listNotes.get(i) < noteTemp)) {
						noteTemp = listNotes.get(i);
						listPosNote = i;
					}
				}
			}
		}
		return listPosNote;
	}	
	
	/**
	 * Methode permettant de trouver le bon objet CheckBox dans une liste
	 * @param liste : (List<CheckBox>) La liste des checkbox
	 * @param id : (String) l'identifiant de la jauge
	 * @return (CheckBox) La checkbox recherchee
	 */
	private CheckBox findCheckBox(List<CheckBox> liste, String id) {
		for(CheckBox checkbox : liste) {
        	if(checkbox.getId().equals(id)) return checkbox;
		}	
		return new CheckBox();
	}
	
	/**
	 * Creation d'objet Checkbox
	 * @param id : (int) identifiant de la checkbox
	 * @return (CheckBox) l'objet checkbox genere
	 */
	public CheckBox CreateCheckBox(int id) {
		CheckBox checkbox = new CheckBox(String.valueOf(id));
		checkbox.setId(String.valueOf(id));
		checkbox.setText("");
		return checkbox;
	}
	
	/**
	 * Generation d'une liste de Checkbox
	 * @param quantity : (int) nombre de checkbox a generer
	 * @return (List<CheckBox>) la liste contenant les checkbox
	 */
	public List<CheckBox> CreateListCheckBox(int quantity) {
		List<CheckBox> listeCheckBox = new ArrayList<CheckBox>();
		List<CheckBox> listetemp = new ArrayList<CheckBox>();
		for (int i=0 ; i<quantity ; i++) {			
			listetemp.add(CreateCheckBox(i));			
		}
		EventHandler checkboxHandler = new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		        if (event.getSource() instanceof CheckBox) {
		            CheckBox chk = (CheckBox) event.getSource();
		            for(CheckBox checkbox : listetemp) {
		            	if(checkbox.getId() != chk.getId()) {
		            		checkbox.setSelected(false);
		            	} else {
		            		note = listeNotes.get(Integer.parseInt(chk.getId()));
		            		//System.out.println("NOTE : "+note);
		            		if(chk.isSelected()) {
		            			// INSERT / UPDATE : RESULTAT_CIBLE
		            			// Si checkbox n'etait pas encore selectionne on 
		            			// enregistre l'etat (niv de surete de la cible)
		            			queryInsertUpdate(note);
		            		} else {
		            			// Sinon on lui remet son etat
		            			checkbox.setSelected(true);
		            		}
		            	}
		            }
		        }
		    }
		};
		for(CheckBox checkbox : listetemp) {
			checkbox.setOnAction(checkboxHandler);
			listeCheckBox.add(checkbox);
		}
		return listetemp;
	}
	
	/**
	 * Methode principale generant un nombre de Rectangle aux couleurs degrades selon la listColor
	 * @param isVertical : (boolean) Orientation du degrade (false=horizontal/true=vertical)
	 * @return (VBox) Vertical Box contenant les objets Rectangle en color degrades
	 */
	private VBox createVBoxRect(boolean isVertical) {
		VBox box = new VBox();		
		// Generation des elements de la VBox
		List<CheckBox> listCheckBox = CreateListCheckBox(listColor.size()-1);
		if(listColor.size() >= 2) {			
			for (int i=0; i < listColor.size()-1 ; i++) {
				Pane pane = new Pane();
				pane.setId(String.valueOf(i));
				
		        Rectangle jaugeLevel = rectGradient(listColor.get(i), listColor.get(i+1), isVertical);
		        jaugeLevel.setId(String.valueOf(i));
		        
		        CheckBox jaugeCheck = findCheckBox(listCheckBox, String.valueOf(i));
		        pane.getChildren().addAll(jaugeLevel,jaugeCheck);
		        
		        
		        jaugeLevel.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override public void handle(MouseEvent e) {
						System.out.println(((Rectangle)e.getSource()).getId());
						//boxSelected = Integer.parseInt(	((Control)e.getSource()).getId() );
						//(Rectangle)e.getSource().
				 	}
				});
		        box.getChildren().add(pane);
			}
		} else {
			if (listColor.size() == 1) {
				box.getChildren().add(rectGradient(listColor.get(0), listColor.get(0), isVertical));
			}
		}
		
		// SELECTION AUTOMATIQUE DU BON CHECKBOX (SI DATA PRESENTE)
		listeNotes = generateNotes(listColor.size()-1, 1 ,0); // qte / max / min
		
		// SELECT : RESULTAT_CIBLE
		double Resultat_NoteGlobale = note;
		
		int idNode = selectCheckBox(Resultat_NoteGlobale, listeNotes);
		for(CheckBox checkbox : listCheckBox) {
			if(checkbox.getId().equals(String.valueOf(idNode))) {
				checkbox.setSelected(true);
			}
		}
		
		return box;
	}
	List<Double> listeNotes;
}