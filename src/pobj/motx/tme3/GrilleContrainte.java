package pobj.motx.tme3;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.GrillePlaces;
import pobj.motx.tme2.GrillePotentiel;

public class GrilleContrainte extends GrillePotentiel {
	
	private List<IContrainte> contraintes;
	
	public GrilleContrainte(GrillePlaces grille, Dictionnaire dicoComplet) {
		super(grille, dicoComplet);
		contraintes = new ArrayList<>();
		for(int i =0; i<grille.getNbHorizontal();i++) {
			Emplacement horizontal = grille.getPlaces().get(i);
			
			for(int j = grille.getNbHorizontal(); j<grille.getPlaces().size();j++) {
				Emplacement vertical = grille.getPlaces().get(j);
				
				for(int ci = 0; ci<horizontal.size();ci++) {
					Case c1 =horizontal.getCase(ci);
					
					for(int cj = 0; cj<vertical.size();cj++) {
						Case c2 =vertical.getCase(cj);
						
						if (c1==c2 && horizontal.getCase(ci).isVide()) {
							contraintes.add(new CroixContrainte(i,ci,j,cj));
						}
					}	
					
				}
					
			}
		}
		
		propage();
		
	}
	
	public List<IContrainte> getContraintes() {return contraintes;}

	@Override
	public GrilleContrainte fixer(int m, String soluce) {
		GrillePlaces grilleplace = getGrille().fixer(m, soluce);
		GrilleContrainte grillecontrainte = new GrilleContrainte(grilleplace,getDico().copy());
		return grillecontrainte;
	}
	
	private boolean propage() {
		
		while(true) {
			int reduc=0;
			for(IContrainte c: contraintes) {
				reduc+=c.reduce(this);
			}
			if(isDead()) {
				return false;
			}
			
			if(reduc==0) {
				return true;
				
				
			}	
		}
	}


		
}
	
