package pobj.motx.tme3;
import java.util.List;
import pobj.motx.tme2.*;

public class CroixContrainte implements IContrainte {
	
	// Attributs pour stocker les indices des emplacements et des cases
	private int m1, c1, m2, c2;
	
	// Constructeur pour initialiser les indices des emplacements et des cases
    public CroixContrainte(int m1, int c1, int m2, int c2) {
        this.m1 = m1; // Indice de l'emplacement m1
        this.c1 = c1; // Indice de la case c1 dans l'emplacement m1
        this.m2 = m2; // Indice de l'emplacement m2
        this.c2 = c2; // Indice de la case c2 dans l'emplacement m2
    }
	
	@Override
	public int reduce(GrillePotentiel grille) {
		
		Dictionnaire d1 = grille.getMotsPot().get(m1);
		Dictionnaire d2 = grille.getMotsPot().get(m2);
		
		EnsembleLettre l1 = d1.getLettresPossibles(c1);
		EnsembleLettre l2 = d2.getLettresPossibles(c2);
		
		int filtre = 0;
		EnsembleLettre intersection = l1.inter(l2);
		
		if(l1.size()>intersection.size()){
			filtre+=d1.filtreParEnsemble(intersection, c1);
		}
		if(l2.size()>intersection.size()) {
			filtre+=d2.filtreParEnsemble(intersection, c2);
		}
		
		return filtre;
	}
	
	@Override
	public boolean equals(Object other) {
	    // Vérification si c'est le même objet
	    if (this == other) {
	        return true;
	    }
	    
	    // Vérification si l'objet est une instance de CroixContrainte
	    if (!(other instanceof CroixContrainte)) {
	        return false;
	    }
	    
	    // Cast de l'objet pour accéder aux attributs
	    CroixContrainte autre = (CroixContrainte) other;
	    
	    // Comparaison des attributs
	    return autre.m1 == this.m1 &&
	           autre.m2 == this.m2 &&
	           autre.c1 == this.c1 &&
	           autre.c2 == this.c2;
	}
	

}
