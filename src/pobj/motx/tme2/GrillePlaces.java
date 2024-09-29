package pobj.motx.tme2;
import pobj.motx.tme1.*;

import java.util.ArrayList;
import java.util.List;

public class GrillePlaces {
	
	private List<Emplacement> places;
	private int nbHorizontal=0;
	private Grille grille;
	
	public GrillePlaces (Grille grille) {
		
		this.grille=grille;
		places = new ArrayList<>();
		
		for(int ligne = 0; ligne<grille.nbLig();ligne++ ) {
			Emplacement e = new Emplacement();
			for(int colonne = 0; colonne<grille.nbCol();colonne++ ) {
				Case c = grille.getCase(ligne, colonne);
				if(!c.isPleine()) {
					e.add(c);
				}
				else {
					if(e.size()>1) {
						places.add(e);
						nbHorizontal++;
					}
					
					e = new Emplacement();
				}
				
			}
			
			if (e.size() > 1) {
	            places.add(e); 
	            nbHorizontal++; 
	        }
			
		}
		
		
		for(int colonne = 0; colonne<grille.nbCol();colonne++ ) {
			Emplacement e = new Emplacement();
			for(int ligne = 0; ligne<grille.nbLig();ligne++ ) {
				Case c = grille.getCase(ligne, colonne);
				if(!c.isPleine()) {
					e.add(c);
				}
				else {
					if(e.size()>1) {
						places.add(e);
					}
					e = new Emplacement();
				}
				
			}
			
			if(e.size()>1) {
				places.add(e);
			}
			
		}
		
	}
	

		
	public List<Emplacement> getPlaces(){
		return places;
	}
	
	public int getNbHorizontal() {
		return nbHorizontal;
	}
	
	public String toString() {
		String mot = "";
		for (Emplacement e : places) {
			mot += e + ", ";
		}
		return mot;
	}

	public GrillePlaces fixer(int m, String soluce) {
		
		if (m < 0 || m >= places.size()) {
	        throw new IndexOutOfBoundsException("Indice d'emplacement invalide");
	    }
		
		Emplacement emplacement = places.get(m);
		
		
		if (soluce.length() != emplacement.size()) {
	        throw new IllegalArgumentException("La longueur de la solution ne correspond pas à la taille de l'emplacement");
	    }
		
		Grille grille = this.grille.copy();
		
		for(int i = 0; i<emplacement.size();i++) {
			Case original = emplacement.getCase(i);
			Case copie = grille.getCase(original.getLig(),original.getCol());
			copie.setChar(soluce.charAt(i));
		}
		
		return new GrillePlaces(grille);
		
		 
	}
	
}
