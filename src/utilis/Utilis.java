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
	
	public static <T> ArrayList<T> rassembler(ArrayList<T> liste){
		ArrayList<T> rassemble = new ArrayList<T>();
		for(T t: liste){
			
			if((rassemble.isEmpty())||
			(!(rassemble.contains(t)) 
			|| rassemble.get(rassemble.size()-1).equals(t))) {
				
				rassemble.add(t);
			}
		}
		return rassemble;
	}
	
	public static <T> boolean verifierRassemblement(ArrayList<T> liste) {
        if (liste.isEmpty()) {
            return true; // Une liste vide est considérée comme rassemblée
        }
        ListIterator<T> iterator1 = liste.listIterator();
        
        for(T t = iterator1.next();!iterator1.hasNext(); iterator1.next()) {
        	if(!t.equals(iterator1.next())) {
        		ListIterator<T> iterator2 = liste.listIterator(iterator1.nextIndex());
        		for(T ti = iterator2.next();!iterator2.hasNext(); iterator2.next()) {
        			if(ti.equals(t)) {
        				return false;
        			}
        		}
        	}
        }
        return true;
	}

}
