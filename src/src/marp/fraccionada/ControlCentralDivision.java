package marp.fraccionada;


public class ControlCentralDivision {
		/**Clase encargada de recibiendo unos parámetros para los
		 * objetos, contruir los objetos, pasárselos al gestor de
		 * ordenación y devolver los datos obtenidos.
		 */
	public ControlCentralDivision(double tamMochila, int numOb,
					double tamMaxObjetos, double valorMaxObjetos){
		objetos = GeneradorObjetosDivision.generaObjetosAleatorios(numOb, tamMaxObjetos,
														valorMaxObjetos, ModoObjetos.SIN_ORDEN);
		this.tamMochila = tamMochila;
	}
	
	
	public MochilaDivision getMochila() {
			return mochila;
		}
	public ObjetoMochilaDivision[] getObjetos(){
		return this.objetos;
	}

	public void executeSimulation() {
		GestionOrdenacion gestor = new GestionOrdenacion();
		mochila = gestor.mochilaOrdenada(objetos, tamMochila);
		
		/*finalData = new JLabel("Los tiempo de resolución del problema: " +
				"Esto es una prueba: " + gestor.seleccionMonticulo(objetos, tamMochila) + " ns" +
				"" +
				"" +
				"" +
				"" +
				"" +
				"");*/
	}


	/*public JLabel getFinalData() {
		
		return finalData;
	}*/
	//private JLabel finalData;
	private ObjetoMochilaDivision[] objetos;
	private double tamMochila;
	private MochilaDivision mochila;
}
