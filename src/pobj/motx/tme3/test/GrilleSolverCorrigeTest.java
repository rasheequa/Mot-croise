//package pobj.motx.tme3.test;
//import pobj.motx.tme3.*;
//import pobj.motx.tme3.adapt.MotX;
//
//import org.junit.jupiter.api.Test;
//
//import pobj.motx.tme1.Grille;
//import pobj.motx.tme1.GrilleLoader;
//import pobj.motx.tme2.Dictionnaire;
//import pobj.motx.tme2.GrillePlaces;
//
//
//public class GrilleSolverCorrigeTest {
//
//	@Test
//	public void testHard() {
//		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
//		Grille gr = GrilleLoader.loadGrille("data/hard.grl");
//
//		System.out.println(gr);
//
//		GrillePlaces grille = new GrillePlaces(gr);
//		GrilleContrainte gp = new GrilleContrainte(grille, gut);
//		
//		// System.out.println(gp);
//		// assertTrue(! gp.isDead());
//
//		ICSP problem = new MotX(gp);
//		CSPSolverCorrige solver = new CSPSolverCorrige(); 
//
//		// solver.setStrat(new StratFirst());
//		// solver.setStrat(new StratMin());
//		
//		long timestamp = System.currentTimeMillis();
//		ICSP solution = solver.solve(problem);
//
//		System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
//	}
//
//}
