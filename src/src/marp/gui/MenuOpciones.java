package marp.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import marp.gui.entera.MenuMochilaEntera;
import marp.gui.fraccionada.MenuMochilaDivision;


@SuppressWarnings("serial")
/**
 * Presenta las distintas opciones que permite el programa
 */
public class MenuOpciones extends JPanel {

	public MenuOpciones() {
		super();
		initializeGUI();
	}

	public void initializeGUI() {
		this.setLayout(new GridLayout(3, 1, 3, 15));
		
		botones = new JButton[3];
		botones[0] = new JButton("Mochila entera") {
			{
				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new MenuMochilaEntera();
					}
				});
			}
		};

		botones[1] = new JButton("Mochila real") {
			{
				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						//new MochilaReal();
					}
				});
			}
		};

		botones[2] = new JButton("Mochila con división de objetos") {
			{

				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new MenuMochilaDivision();
					}

				});

			}

		};
		
		for (JButton b : botones)
			this.add(b);
	}
	
	private JButton[] botones;
}
