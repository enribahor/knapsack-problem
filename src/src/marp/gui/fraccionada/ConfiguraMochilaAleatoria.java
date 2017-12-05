package marp.gui.fraccionada;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import marp.gui.spring.SpringUtilities;

@SuppressWarnings("serial")
public class ConfiguraMochilaAleatoria extends JFrame {
	
	public ConfiguraMochilaAleatoria(){
		super();
		ventana = this;
		ventana.setLocationRelativeTo(null);
		JPanel configuracion = new JPanel();
		configuracion.setLayout(new SpringLayout());
		
		JLabel tamMochila = new JLabel ("Volumen de la mochila: ");
		configuracion.add(tamMochila);
		configuracion.add(tamMaximoMochila);
		
		JLabel numObj = new JLabel ("Número de objetos:");
		configuracion.add(numObj);
		configuracion.add(this.numObjetos);
		
		JLabel tamObj = new JLabel("Volumen máximo de cada objeto: ");
		configuracion.add(tamObj);
		configuracion.add(this.tamMaximoObjetos);
		
		JLabel valObj = new JLabel("Valor máximo de cada objeto: ");
		configuracion.add(valObj);
		configuracion.add(this.valMaximoObjetos);
		
		SpringUtilities.makeCompactGrid(configuracion, 4, 2, 6, 6, 10, 10);
		//this.add(reserva, BorderLayout.CENTER);
		
		this.add(new JButton("Simular") {
			{
				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try{
							MochilaObjetosAleatorios mochila = new MochilaObjetosAleatorios(
									Double.valueOf(tamMaximoMochila.getText()),
									Integer.valueOf(numObjetos.getText()),	
									Double.valueOf(tamMaximoObjetos.getText()),
									Double.valueOf(valMaximoObjetos.getText()));
						mochila.setVisible(true);
						ventana.setVisible(false);
						}catch(Exception excepcion){
								JOptionPane.showMessageDialog(ventana, "Debe rellenar correctamente todos los datos");
						}
								
					}
					

				
				});
				
			}

		}, BorderLayout.SOUTH);
		this.add(configuracion);
		this.pack();
	}
		private JFrame ventana;	
		private JTextField tamMaximoMochila = new JTextField(10);
		private JTextField numObjetos = new JTextField(10);
		private JTextField tamMaximoObjetos = new JTextField(10);
		private JTextField valMaximoObjetos = new JTextField(10);
	}