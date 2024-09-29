package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.*;

public class GrillePotentiel {
	private GrillePlaces grille;
	private Dictionnaire dico;
	private List<Dictionnaire> motsPot;
	
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		this.grille = grille;
		this.dico = dicoComplet;
		this.motsPot= new ArrayList<>();
		
		for(Emplacement e : grille.getPlaces()) {
			Dictionnaire copy = dico.copy();
			copy.filtreLongueur(e.size());
			
			for(int i =0; i<e.size();i++) {
				Case c = e.getCase(i);
				if (!c.isVide()) {copy.filtreParLettre(c.getChar(),i);
			
				}
			}
			motsPot.add(copy);
		}
		
		
	}
	
	public GrillePlaces getGrille() { return grille;}
	public Dictionnaire getDico() { return dico;}
	
	public List<Dictionnaire> getMotsPot(){ return motsPot;}
	
	public boolean isDead() {
	    for(Dictionnaire dico : motsPot) {
	    	if(dico.size()==0) return true;	
	    }
	    return false;
	    
	}
	
	public GrillePotentiel fixer(int m, String soluce) {
		
		GrillePlaces grilleplace = grille.fixer(m, soluce);
		GrillePotentiel grillepotentiel = new GrillePotentiel(grilleplace, dico);
	
		return grillepotentiel;
	}
	
}
