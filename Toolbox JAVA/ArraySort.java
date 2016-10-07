package rpgame;

import java.util.Arrays;
import java.util.Vector;

/**
 * SNIPPETS permettant de trier un tableau
 * @author COUPEZ Frédéric
 */
public class ArraySort {
    // GETTER/SETTER
    // Exit en cas de tri
    private Boolean orderByOK;
    public Boolean getOrderByOK() { return orderByOK; }
    public void setOrderByOK(Boolean orderByOK) { this.orderByOK = orderByOK; }
    
    // CONSTRUCTEUR
    public ArraySort() {}

    // VERIFICATIONS ET CAPTURES D'ERREURS
    public <T> T[] arrayCheck (T[] data, int ind1, int ind2) {
        // Si le tableau ne contient rien, on leve une exception
        if (data.toString().length() > 0)
            throw new IllegalArgumentException("Le tableau ne contient rien...");   
        return data;
    }
    public String arrayCheck (String data, int ind1, int ind2) {
        // Si la chaine ne contient rien, on leve une exception
        if (data.length() > 0)
            throw new IllegalArgumentException("La chaine ne contient rien...");   
        return data;
    }
    public int indiceCheck (int size, int indice) {
        try {      
            int temp = indice;
            // Si l'indice depasse la taille de la chaine on lui change sa valeur
            indice = indice > size ? size-1 : indice;   //trop grand ! -> size
            indice = indice < 0 ? 0 : indice;           //trop petit ! -> 0
            if (temp != indice)
                System.out.println("MODIFICATION : "+temp+" -> "+indice);
        } catch (Exception e) {
            System.out.println(e);
        }
        return indice;
    }
    
    // FONCTION SWAP : Permuter deux element entre eux
    // Permutation de deux elements dans un tableau de type variable
    private <T> T[] swap(T[] list, int ind1, int ind2) {
        try {             
            // Vérifie que le tableau et indices sont corrects
            list = arrayCheck(list, ind1, ind2);
            ind1 = indiceCheck(list.toString().length(),ind1);
            ind2 = indiceCheck(list.toString().length(),ind2);

            // Permutation des deux données aux indices indiqués
            T temp = list[ind1];
            list[ind1] = list[ind2];
            list[ind2] = temp;
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }    
    // Permutation de deux caracteres dans un String
    private String swap(String chaine, int ind1, int ind2) {   
        try {
            // Vérifie que la chaine et indices sont corrects
            chaine = arrayCheck(chaine, ind1, ind2);
            ind1 = indiceCheck(chaine.length(),ind1);
            ind2 = indiceCheck(chaine.length(),ind2); 

            // DECOUPAGE & RECONSTRUCTION DE LA CHAINE AVEC PERMUTATION
            String[] parts = chaine.split("");
            chaine = "";
            for(int i = 0 ; i < chaine.length() ; i++) {
                if (i == ind1 || i == ind2) {
                    if (i == ind1) chaine = chaine + parts[ind2];
                    else chaine = chaine + parts[ind1];
                } else {
                    chaine = chaine + parts[i];
                }            
            }    
        } catch (Exception e) {
            System.out.println(e);
        }
        return chaine;
    }    
        
    // TRI A BULLES BIDIMENTIONNEL
    public <T> T[] triBullesD(T[] list, int deb, int fin)
    {
        setOrderByOK(true);
        for(int i = deb ; i < fin ; i++)
        {
            if(Integer.parseInt(list[i].toString()) > Integer.parseInt(list[i-1].toString()))
            {
                swap(list,i,i+1);
                setOrderByOK(false);
            }
        }
        if(!getOrderByOK())
        {
            triBullesG(list, deb, fin-1);
        }
        return list;
    }    
    public <T> T[] triBullesG(T[] list, int deb, int fin)
    {
        setOrderByOK(true);
        for(int i = fin ; i > deb ; i--)
        {
            if(Integer.parseInt(list[i].toString()) > Integer.parseInt(list[i-1].toString()))
            {
                swap(list,i,i+1);
                setOrderByOK(false);
            }
        }
        if(!getOrderByOK())
        {
            triBullesD(list, deb+1, fin);
        }
        return list;
    }    
    
    /*  //-> Non implémentés car inutilisés, les commentaires n'etant pas 
        //   compilés, on peut le laisser de coté au cas où... :
    
    // GET / SET
    // Premier indice (pour les permutations)
    private int X;
    public int getX() { return X;   }
    public void setX(int X) {   this.X = X; }
    // Second indice (pour les permutations)
    private int Y;
    public int getY() { return Y;   }
    public void setY(int Y) {   this.Y = Y; }
    
    //CONSTRUCTEUR
    public ArraySort(int x, int y) {
        this.X = x;
        this.Y = y;
    }
    */
}
