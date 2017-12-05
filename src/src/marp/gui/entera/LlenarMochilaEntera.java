package marp.gui.entera;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import marp.entera.GestionEntera;
import marp.entera.MochilaEntera;
import marp.entera.ObjetoMochilaEntera;

@SuppressWarnings("serial")
public class LlenarMochilaEntera extends JFrame{
	public LlenarMochilaEntera(Vector<ObjetoMochilaEntera> mochila){
		super();
		configurarCapacidad();
		objetos = new ObjetoMochilaEntera[mochila.size()];
		int i = 0;
		for (ObjetoMochilaEntera o : mochila){
			objetos [i] = o;
			i++;
		}
			
	}
	public void configurarCapacidad(){
		selCapacidad = new JFrame();
	
		selCapacidad.add(new JLabel("Indique el volumen de la mochila (entero):"), BorderLayout.NORTH);
		selCapacidad.add(tamMochila);
		selCapacidad.add(new JButton("Llenar") {
			{
				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try{
							capacidad = Integer.valueOf(tamMochila.getText());
							
							selCapacidad.setVisible(false);
							llenarMochila();
						}catch(Exception excepcion){
								JOptionPane.showMessageDialog(selCapacidad, "Debe introducir un número entero");
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
		GestionEntera gestor = new GestionEntera();
		MochilaEntera m = gestor.mochilaLlena(objetos, capacidad);
		
		this.add(m.panelMochila());	
		
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	private JFrame selCapacidad;
	private int capacidad;
	private JTextField tamMochila = new JTextField(10);
	private ObjetoMochilaEntera[] objetos;
}

