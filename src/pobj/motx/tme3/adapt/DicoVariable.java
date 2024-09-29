package pobj.motx.tme3.adapt;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme2.Dictionnaire;
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
	public List<String> getDomain(){
		
		List<String> list = new ArrayList<String>();
		Dictionnaire dico =  grille.getMotsPot().get(indice);
		
		for(int i= 0;i<dico.size();i++) {
			list.add(dico.get(i));
		}
		
		return list;
	}

	
	public int getIndex() { return indice; }
	
	@Override
	public String toString() {
		StringBuilder s=new StringBuilder();
		for(int i=0;i<getDomain().size();i++) {
			if(i==getDomain().size()-1) {
				s.append(getDomain().get(i));
			}
			else {
				s.append(getDomain().get(i)).append(",");
			}
		}
		return s.toString();
	}

}
