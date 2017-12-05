package marp.gui.fraccionada;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MenuMochilaDivision extends JFrame{
	public MenuMochilaDivision() {
		super();
		initializeGUI();
	}

	public void initializeGUI() {
		this.setLayout(new GridLayout(3, 1, 3, 15));
		botones = new JButton[3];

		botones[0] = new JButton("Bateria de pruebas") {
			{
				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {						
						new BateriaPruebasDivision();
					}
				});
			}
		};

		botones[1] = new JButton("Objetos aleatorios") {
			{
				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ConfiguraMochilaAleatoria mochila = new ConfiguraMochilaAleatoria();
						mochila.setVisible(true);
					}
				});
			}
		};

		botones[2] = new JButton("Introducción manual") {
			{

				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ConfiguraMochilaManual mochila = new ConfiguraMochilaManual();
						mochila.setVisible(true);
					}

				});

			}

		};
		
		for (JButton b : botones)
			this.add(b);
		this.setSize(300,300);
		this.setLayout(new GridLayout(3,1));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	private JButton[] botones;
}

