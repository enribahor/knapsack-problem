package marp.fraccionada;

import marp.Ordena;

public final class GeneradorObjetosDivision 

{
	/**Dado in número de objetos, un tamaño máximo para cada objeto,
	 * y un valor máximo para cada objeto,
	 * devuelve un array de objetos que cumple
	 * las condiciones especificadas con objetos aleatorios
	 * @param numOb
	 * @param tamMaxObjetos
	 * @param valorMaxObjetos
	 * @return
	 */
	public static ObjetoMochilaDivision[] generaObjetosAleatorios(int numOb, double tamMaxObjetos,
					double valorMaxObjetos, ModoObjetos modo){
		
		ObjetoMochilaDivision objetos[] = new ObjetoMochilaDivision[numOb];
		for (int i = 0; i < numOb; i++){
			objetos[i] = new ObjetoMochilaDivision(Math.random()*valorMaxObjetos, 
					Math.random()*tamMaxObjetos,"" + i);
		}
		switch(modo){
			case ORDENADOS:
				Ordena.quicksort(objetos);
				return objetos;
			case ORDENADOS_INVERSO:
				Ordena.quicksortInverso(objetos);
				return objetos;
			default:
				return objetos;
		}
	
	}
		
}
