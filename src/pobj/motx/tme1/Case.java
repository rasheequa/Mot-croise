package pobj.motx.tme1;

/* 
 * La classe Case représente une case dans une grille avec ses coordonnées (ligne, colonne) 
 * et la valeur qu'elle contient (un caractère). 
 */
public class Case{
	private char valeur; // Caractère représentant la valeur de la case.
	private int x,y; // Coordonnées de la case dans la grille (abscisse x et ordonnées y).
	
	/* 
	 * Constructeur de la classe Case qui initialise ses coordonnées 
	 * et la valeur qu'elle contient.
	 * @param lig : numéro de la ligne
	 * @param col : numéro de la colonne
	 * @param c : caractère représentant la valeur de la case
	 */
	public Case(int lig, int col, char c) {
		this.valeur = c;
		this.x = lig;
		this.y=col;
	}
	
	/* 
	 * Retourne la ligne (coordonnée x) de la case. 
	 * @return l'entier représentant la ligne
	 */
	public int getLig(){
		return this.x;
	}
	
	/* 
	 * Retourne la colonne (coordonnée y) de la case. 
	 * @return l'entier représentant la colonne
	 */
	public int getCol(){
		return this.y;
	}
	
	/* 
	 * Retourne le caractère contenu dans la case. 
	 * @return le caractère (char) stocké dans la case
	 */
	public char getChar(){
		return this.valeur;
	}
	
	/* 
	 * Met à jour le caractère contenu dans la case. 
	 * @param c : le nouveau caractère à stocker
	 */
	public void setChar(char c) {
		this.valeur=c;
	}
	
	/* 
	 * Vérifie si la case est vide, c'est-à-dire si elle contient un espace (' '). 
	 * @return true si la case est vide, sinon false
	 */
	public boolean isVide() {
		return (this.valeur == ' ') ?  true : false;
		
	}
	
	/* 
	 * Vérifie si la case est pleine, c'est-à-dire si elle contient un astérisque ('*'). 
	 * @return true si la case est pleine, sinon false
	 */	
	public boolean isPleine() {
		return (this.valeur == '*') ? true : false;
	}
	
	/* 
	 * Retourne une représentation sous forme de chaîne de caractères de la case. 
	 * @return une chaîne de caractères représentant le contenu de la case
	 */
	public String toString() {
		String s= ""+valeur;
		return s;
	}
	
}
