package marp;

import java.util.Comparator;

import marp.fraccionada.ObjetoMochilaDivision;

public class ComparaObjetos implements Comparator<ObjetoMochilaDivision>{

	@Override
	public int compare(ObjetoMochilaDivision o1, ObjetoMochilaDivision o2) {
		return o2.compareTo(o1);
	}

}
