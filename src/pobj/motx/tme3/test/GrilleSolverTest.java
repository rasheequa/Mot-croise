package pobj.motx.tme3.test;
import pobj.motx.tme3.*;

import org.junit.jupiter.api.Test;

import pobj.motx.tme1.Grille;
import pobj.motx.tme1.GrilleLoader;
import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.GrillePlaces;
import pobj.motx.tme3.csp.CSPSolver;
import pobj.motx.tme3.csp.GrilleContrainte;
import pobj.motx.tme3.csp.ICSP;
import pobj.motx.tme3.csp.adapt.MotX;

public class GrilleSolverTest {

	@Test
	public void testHard() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/easy.grl");

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrilleContrainte gp = new GrilleContrainte(grille, gut);
		
		ICSP problem = new MotX(gp);
		CSPSolver solver = new CSPSolver();

		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);

		System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}

}
