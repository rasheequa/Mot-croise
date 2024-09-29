package pobj.motx.tme3.adapt;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Emplacement;
import pobj.motx.tme3.GrilleContrainte;
import pobj.motx.tme3.ICSP;
import pobj.motx.tme3.IVariable;

public class MotX implements ICSP {
	public List<IVariable> dicoVariable;
	public GrilleContrainte grilleContrainte;
	
	public MotX(GrilleContrainte gc) {
		this.dicoVariable=new ArrayList<>();
		List<Emplacement> emplacement = gc.getGrille().getPlaces();
		for (int i = 0; i < emplacement.size(); i++) {
            if (emplacement.get(i).hasCaseVide()) {
                dicoVariable.add(new DicoVariable(i, gc));
            }
		}
		this.grilleContrainte=gc;
	}
	
	@Override
	public List<IVariable> getVars() {
		return dicoVariable;
	}

	@Override
	public boolean isConsistent() {
		for(IVariable v : dicoVariable) {
			if(v.getDomain().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ICSP assign(IVariable vi, String val) {
		MotX mot = null;
		if(vi instanceof DicoVariable) {
			DicoVariable dicovi = (DicoVariable)vi;
			mot =  new MotX(grilleContrainte.fixer(dicovi.getIndex(), val));
			
		}
		return (ICSP) mot;
	}

}
