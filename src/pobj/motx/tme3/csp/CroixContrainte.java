package pobj.motx.tme3;
import java.util.HashSet;
import java.util.Set;

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
		// Récupération des dictionnaires de mots potentiels pour les emplacements m1 et m2
		Dictionnaire l1 = grille.getMotsPot().get(m1);
		Dictionnaire l2 = grille.getMotsPot().get(m2);
		
		// Si les tailles de l1 et l2 sont identiques c'est que potentiellement toutes les cases sont vides donc aucun filtrage n'est necessaire
		if (l1.size() == l2.size()) {
	        return 0; // Retourne 0 pour indiquer qu'aucun mot n'a été filtré
	    }
		
        // Création de sets pour stocker les lettres possibles à chaque positionSet<Character> s1 = new HashSet<>();
		Set<Character> s1 = new HashSet<>();
		Set<Character> s2 = new HashSet<>();
	    
	    //System.out.println("l1 size : " + l1.size());
	    //System.out.println("l2 size : " + l1.size());
		
	    
		// Remplissage de s1 avec les lettres possibles pour la case c1 de l'emplacement m1
		for( int i = 0; i<l1.size();i++) {
			if(l1.get(i).length()>c1) {
				s1.add( l1.get(i).charAt(c1)); // Ajout de la lettre à s1
			}
		}
		
		// Remplissage de s2 avec les lettres possibles pour la case c2 de l'emplacement m2
        
		for( int i = 0; i<l2.size();i++) {
			if(l2.get(i).length()>c2) {
				s2.add( l2.get(i).charAt(c2)); // Ajout de la lettre à s2
			}
		}
		
		int filtre=0; // Compteur pour le nombre de mots filtrés
		
		// Calcul de l'intersection l1 et l2 des lettres possibles
		Set<Character> intersection = new HashSet<>(s1);
	    intersection.retainAll(s2); // Retient uniquement les lettres présentes dans s1 et s2
		
	 // Si l1 a plus de mots que l'intersection, on filtre l1
		if (l1.size()>intersection.size()) {
			for(Character c : intersection) {
				filtre+=l1.filtreParLettre(c,c1); // Filtrage par lettre
			}
		}
		
		// Si l2 a plus de mots que l'intersection, on filtre l2
		else if (l2.size()>intersection.size()) {
			for(Character c : intersection) {
				filtre+=l2.filtreParLettre(c,c1);  // Filtrage par lettre
			}
		}
		
//		System.out.println("s1: " + s1);
//		System.out.println("s2: " + s2);
//		System.out.println("Intersection: " + intersection);
//		System.out.println("-----------------------------");
//		
		// Retourne le nombre total de mots filtrés
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
