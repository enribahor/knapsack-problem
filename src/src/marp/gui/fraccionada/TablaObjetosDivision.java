package marp.gui.fraccionada;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import marp.fraccionada.ObjetoMochilaDivision;
import marp.gui.TableModel;

@SuppressWarnings("serial")
public class TablaObjetosDivision extends JPanel{
	public TablaObjetosDivision(ObjetoMochilaDivision[] objetos){
		super();
		TableModel tableModel = new TableModel(new String[] {"Objeto","Volumen", "Valor/volumen"});
		//Creamos la JTable y le pasamos la TableModel en el constructor
		JTable table = new JTable(tableModel);
		for (int i = 0; i < objetos.length; i ++){
			tableModel.addData(objetos[i].getName(),
					String.valueOf(objetos[i].getVolumen()),
					String.valueOf(objetos[i].getDensidadValor()));
		}
		
		JScrollPane scroll  = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(scroll);
		
	}
	
}
