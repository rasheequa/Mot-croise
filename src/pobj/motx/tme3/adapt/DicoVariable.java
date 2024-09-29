package pobj.motx.tme3.adapt;

import java.util.List;

import pobj.motx.tme3.GrilleContrainte;
import pobj.motx.tme3.IVariable;

public class DicoVariable implements IVariable {
	public int indice;
	public GrilleContrainte grille;
	
	public DicoVariable(int index, GrilleContrainte gp) {
		this.indice=index;
		this.grille=gp;
	}
	
	@Override
	public List<String> getDomain() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		return;
	}

}
