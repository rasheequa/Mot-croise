package pobj.motx.tme3.adapt;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme3.GrilleContrainte;
import pobj.motx.tme3.ICSP;
import pobj.motx.tme3.IVariable;

public class MotX implements ICSP {
	public List<DicoVariable> dicoVariable;
	public GrilleContrainte grilleContrainte;
	
	public MotX(GrilleContrainte gc) {
		this.dicoVariable=new ArrayList<>();
		this.grilleContrainte=gc;
	}
	
	@Override
	public List<IVariable> getVars() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isConsistent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ICSP assign(IVariable vi, String val) {
		// TODO Auto-generated method stub
		return null;
	}

}
