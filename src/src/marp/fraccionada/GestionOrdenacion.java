package marp.fraccionada;

import java.util.PriorityQueue;

import marp.ComparaObjetos;
import marp.Ordena;

public class GestionOrdenacion {
	/** Clase que se encarga de la gestión de las ordenaciones
	 * Dado un array de objetos y un tamaño de mochila, 
	 * devuelve el tiempo que tarda el
	 * algoritmo en tener la mochila llena
	 */
	public MochilaDivision mochilaOrdenada(ObjetoMochilaDivision[] o , double tam){
		MochilaDivision mochila = new MochilaDivision(tam);
		this.ordenacionQuicksort(o, tam);
		int j = 0;
		while(j < o.length && mochila.insertar(o[j]))
			j++;
		return mochila;
	}
	public double ordenacionInsercion(ObjetoMochilaDivision[] o, double tam){
		MochilaDivision mochila = new MochilaDivision(tam);
		double time = System.currentTimeMillis();
		Ordena.insertionSort(o);
		int i = 0;
		while(i < o.length && mochila.insertar(o[i]))
			i++;
		return System.currentTimeMillis()-time;
	}
	public double ordenacionShellsort(ObjetoMochilaDivision[] o, double tam){
		MochilaDivision mochila = new MochilaDivision(tam);
		double time = System.currentTimeMillis();
		Ordena.shellsort(o);
		int i = 0;
		while(i < o.length && mochila.insertar(o[i]))
			i++;
		return System.currentTimeMillis()-time;
	}
	public double ordenacionHeapsort(ObjetoMochilaDivision[] o, double tam){
		MochilaDivision mochila = new MochilaDivision(tam);
		double time = System.currentTimeMillis();
		Ordena.heapsort(o);
		int i = 0;
		while(i < o.length && mochila.insertar(o[i]))
			i++;
		return System.currentTimeMillis()-time;
	}
	public double ordenacionMergesort(ObjetoMochilaDivision[] o, double tam){
		MochilaDivision mochila = new MochilaDivision(tam);
		double time = System.currentTimeMillis();
		Ordena.mergeSort(o);
		int i = 0;
		while(i < o.length && mochila.insertar(o[i]))
			i++;
		return System.currentTimeMillis()-time;
	}
	public double ordenacionQuicksort(ObjetoMochilaDivision[] o, double tam){
		MochilaDivision mochila = new MochilaDivision(tam);
		double time = System.currentTimeMillis();
		Ordena.quicksort(o);
		int i = 0;
		while(i < o.length && mochila.insertar(o[i]))
			i++;
		return System.currentTimeMillis()-time;
	}
	
	public double seleccionMonticulo(ObjetoMochilaDivision[] o, double tam){
		MochilaDivision mochila = new MochilaDivision(tam);
		double time = System.currentTimeMillis();
		PriorityQueue<ObjetoMochilaDivision> monticulo = new PriorityQueue<ObjetoMochilaDivision>();
		for (ObjetoMochilaDivision objeto: o)
			monticulo.add(objeto);
		while (!monticulo.isEmpty()&&mochila.insertar(monticulo.poll())){}
		
		return System.currentTimeMillis()-time;		
	}
	public double quickselect(ObjetoMochilaDivision[] o, double tam){
		MochilaDivision mochila1 = new MochilaDivision(tam);
		MochilaDivision mochila2 = new MochilaDivision(tam);
		double time = System.currentTimeMillis();
		int objeto = (int) (Math.random()*o.length);
		ObjetoMochilaDivision pivote = o[objeto];
		boolean fin = false;
		MochilaDivision mochila3 = mochila2;
		for (int i = 0; i < o.length && !fin; i++){
			if (o[i].getDensidadValor()>= pivote.getDensidadValor())
				fin = !mochila2.add(o[i]);
		}
		if (fin = true){}
		int k = 0;
		while(k < o.length && mochila1.insertar(o[k]))
			k++;
		if(k == o.length)
			//Si se da este caso, todos los objetos cabían en la mochila
			return System.currentTimeMillis()-time;
		else{
			//Si estamos aquí, sabemos que con k+1 objetos llenamos seguro la mochila
			//Usamos el quickSelect para quedarnos con el k+1-ésimo mayor
			Ordena.quickSelect(o,k+1);
			PriorityQueue<ObjetoMochilaDivision> heap = new PriorityQueue<ObjetoMochilaDivision>(o.length, new ComparaObjetos());
			for (int i = 0; i < o.length; i++){
				if(o[i].getDensidadValor()>= o[k].getDensidadValor()){
						heap.add(o[i]);
				}		
			}
			while(mochila2.insertar(heap.poll()));
		return System.currentTimeMillis()-time;
		}
	}
	
}
