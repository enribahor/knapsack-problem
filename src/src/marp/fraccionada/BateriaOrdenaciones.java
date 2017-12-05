package marp.fraccionada;

import javax.swing.JPanel;

import marp.gui.fraccionada.PanelBateriaOrdenacion;

public class BateriaOrdenaciones {
	/** Realiza una bateria de ordenaciones para un volumen
	 * maximo concreto de objeto: El valor máximo
	 * de los objetos se mantie constante: 1000.
	 */
	public BateriaOrdenaciones(double volumenMaxObjetos, ModoObjetos modo){
		this.volumenMaxObjetos = volumenMaxObjetos;
		this.modo = modo;
	}
	/**Método que ejecuta una bateria de ordenaciones
	 * @return Un panel con todas las ordenaciones y sus tiempos
	 */
	public JPanel executeBateria(){
		GestionOrdenacion gestor = new GestionOrdenacion();
		BateriaIndividual[] bateria = new BateriaIndividual[8];
		ObjetoMochilaDivision[] objetos = GeneradorObjetosDivision.generaObjetosAleatorios(10000,
														volumenMaxObjetos, 1000, modo);
		bateria[0] = new BateriaIndividual(10000, volumenMaxObjetos, 1000.0, 100000, 
				gestor.seleccionMonticulo(objetos.clone(), 100000),
				gestor.ordenacionQuicksort(objetos.clone(), 100000),
				gestor.quickselect(objetos.clone(), 100000),
				gestor.ordenacionMergesort(objetos.clone(), 100000),
				gestor.ordenacionHeapsort(objetos.clone(), 100000), 
				gestor.ordenacionInsercion(objetos.clone(), 100000),
				gestor.ordenacionShellsort(objetos.clone(), 100000));
		
		ObjetoMochilaDivision[] objetos8 = GeneradorObjetosDivision.generaObjetosAleatorios(50000,
				volumenMaxObjetos, 1000, modo);
		
		bateria[1] = new BateriaIndividual(50000, volumenMaxObjetos, 1000.0, 500000, 
				gestor.seleccionMonticulo(objetos8.clone(), 500000),
				gestor.ordenacionQuicksort(objetos8.clone(), 500000),
				gestor.quickselect(objetos8.clone(), 500000),
				gestor.ordenacionMergesort(objetos8.clone(), 500000),
				gestor.ordenacionHeapsort(objetos8.clone(), 500000), 
				-1,	gestor.ordenacionShellsort(objetos8.clone(), 500000));
				
		ObjetoMochilaDivision[] objetos2 = GeneradorObjetosDivision.generaObjetosAleatorios(100000,
				volumenMaxObjetos, 1000, modo);
		
		bateria[2] = new BateriaIndividual(100000, volumenMaxObjetos, 1000.0, 1000000, 
				gestor.seleccionMonticulo(objetos2.clone(), 1000000),
				gestor.ordenacionQuicksort(objetos2.clone(), 1000000),
				gestor.quickselect(objetos2.clone(), 1000000),
				gestor.ordenacionMergesort(objetos2.clone(), 1000000),
				gestor.ordenacionHeapsort(objetos2.clone(), 1000000), -1, 
				gestor.ordenacionShellsort(objetos2.clone(), 1000000));
		
		ObjetoMochilaDivision[] objetos3 = GeneradorObjetosDivision.generaObjetosAleatorios(200000,
				volumenMaxObjetos, 1000,modo);
		bateria[3] = new BateriaIndividual(200000, volumenMaxObjetos, 1000.0, 2000000, 
				gestor.seleccionMonticulo(objetos3.clone(), 2000000),
				gestor.ordenacionQuicksort(objetos3.clone(), 2000000),
				gestor.quickselect(objetos3.clone(), 2000000),
				gestor.ordenacionMergesort(objetos3.clone(), 2000000),
				gestor.ordenacionHeapsort(objetos3.clone(), 2000000),-1,
				gestor.ordenacionShellsort(objetos3.clone(), 2000000));
		
		ObjetoMochilaDivision[] objetos4 = GeneradorObjetosDivision.generaObjetosAleatorios(500000,
				volumenMaxObjetos, 1000,modo);
				
		bateria[4] = new BateriaIndividual(500000, volumenMaxObjetos, 1000.0, 5000000, 
				gestor.seleccionMonticulo(objetos4.clone(), 5000000),
				gestor.ordenacionQuicksort(objetos4.clone(), 5000000),
				gestor.quickselect(objetos4.clone(), 5000000),
				gestor.ordenacionMergesort(objetos4.clone(), 5000000),
				gestor.ordenacionHeapsort(objetos4.clone(), 5000000),
				-1,-1);
		
		ObjetoMochilaDivision[] objetos5 = GeneradorObjetosDivision.generaObjetosAleatorios(1000000,
				volumenMaxObjetos, 1000, modo);
		
		bateria[5] = new BateriaIndividual(1000000, volumenMaxObjetos, 1000.0, 10000000, 
				gestor.seleccionMonticulo(objetos5.clone(), 10000000),
				gestor.ordenacionQuicksort(objetos5.clone(), 10000000),
				gestor.quickselect(objetos5.clone(), 10000000),
				gestor.ordenacionMergesort(objetos5.clone(), 10000000),
				gestor.ordenacionHeapsort(objetos5.clone(), 10000000),
				-1,-1);
				//gestor.ordenacionInsercion(objetos3.clone(), 10000000),
				//gestor.ordenacionShellsort(objetos3.clone(), 10000000));
		ObjetoMochilaDivision[] objetos6 = GeneradorObjetosDivision.generaObjetosAleatorios(2000000,
				volumenMaxObjetos, 1000, modo);
		
		bateria[6] = new BateriaIndividual(2000000, volumenMaxObjetos, 1000.0, 20000000, 
				gestor.seleccionMonticulo(objetos6.clone(), 20000000),
				gestor.ordenacionQuicksort(objetos6.clone(), 20000000),
				gestor.quickselect(objetos6.clone(), 20000000),
				gestor.ordenacionMergesort(objetos6.clone(), 20000000),
				gestor.ordenacionHeapsort(objetos6.clone(), 20000000),
				-1,-1);
		
		ObjetoMochilaDivision[] objetos7 = GeneradorObjetosDivision.generaObjetosAleatorios(4000000,
				volumenMaxObjetos, 1000, modo);
		try{
		bateria[7] = new BateriaIndividual(4000000, volumenMaxObjetos, 1000.0, 40000000, 
				//gestor.seleccionMonticulo(objetos4.clone(), 20000000),
				-1,gestor.ordenacionQuicksort(objetos7.clone(), 40000000),
				gestor.quickselect(objetos7.clone(), 40000000),
				gestor.ordenacionMergesort(objetos7.clone(), 40000000),
				//gestor.ordenacionHeapsort(objetos4.clone(), 20000000),
				-1,-1,-1);
		}catch(Exception e){
			bateria[7] = new BateriaIndividual(4000000, volumenMaxObjetos, 1000.0, 40000000,
														-1,-1,-1,-1, -1, -1, -1);
		}	
		return new PanelBateriaOrdenacion(bateria);		
	}
	
	private double volumenMaxObjetos;
	private ModoObjetos modo;
}
