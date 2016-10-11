/**
 * SNIPPETS permettant de permutter ou trier un tableau
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
        if (data.toString().length() <= 0)
            throw new IllegalArgumentException("Le tableau ne contient rien...");   
        return data;
    }
    public String arrayCheck (String data, int ind1, int ind2) {
        // Si la chaine ne contient rien, on leve une exception
        if (data.length() <= 0)
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
    // Permutation de deux elements dans un tableau polymorphique
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
    public String swap(String chaine, int ind1, int ind2) {  
    	String data = "";
        try {
        	
            // Vérifie que la chaine et indices sont corrects
            chaine = arrayCheck(chaine, ind1, ind2);
            ind1 = indiceCheck(chaine.length(),ind1);
            ind2 = indiceCheck(chaine.length(),ind2); 

            // DECOUPAGE & RECONSTRUCTION DE LA CHAINE AVEC PERMUTATION
            String[] parts = chaine.split("");
            
            for(int i = 0 ; i < chaine.length() ; i++) {
                if (i == ind1 || i == ind2) {
                    if (i == ind1) 
                    	data += parts[ind2];
                    else 
                    	data += parts[ind1];
                } else {
                	data += parts[i];
                }            
            }    
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }    
     
    // TRI A BULLES BIDIMENTIONNEL -> LIST<T>
    // swap
	private <T> List<T> swap(List<? super T> list, int ind1, int ind2) {
		try {             
            // Permutation des deux données aux indices indiqués		
            T temp = (T) list.get(ind1);            
            list.set(ind1, (T) list.get(ind2));
            list.set(ind2, (T) temp);
        } catch (Exception e) {
            System.out.println(e);
        }
        return (List<T>) list;		
	} 
    // droite
    public <T> List<T> triBullesD(List<? super T> list, int deb, int fin, char signe)
    {
        setOrderByOK(true);
        for(int i = deb ; i < fin ; i++)
        {
        	if (signe == '>')
	            if(Integer.parseInt(list.get(i).toString()) > Integer.parseInt(list.get(i-1).toString()))
	            {
	                swap(list,i,i-1);
	                setOrderByOK(false);
	            }
	        if (signe == '<')
	            if(Integer.parseInt(list.get(i).toString()) < Integer.parseInt(list.get(i-1).toString()))
	            {
	                swap(list,i,i-1);
	                setOrderByOK(false);
	            }
        }
        if(!getOrderByOK())
        {
            triBullesG(list, deb, fin-1, signe);
        }
        return (List<T>) list;
    }
    // gauche
	public <T> List<T> triBullesG(List<? super T> list, int deb, int fin, char signe)
    {
        setOrderByOK(true);
        for(int i = fin ; i > deb ; i--)
        {
        	if (signe == '>')
	            if(Integer.parseInt(list.get(i-1).toString()) < Integer.parseInt(list.get(i).toString()))
	            {
	                swap(list,i,i-1);
	                setOrderByOK(false);
	            }
	        if (signe == '<')
            	if(Integer.parseInt(list.get(i-1).toString()) > Integer.parseInt(list.get(i).toString()))
	            {
	                swap(list,i,i-1);
	                setOrderByOK(false);
	            }
        }
        if(!getOrderByOK())
        {
            triBullesD(list, deb, fin, signe);
        }
        return (List<T>) list;
    } 
    
    // TODO NON TESTEE : TRI A BULLES BIDIMENTIONNEL -> t[]
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
}
