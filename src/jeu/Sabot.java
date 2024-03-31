package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {
	private Carte[] cartes;
	private int nbCartes;
	private int nombreOperations;
	
	public Sabot(int n) {
		this.nbCartes = 0;
		this.cartes = new Carte[n];
				
	}
	
	public Boolean estVide() {
		return nbCartes == 0;
	}
	
	public void ajouterCarte(Carte carte) {
		if (nbCartes < 110) {
			cartes[nbCartes] = carte;
			nbCartes++;
			nombreOperations++;
		} else {
			try {
	            throw new RuntimeException("Depassement de capacite");
	        } catch (RuntimeException e) {
	            e.printStackTrace();
	        }
		}
	}
	
	public void ajouterFamilleCarte(Carte carte) {
		for(int i=0; i<carte.getNombre(); i++) {
			ajouterCarte(carte);
		}
	}
	
	public void  ajouterFamilleCartes(Carte...cartes) {
		for(Carte carte:cartes) {
			ajouterFamilleCarte(carte);
		}
	}

	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<Carte>{
		
		private int indiceIterateur = 0;
		private int nombreOperationsReference = nombreOperations;
		private boolean nextEffectue = false;
		

		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}

		@Override
		public Carte next() {
			verificationConcurrence();
			if (hasNext()) {
				Carte carte = cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			} else {
				throw new NoSuchElementException();
			}
		}
		
		public void remove() {
			verificationConcurrence();
			if (nbCartes<1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			
			for (int i = indiceIterateur-1; i < nbCartes-1; i++) {
				cartes[i] = cartes[i+1];
			}
			
			nbCartes--;
			indiceIterateur--;
			nextEffectue=false;
			nombreOperations++;
			nombreOperationsReference++;
			
		}
		
		private void verificationConcurrence() {
			if (nombreOperations != nombreOperationsReference) {
				throw new ConcurrentModificationException();
			}
		}
		
	}
	
	public Carte piocher() {
		Iterator<Carte> I = iterator();
		Carte carte = I.next();
		I.remove();
		return carte;	
	}
	
	
	

}
