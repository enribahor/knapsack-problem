package marp.gui.fraccionada;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import marp.fraccionada.ControlCentralDivision;

@SuppressWarnings("serial")
public class MochilaObjetosAleatorios extends JFrame{
	public MochilaObjetosAleatorios(double tamMochila, int numOb, double tamObjetos, double valObj){
		super();
		this.tamMochila = tamMochila;
		this.numObjetos = numOb;
		this.tamMaxObjetos =  tamObjetos;
		this.valObjetos = valObj;
		inicializaMochila();
		
	}
	
	public void inicializaMochila(){
		this.setLayout(new BorderLayout());
		JPanel datos = new JPanel(new GridLayout(3,2));
		this.add(datos, BorderLayout.NORTH);
		datos.add(new JLabel("	\t Volumen de la mochila: " + tamMochila + " unidades"));
		datos.add(new JLabel("	Tenemos " + numObjetos + " objetos"));
		datos.add(new JLabel("	\t Volumen maximo de cada objeto: " + tamMaxObjetos + " unidades	"));
		datos.add(new JLabel("	Valor maximo de cada objeto: " + valObjetos ));
		datos.add(new JLabel("	Objetos:	" ));
		
		JPanel panelCentro = new JPanel();
		this.add(panelCentro);
		ControlCentralDivision controlCentral = new ControlCentralDivision(tamMochila, numObjetos,
													tamMaxObjetos, valObjetos);
		controlCentral.executeSimulation();
		datos.add(new JLabel("	Mochila: "+"Beneficio total: "+ controlCentral.getMochila().getBeneficio() ));
		
		JPanel panelCentral = new JPanel(new GridLayout(1, 2, 3, 15));
		panelCentral.add(new TablaObjetosDivision(controlCentral.getObjetos()), BorderLayout.CENTER);
		panelCentral.add(controlCentral.getMochila().tablaMochila());
		this.add(panelCentral);
		this.pack();
	}
	
	double[] objetos;	//Cada objeto lleva asociado un valor
	double tamMochila;
	int numObjetos;
	double tamMaxObjetos;
	double valObjetos;
}

