package marp.gui;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel {
	
	//Constructor que crea las columnas con sus nombres, que se pasan en un array
	public TableModel(String[] colNames) {
		this.columnNames = new String[colNames.length];
		for(int i = 0; i < colNames.length; i++) 
			this.columnNames[i] = colNames[i];
		this.data = new String[0][colNames.length];
		this.numElems = 0;
	}
	
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	@Override
	public int getRowCount() {
		return this.data.length;
	}

	@Override
	public int getColumnCount() {
		return this.columnNames.length;
	}

	@Override
	public String getValueAt(int row, int col) {
		return this.data[row][col];
	}
	
	//Cambia o fija el valor de (row, col)
	public void setValueAt(String cad, int row, int col) {
		this.data[row][col] = cad;
		this.fireTableCellUpdated(row, col);
		this.fireTableDataChanged();
		/*Este ultimo método notifica a los listeners
		  que la tabla ha cambiado y la redibuja */
	}
	
	//Al ampliar la tabla se añade un hueco mas
	private void ampliaTabla() {
		String nuevaTabla[][] = new String[numElems + 1][columnNames.length];
		for(int i= 0; i < numElems; i++) {
			for(int j = 0; j < columnNames.length; j++)
				nuevaTabla[i][j] = this.data[i][j];
		}
		this.data = nuevaTabla;
	}
	
	//Cuando añadimos un objeto se amplia la tabla y se añade
	public void addData(String nombre, String volumen, String valor) {
		if(getRowCount() == numElems)
			ampliaTabla();
		setValueAt(nombre, numElems, 0);
		setValueAt(volumen, numElems, 1);
		setValueAt(valor, numElems, 2);
		numElems++;
	}
	//Cuando añadimos un objeto se amplia la tabla y se añade
	public void addData(String[] nuevoDato) {
		if(getRowCount() == numElems)
			ampliaTabla();
		for(int j = 0; j < columnNames.length; j++)
			setValueAt(nuevoDato[j], numElems, j);
			
		numElems++;
	}
	
	//Busca un elemento en la tabla (para el Undo)
	private int findData(String id) {
		for (int i = 0; i < numElems; i++)
			if (id.equalsIgnoreCase(data[i][0]))
				return i;
		return -1;
	}
	
	//Busca el elemento y si lo encuentra lo elimina
	public void deleteItem(String id) {
		int row = findData(id);
		if(row >= 0) 
			removeData(row);
	}
	
	//Para borrar, se crea la tabla con un elemnto menos y se copian
	public void removeData(int row) { 
		String nuevaTabla[][] = new String[numElems - 1][columnNames.length];
		for (int i = 0; i < row; i++){
			nuevaTabla[i][0] = this.data[i][0];
			nuevaTabla[i][1] = this.data[i][1];
		}
		for(int i = row; i < numElems - 1; i++) {
			nuevaTabla[i][0] = this.data[i+1][0];
			nuevaTabla[i][1] = this.data[i+1][1];
		}
		this.data = nuevaTabla;		
		numElems--;
		this.fireTableDataChanged();
	}
	public void actualizarTabla(String[][] nuevosDatos, int numDatos ){
		data = nuevosDatos;
		numElems = numDatos;
		this.fireTableDataChanged();
	}
	
	private String[] columnNames;
	private String[][] data;
	private int numElems;
}
