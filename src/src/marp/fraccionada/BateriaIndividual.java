package marp.fraccionada;

public class BateriaIndividual {
	/** Corresponde a una ejecución de
	 *  simulación para
	 *  unos datos concretos
	 */
	public BateriaIndividual(int numObjetos, double volObjetos,
							double valorObjetos, double volMochila,  double monticulo,
							double quickSort, double quickSelection, double mergeSort,
							double heapSort, double insertionSort, double sellSort){
		
		this.setNumObjetos(numObjetos);
		this.setVolObjetos(volObjetos);
		this.setValorObjetos(valorObjetos);
		this.setVolMochila(volMochila);
		this.setMonticulo(monticulo);
		this.setQuickSort(quickSort);
		this.setQuickSelection(quickSelection);
		this.setMergeSort(mergeSort);
		this.setHeapSort(heapSort);
		this.setInsertionSort(insertionSort);
		this.setSellSort(sellSort);	
	}
	public int getNumObjetos() {
		return numObjetos;
	}
	public void setNumObjetos(int numObjetos) {
		this.numObjetos = numObjetos;
	}
	public double getVolObjetos() {
		return volObjetos;
	}
	public void setVolObjetos(double volObjetos) {
		this.volObjetos = volObjetos;
	}
	public double getValorObjetos() {
		return valorObjetos;
	}
	public void setValorObjetos(double valorObjetos) {
		this.valorObjetos = valorObjetos;
	}
	public double getVolMochila() {
		return volMochila;
	}
	public void setVolMochila(double volMochila) {
		this.volMochila = volMochila;
	}
	public double getMonticulo() {
		return monticulo;
	}
	public void setMonticulo(double monticulo) {
		this.monticulo = monticulo;
	}
	public double getQuickSort() {
		return quickSort;
	}
	public void setQuickSort(double quickSort) {
		this.quickSort = quickSort;
	}
	public double getQuickSelection() {
		return quickSelection;
	}
	public void setQuickSelection(double quickSelection) {
		this.quickSelection = quickSelection;
	}
	public double getMergeSort() {
		return mergeSort;
	}
	public void setMergeSort(double mergeSort) {
		this.mergeSort = mergeSort;
	}
	public double getHeapSort() {
		return heapSort;
	}
	public void setHeapSort(double heapSort) {
		this.heapSort = heapSort;
	}
	public double getInsertionSort() {
		return insertionSort;
	}
	public void setInsertionSort(double insertionSort) {
		this.insertionSort = insertionSort;
	}
	public double getSellSort() {
		return sellSort;
	}
	public void setSellSort(double sellSort) {
		this.sellSort = sellSort;
	}
	private int numObjetos;
	private double volObjetos;
	private double valorObjetos;
	private double volMochila;
	
	private double monticulo;
	private double quickSort;
	private double quickSelection;
	private double mergeSort;
	private double heapSort;
	private double insertionSort;
	private double sellSort;
}
