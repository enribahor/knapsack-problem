package marp.entera;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import marp.gui.TableModel;

@SuppressWarnings("serial")
public class MochilaEntera extends Vector<ObjetoMochilaEntera>{
	
	public MochilaEntera(int volumenMax){
		super();
		this.volumenMax = volumenMax;
	}
	
	public boolean insertar(ObjetoMochilaEntera obj){	
		if (obj == null)
			return false;
		
		else if (volumenOcupado + obj.getVolumen() <= volumenMax){
			//El objeto cabe entero sin problema.
			this.add(obj);
			//Actualizamos el beneficio de la mochila
			setBeneficio(getBeneficio() + obj.getValorTotal());
			volumenOcupado += obj.getVolumen();
			return true;			
		}
		else 
			return false;
	}
	
	public void mostrarMochila(){
		//En esta version por ahora se muestra por pantalla
		for (ObjetoMochilaEntera obj: this){
			obj.mostrarObjeto();
		}
	}
	public JPanel panelMochila(){
		JPanel panel = new JPanel();
		JTextArea texto = new JTextArea();
		JScrollPane scroll  = new JScrollPane(texto,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		String t = "MOCHILA"+LINE_SEPARATOR+"----------";
		for (ObjetoMochilaEntera obj: this)
			t = t + LINE_SEPARATOR + obj.getName() ;
		texto.setText(t);
		texto.setEditable(false);
		panel.add(scroll);
		return panel;
		
	}
	public JPanel tablaMochila(){
		TableModel tableModel = new TableModel(new String[] {"Objeto","Volumen", "ValorTotal"});
		//Creamos la JTable y le pasamos la TableModel en el constructor
		JTable table = new JTable(tableModel);
		
		for (ObjetoMochilaEntera o: this){
			tableModel.addData(o.getName(),
					String.valueOf(o.getVolumen()),
					String.valueOf(o.getValorTotal()));
		}
		JScrollPane scroll  = new JScrollPane(table, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JPanel panel = new JPanel();
		panel.add(scroll);
		return panel;
		
	}
	public int getBeneficio() {
		return beneficio;
	}

	private void setBeneficio(int beneficio) {
		this.beneficio = beneficio;
	}
	
	private int volumenOcupado = 0;
	private int volumenMax;
	private int beneficio = 0;
	
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
}
