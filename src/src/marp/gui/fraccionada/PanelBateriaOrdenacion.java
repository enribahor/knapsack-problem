package marp.gui.fraccionada;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import marp.fraccionada.BateriaIndividual;
import marp.gui.TableModel;

@SuppressWarnings("serial")
public class PanelBateriaOrdenacion extends JPanel {
	public PanelBateriaOrdenacion(BateriaIndividual[] bateria){
		super();
		this.setLayout(new BorderLayout());
		this.setSize(1000, 500);
		TableModel tableModel = new TableModel(new String[] {"NumObjetos",
				"volObjetos", "valorObjetos" , "volMochila",  "monticulo",
				"quickSort", "quickSelection", "mergeSort",
				"heapSort", "insertionSort", "sellSort"});
		//Creamos la JTable y le pasamos la TableModel en el constructor
		JTable table = new JTable(tableModel);
		for (int i = 0; i < bateria.length; i ++){
			
			tableModel.addData(new String[] {String.valueOf(bateria[i].getNumObjetos()),
					String.valueOf(bateria[i].getVolObjetos()),
					String.valueOf(bateria[i].getValorObjetos()),
					String.valueOf(bateria[i].getVolMochila()),
					String.valueOf(bateria[i].getMonticulo()),
					String.valueOf(bateria[i].getQuickSort()),
					String.valueOf(bateria[i].getQuickSelection()),
					String.valueOf(bateria[i].getMergeSort()),
					String.valueOf(bateria[i].getHeapSort()),
					String.valueOf(bateria[i].getInsertionSort()),
					String.valueOf(bateria[i].getSellSort())});
		}
		
		JScrollPane scroll  = new JScrollPane(table);
		
		this.add(scroll);
	}
}
