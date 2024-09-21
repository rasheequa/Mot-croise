package pobj.motx.tme1;

/* 
 * La classe Grille représente une grille de cases, avec un certain nombre 
 * de lignes et de colonnes. Chaque case contient un caractère.
 */
public class Grille {
	private Case[][] grilles; // Tableau 2D de cases représentant la grille.
	
	/* 
	 * Constructeur de la classe Grille. Initialise une grille vide avec des cases contenant un espace (' ').
	 * @param hauteur : nombre de lignes de la grille
	 * @param largeur : nombre de colonnes de la grille
	 */	
	public Grille(int hauteur, int largeur) {
		grilles = new Case[hauteur][largeur];
		
		// Remplit chaque case de la grille avec un objet Case initialisé avec un espace vide.
		for (int i=0; i<grilles.length; i++ ) {
			for (int j=0; j<grilles[i].length; j++) {
				grilles[i][j] = new Case(i,j,' ');
			}
		}
	}
	
	/* 
	 * Retourne la case située à la ligne 'lig' et à la colonne 'col'.
	 * @param lig : numéro de la ligne
	 * @param col : numéro de la colonne
	 * @return la case à la position spécifiée
	 */
	public Case getCase(int lig,int col) {
		return grilles[lig][col];
	
	}
	
	/* 
	 * Retourne une représentation sous forme de chaîne de caractères de la grille 
	 * en utilisant la méthode GrilleLoader.serialize() pour la sérialisation.
	 * @return une chaîne de caractères représentant la grille
	 */
	public String toString() {
		return GrilleLoader.serialize(this,true);
	}

	/* 
	 * Retourne le nombre de lignes de la grille.
	 * @return un entier représentant le nombre de lignes
	 */
	public int nbLig(){
		return grilles.length;
	}
	
	/* 
	 * Retourne le nombre de colonnes de la grille.
	 * @return un entier représentant le nombre de colonnes
	 */
	public int nbCol() {
		return grilles[0].length;
	}
	
	/* 
	 * Crée une copie de la grille courante. Chaque case de la grille est copiée 
	 * dans une nouvelle instance de Case.
	 * @return une nouvelle instance de Grille identique à la grille courante
	 */
	public Grille copy() {
		Grille copy = new Grille(this.nbLig(),this.nbCol());
		// Boucle sur chaque ligne et chaque colonne pour copier les cases
		for (int i=0; i<this.nbLig(); i++ ) {
			for (int j=0; j<this.nbCol(); j++) {
				// Copie chaque case avec ses coordonnées et son caractère
				copy.grilles[i][j]= new Case(i,j,grilles[i][j].getChar());
			}
		}
		return copy; 
	}
}
