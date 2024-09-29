package pobj.motx.tme2;
import java.util.List;
import java.util.ArrayList;
public class EnsembleLettre {
	private List <Character> list = new ArrayList<Character>();
	
	public void add(char c) {
		if(!list.contains(c)) {
			list.add(c);
		}
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean contains(char c) {
		return list.contains(c);
	}
	
	public List<Character> getEnsemble() {
		return list;
	}
	
	private EnsembleLettre copy() {
		EnsembleLettre e = new EnsembleLettre();
		for(Character c : list) {
			e.add(c);
		}
		return e;
	}
	
	public EnsembleLettre inter(EnsembleLettre e) {
		EnsembleLettre ensemble = this.copy();
		ensemble.list.retainAll(e.list);
		return ensemble;
	}
	
}