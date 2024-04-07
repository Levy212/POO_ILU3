package jeu;

import java.util.*;

import cartes.*;
import cartes.Probleme.Type;

public class ZoneDeJeu {
	private List<Bataille> pileBataille;
	private List<Limite> pileLimite;
	private Collection<Borne> collectionBornes;
	private Set<Botte> setBottes;
	
	public ZoneDeJeu() {
        this.pileLimite = new ArrayList<>();
        this.pileBataille = new ArrayList<>();
        this.collectionBornes = new ArrayList<>();
        this.setBottes = new HashSet<>();
    }
	
	public void ajouter(Limite carte) {
        pileLimite.add(carte);
    }
	
    public void ajouter(Bataille carte) {
        pileBataille.add(carte);
    }
    
    public void ajouter(Borne carte) {
        collectionBornes.add(carte);
    }
    
    public void ajouter(Botte carte) {
        setBottes.add(carte);
    }

    public Carte retirerCarteLimite() {
        if (!pileLimite.isEmpty()) {
            return pileLimite.remove(pileLimite.size() - 1);
        }
        return null;
    }



    public Carte retirerCarteBataille() {
        if (!pileBataille.isEmpty()) {
            return pileBataille.remove(pileBataille.size() - 1);
        }
        return null;
    }

    public boolean retirerBorne(Carte carte) {
        return collectionBornes.remove(carte);
    }

    public boolean retirerBotte(Carte carte) {
        return setBottes.remove(carte);
    }

    public List<Limite> getPileLimite() {
        return pileLimite;
    }

    public List<Bataille> getPileBataille() {
        return pileBataille;
    }

    public Collection<Borne> getCollectionBornes() {
        return collectionBornes;
    }

    public Set<Botte> getSetBottes() {
        return setBottes;
    }
    
	public void deposer(Borne borne) {
		ajouter(borne);
	}
	
	public int donnerKmParcourus() {
		int res = 0;
		for(Borne b:getCollectionBornes()) {
			res = res+b.getKm();
		}
		return res;
	}
	
    public int donnerLimitationVitesse() {
    	if (getSetBottes().contains(Cartes.PRIORITAIRE) || getPileLimite().isEmpty() || getPileLimite().get(getPileLimite().size() - 1) instanceof FinLimite) {
    	    return 200;
    	} else {
    	        return 50;
    	    }
    }
    
    private boolean contientMemeBotte(Bataille carte) {
    	for(Botte b: getSetBottes()) {
    		if(carte.getType().equals(b.getType())) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public  Attaque contientMemeAttaque(Botte carte) {
    	for(Bataille b: getPileBataille()) {
    		if(b instanceof Attaque && carte.getType().equals(b.getType())) {
    			return (Attaque)b;
    		}
    	}
    	return null;
    }
    
    
    public boolean estBloque() {
    	boolean prioritaire = getSetBottes().contains(Cartes.PRIORITAIRE);    	

    	if(getPileBataille().isEmpty() && prioritaire) {
    		return false;
    	}
    	else if(!getPileBataille().isEmpty()) {
    		Carte sommetBataille = getPileBataille().get(getPileBataille().size()-1);
        	boolean attaqueFeuSommetBataille = sommetBataille instanceof Attaque && ((Attaque) sommetBataille).getType().equals(Type.FEU);

        	if(sommetBataille.toString().equals("Feu vert") || (sommetBataille instanceof Parade &&  prioritaire)) {
        		return false;
        	}
        	if((attaqueFeuSommetBataille||
    			(sommetBataille instanceof Attaque && contientMemeBotte((Bataille) sommetBataille))) 
    			&& prioritaire) {
        		return false;
        	}
        }

    	return true;
    	
    }
    
    private boolean contientDebutLimite() {
    	for(Limite c : getPileLimite()) {
    		if(c instanceof DebutLimite) {
    			return true;
    		}
    	}
    	return false;
    }
    
    
    public boolean estDepotAutorise(Carte carte) {
    	boolean prioritaire = getSetBottes().contains(Cartes.PRIORITAIRE);

    	if(carte instanceof  Borne && !estBloque() && (((Borne) carte).getKm()+donnerKmParcourus()<=1000)
    			&& ((Borne) carte).getKm()<=donnerLimitationVitesse()) {
    		return true;
    	}
    	
    	if(carte instanceof Botte) {
    		return true;
    	}
    	if(carte instanceof DebutLimite && !prioritaire && !contientDebutLimite()) {
    		return true;
    	}
    	if(carte instanceof FinLimite && !prioritaire && contientDebutLimite()) {
    		return true;
    	}
    	if(carte instanceof Bataille) {
    		Carte top;
    		if (getPileBataille().isEmpty()) {
    			if(prioritaire || carte.equals(Cartes.FEU_ROUGE)) {
    				top = Cartes.FEU_VERT;
    			}
    			else {
    				top = Cartes.FEU_ROUGE;
    			}
			}
    		else {
        		top = getPileBataille().get(getPileBataille().size()-1);
    		}
    		
    		if(top instanceof Attaque && !contientMemeBotte((Bataille) top)
    				&& carte instanceof Parade && 
    				((Parade)carte).getType().equals(((Bataille)top).getType())) {
    			return true;
    			
    		}
    		else if(top instanceof Parade && carte instanceof Attaque && !contientMemeBotte((Bataille)carte)){
    			return true;
    		}
    	}
    	return false;
    }
    
    
    
    public boolean deposer(Carte c) {
    	if(estDepotAutorise(c)) {
    		if(c instanceof Borne) {
    			deposer((Borne) c);
    			return true;
    		}
    		else if(c instanceof Botte) {
    			ajouter((Botte)c);
    			if(contientMemeAttaque((Botte)c)!=null) {
    				pileBataille.remove(pileBataille.indexOf(contientMemeAttaque((Botte)c)));
    			}
    			return true;
    		}
    		else if(c instanceof Limite) {
    			ajouter((Limite) c);
    			return true;
    		}
    		else if(c instanceof Bataille) {
    			ajouter((Bataille) c);
    			return true;
    		}
    		return false;
    	}
    	else {
    		return false;
    	}
    	
    }
	
	
	
}
