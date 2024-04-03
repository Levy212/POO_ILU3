package utilis;

import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
public class Utilis {
	
	public static <T> T extraire(ArrayList<T> liste) {
		if (liste.isEmpty()) {
            throw new IllegalArgumentException("La liste ne doit pas être vide.");
        }
		Random random = new Random();
		int index = random.nextInt(liste.size());
		return liste.remove(index);
		
	}
	
	public static <T> T extraire2(ArrayList<T> liste) {
		ListIterator<T> iList  = liste.listIterator(0);
		if (!iList.hasNext()) {
            throw new IllegalArgumentException("Le ListIterator ne doit pas être vide.");
        }
		
		Random random = new Random();
		int index = random.nextInt(liste.size());
		for(int i=0;i<index-1;i++) {
			iList.next();
		}
		T element = iList.next();
		iList.remove();
		return element;
	}
	
	public static <T> ArrayList<T> melanger(ArrayList<T> liste){
		ArrayList<T> melange = new ArrayList<T>();
		int size = liste.size();
		for(int i=0;i<size;i++) {
			Random random = new Random();
			int index = random.nextInt(liste.size());
			T element = liste.remove(index);
			melange.add(element);
		}
		return melange;
	}
	
	public static <T> boolean verifierMelange(ArrayList<T> liste1, ArrayList<T> liste2) {
        if (liste1.size() != liste2.size()) {
            return false;
        }

        for (T element : liste1) {
            if (Collections.frequency(liste1, element) != Collections.frequency(liste2, element)) {
                return false;
            }
        }
        return true;
    }
	
	private static <T> boolean contient(ArrayList<T> liste, T t) {
		for(T cur : liste) {
			if(cur.equals(t)){
				return true;
			}
		}
		
		return false;
	}
	
	public static <T> ArrayList<T> rassembler(ArrayList<T> liste){
		ArrayList<T> rassemble = new ArrayList<T>();
		T t2 = liste.get(0);
		rassemble.add(liste.remove(0));
		for(T t: liste){
			
			if((rassemble.isEmpty())||
			(!(contient(rassemble, t)) 
			|| (t2.equals(t) && t.equals(rassemble.get(rassemble.size()-1))))) {
				rassemble.add(t);
			}
			t2 = t;
		}
		return rassemble;
	}
	
	public static <T> boolean verifierRassemblement(ArrayList<T> liste) {
        if (liste.isEmpty()) {
            return true; // Une liste vide est considérée comme rassemblée
        }
        
        ListIterator<T> iterator1 = liste.listIterator();
        T previous = iterator1.next();
        
        while (iterator1.hasNext()) {
            T current = iterator1.next();
            if (!current.equals(previous)) {
                ListIterator<T> iterator2 = liste.listIterator(iterator1.nextIndex());
                while (iterator2.hasNext()) {
                    if (iterator2.next().equals(previous)) {
                        return false; // Élément identique trouvé plus tard dans la liste
                    }
                }
                previous = current;
            }
        }
        
        return true;
    }

}
