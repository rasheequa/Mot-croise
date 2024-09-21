package pobj.motx.tme1;
import java.util.List;
import java.util.ArrayList;

/* 
 * La classe Emplacement représente un ensemble de cases 
 * formant un emplacement dans une grille, par exemple un mot horizontal ou vertical.
 */
public class Emplacement {

	private List<Case> cases; // Liste contenant les objets Case constituant l'emplacement.
	
	/* 
	 * Constructeur qui initialise une liste vide de cases. 
	 */	
	public Emplacement() {
		cases = new ArrayList<Case>();
	}
	
	/* 
	 * Ajoute une case à la liste des cases formant l'emplacement.
	 * @param e : la case à ajouter
	 */
	public void add(Case e) {
		cases.add(e);
	}
	
	/* 
	 * Retourne la taille de l'emplacement, c'est-à-dire le nombre de cases qu'il contient.
	 * @return un entier représentant le nombre de cases
	 */
	public int size() {
		return cases.size();
	}
	
	/* 
	 * Retourne la case située à l'index spécifié dans l'emplacement.
	 * @param i : l'index de la case à récupérer
	 * @return la case à l'index i
	 */
	public Case getCase(int i) {
		return cases.get(i);
	}
	
	/* 
	 * Retourne une représentation sous forme de chaîne de caractères de l'emplacement.
	 * La chaîne est formée par les caractères contenus dans les cases de l'emplacement.
	 * @return une chaîne de caractères représentant le contenu de l'emplacement
	 */
	public String toString() {
		String mot = "";
		for (Case c : cases) {
			mot +=  c.getChar(); // Concatène les caractères des cases pour former le mot
		}
		return mot;
	}
}
