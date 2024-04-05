package jeu;

import java.util.*;

import cartes.*;
import cartes.Probleme.Type;

public class ZoneDeJeu {
	private ArrayList<Bataille> pileBataille;
	private ArrayList<Limite> pileLimite;
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

    // Méthodes pour accéder aux informations sur la zone de jeu
    public ArrayList<Limite> getPileLimite() {
        return pileLimite;
    }

    public ArrayList<Bataille> getPileBataille() {
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
    
    public boolean estBloque() {
    	Carte sommetBataille = getPileBataille().get(getPileBataille().size()-1);
    	boolean prioritaire = getSetBottes().contains(Cartes.PRIORITAIRE);
    	boolean attaqueFeuSommetBataille = sommetBataille instanceof Attaque && ((Attaque) sommetBataille).getType().equals(Type.FEU);
    	boolean attaqueAccSommetBataille = sommetBataille instanceof Attaque && ((Attaque) sommetBataille).getType().equals(Type.ACCIDENT);
    	boolean attaqueCrevSommetBataille = sommetBataille instanceof Attaque && ((Attaque) sommetBataille).getType().equals(Type.CREVAISON);
    	boolean attaqueEssenceSommetBataille = sommetBataille instanceof Attaque && ((Attaque) sommetBataille).getType().equals(Type.ESSENCE);
    	boolean paradeFeuSommetBataille = sommetBataille instanceof Parade && ((Parade) sommetBataille).getType().equals(Type.FEU);

    	if(getPileBataille().isEmpty() && prioritaire) {
    		return false;
    	}
    	if(sommetBataille.toString().equals("Feu vert") || (sommetBataille instanceof Parade &&  prioritaire)) {
    		return false;
    	}
    	if(attaqueFeuSommetBataille && prioritaire) {
    		return false;
    	}
    	if(sommetBataille instanceof Attaque && contientMemeBotte((Bataille) sommetBataille) && prioritaire) {
    		return false;
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
    	Bataille sommetBataille = getPileBataille().get(getPileBataille().size()-1);
    	boolean attaqueFeuSommetBataille = carte instanceof Attaque && ((Attaque) sommetBataille).getType().equals(Type.FEU);
    	boolean attaqueFeuCarte = carte instanceof Attaque && ((Attaque) carte).getType().equals(Type.FEU);


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
    		else if(top instanceof Parade && carte instanceof Attaque && contientMemeBotte((Bataille)carte)) {
    			return true;
    		}
    	}
    	return false;
    }
	
	
	
}
