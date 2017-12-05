package marp.gui.fraccionada;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import marp.fraccionada.ObjetoMochilaDivision;


@SuppressWarnings("serial")
public class ConfiguraMochilaManual extends JFrame {
	public ConfiguraMochilaManual() {
		super();
		initializeGUI();
	}

	public void initializeGUI() {
		
		ventana = this;
		panelPrincipal = new JPanel();
		
		this.objetos = new Vector<ObjetoMochilaDivision>();

		JButton botonAddObject = new JButton("Añadir objeto") {
			{
				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new CrearObjetoManualmente(ventana);
					}
				});
			}
		};
		this.add(botonAddObject, BorderLayout.NORTH);
		
		texto = new JTextArea("Objetos");
		texto.setEditable(false);
		JScrollPane scroll  = new JScrollPane(texto,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelPrincipal.add(scroll);
		
		JButton botonLlenar = new JButton("Llenar mochila") {
			{

				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new LlenarMochilaManual(objetos);
						ventana.setVisible(false);
					}

				});

			}

		};
		this.add(botonLlenar, BorderLayout.SOUTH);
		
		this.add(panelPrincipal);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
		public void meteNuevoObjeto(ObjetoMochilaDivision obj){
			objetos.add(obj);
			String t = texto.getText();
			t = t + LINE_SEPARATOR + obj.getName();
			texto.setText(t);
			this.pack();
		}
		
		private JTextArea texto;
		private JPanel panelPrincipal;
		private ConfiguraMochilaManual ventana;
		private Vector<ObjetoMochilaDivision> objetos;
	
		
		private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	}