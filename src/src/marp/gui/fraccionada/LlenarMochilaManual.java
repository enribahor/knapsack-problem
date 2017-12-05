package marp.gui.fraccionada;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import marp.fraccionada.GestionOrdenacion;
import marp.fraccionada.MochilaDivision;
import marp.fraccionada.ObjetoMochilaDivision;

@SuppressWarnings("serial")
public class LlenarMochilaManual extends JFrame{
	public LlenarMochilaManual(Vector<ObjetoMochilaDivision> mochila){
		super();
		configurarCapacidad();
		objetos = new ObjetoMochilaDivision[mochila.size()];
		int i = 0;
		for (ObjetoMochilaDivision o : mochila){
			objetos [i] = o;
			i++;
		}
			
	}
	public void configurarCapacidad(){
		selCapacidad = new JFrame();
	
		selCapacidad.add(new JLabel("Indique el volumen de la mochila:"), BorderLayout.NORTH);
		selCapacidad.add(tamMochila);
		selCapacidad.add(new JButton("Llenar") {
			{
				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try{
							capacidad = Double.valueOf(tamMochila.getText());
							
							selCapacidad.setVisible(false);
							llenarMochila();
						}catch(Exception excepcion){
								JOptionPane.showMessageDialog(selCapacidad, "Debe introducir un número");
						}
								
					}
					

				
				});
				
			}

		}, BorderLayout.SOUTH);
		selCapacidad.setLocationRelativeTo(null);
		selCapacidad.pack();
		selCapacidad.setVisible(true);
	}
	private void llenarMochila(){
		GestionOrdenacion gestor = new GestionOrdenacion();
		MochilaDivision m = gestor.mochilaOrdenada(objetos, capacidad);
		
		this.add(m.panelMochila());	
		
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	private JFrame selCapacidad;
	private double capacidad;
	private JTextField tamMochila = new JTextField(10);
	private ObjetoMochilaDivision[] objetos;
}
