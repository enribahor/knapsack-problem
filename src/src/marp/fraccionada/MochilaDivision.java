package marp.fraccionada;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import marp.gui.TableModel;

@SuppressWarnings("serial")
public class MochilaDivision extends Vector<ObjetoMochilaDivision>{
	
	public MochilaDivision(double volumenMax){
		super();
		this.volumenMax = volumenMax;
	}
	
	public boolean insertar(ObjetoMochilaDivision obj){	
		if (obj == null)
			return false;
		else if (volumenOcupado == volumenMax)
			return false;	//La mochila ya está llena.
		
		
		else if (volumenOcupado + obj.getVolumen() < volumenMax){
			//El objeto cabe entero sin problema.
			this.add(obj);
			//Actualizamos el beneficio de la mochila
			setBeneficio(getBeneficio() + obj.getDensidadValor()*obj.getVolumen());
			volumenOcupado += obj.getVolumen();
			return true;
		}
		else{
			//El objeto cabe pero no entero: Solo válido para la version 
			// en la que podemos dividir los objetos

			double volumenRestante = volumenMax - volumenOcupado;
			this.add(new ObjetoMochilaDivision(obj.getDensidadValor(), volumenRestante, obj.getName()));
			setBeneficio(getBeneficio() + volumenRestante*obj.getDensidadValor());
			volumenOcupado = volumenMax;
			return true;
			
		}
	}
	public void mostrarMochila(){
		//En esta version por ahora se muestra por pantalla
		for (ObjetoMochilaDivision obj: this){
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
		for (ObjetoMochilaDivision obj: this)
			t = t + LINE_SEPARATOR + obj.getName() ;
		texto.setText(t);
		texto.setEditable(false);
		panel.add(scroll);
		return panel;
		
	}
	public JPanel tablaMochila(){
		TableModel tableModel = new TableModel(new String[] {"Objeto","Volumen", "Valor/volumen"});
		//Creamos la JTable y le pasamos la TableModel en el constructor
		JTable table = new JTable(tableModel);
		
		for (ObjetoMochilaDivision o: this){
			tableModel.addData(o.getName(),
					String.valueOf(o.getVolumen()),
					String.valueOf(o.getDensidadValor()));
		}
		JScrollPane scroll  = new JScrollPane(table, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JPanel panel = new JPanel();
		panel.add(scroll);
		return panel;
		
	}
	public double getBeneficio() {
		return beneficio;
	}

	private void setBeneficio(double beneficio) {
		this.beneficio = beneficio;
	}
	
	private double volumenOcupado = 0;
	private double volumenMax;
	private double beneficio = 0;
	
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
}
