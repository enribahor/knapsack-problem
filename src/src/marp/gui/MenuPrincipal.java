package marp.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Presenta las opciones del programa. Inicialmente solo una: Entrar
 * @author Enrique Ballestero
 */


@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame  {
	
	public void initializeGUI(){
		this.setLayout(new BorderLayout());
		menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		JMenuItem quit = new JMenuItem("Quit");
		menu.add(quit);
		quit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				CloseApp.quitApp();		
			}
			
		});
		this.setJMenuBar(menuBar);	
	
		front = new JPanel();
		front.setLayout(new GridLayout(1,1, 3, 3));//Queda mejor así la imagen
		ImageIcon fotoMochila = createImageIcon("images/mochilaMarp.jpg", "MOCHILA");
		JLabel foto = new JLabel(fotoMochila);
		foto.setSize(20, 20);
		front.add(foto);
		
		south = new JPanel();
		south.add(new JButton("Comenzar") {
			{
				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						mostrarMenu();			
					}

				
				});
				
			}

		});
		this.add(front);
		this.add(south, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	
	public MenuPrincipal() {	
		super("Algoritmo de la mochila");
		this.setSize(700, 700);
		initializeGUI();
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}

	private void mostrarMenu(){

		this.remove(front);
		this.remove(south);
		this.setSize(650,400);
		MenuOpciones opciones = new MenuOpciones();
		this.add(opciones);
		
	}

	//Crea la imagen principal, la mochila.
	
	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	
	private JMenuBar menuBar;
	private JPanel front;
	private JPanel south;
		
}