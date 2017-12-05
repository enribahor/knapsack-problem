package marp.gui.fraccionada;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import marp.fraccionada.ObjetoMochilaDivision;
import marp.gui.spring.SpringUtilities;

@SuppressWarnings("serial")
public class CrearObjetoManualmente extends JFrame{
	public CrearObjetoManualmente(ConfiguraMochilaManual c){
		super();
		ventana = this;
		ventanaAnterior = c;
		ventana.setLocationRelativeTo(null);
		JPanel configuracion = new JPanel();
		configuracion.setLayout(new SpringLayout());
		
		JLabel nom = new JLabel ("Nombre: ");
		configuracion.add(nom);
		configuracion.add(nombre);
		
		JLabel vol = new JLabel ("Volumen:");
		configuracion.add(vol);
		configuracion.add(this.volumen);
		
		JLabel val = new JLabel("Valor total: ");
		configuracion.add(val);
		configuracion.add(this.valorTotal);
		
		SpringUtilities.makeCompactGrid(configuracion, 3, 2, 6, 6, 10, 10);
		
		this.add(new JButton("Añadir") {
			{
				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try{
							ObjetoMochilaDivision ob = new ObjetoMochilaDivision(
									Double.valueOf(valorTotal.getText())/Double.valueOf(volumen.getText()),
									Double.valueOf(volumen.getText()),	
									nombre.getText());
						ventanaAnterior.meteNuevoObjeto(ob);
						ventana.setVisible(false);
						
						}catch(Exception excepcion){
								JOptionPane.showMessageDialog(ventana, "Debe rellenar correctamente todos los campos");
						}
								
					}
					

				
				});
				
			}

		}, BorderLayout.SOUTH);
		this.add(configuracion);
		this.pack();
		this.setVisible(true);
	}
		private JFrame ventana;	
		private ConfiguraMochilaManual ventanaAnterior;
		private JTextField nombre = new JTextField(10);
		private JTextField volumen = new JTextField(10);
		private JTextField valorTotal = new JTextField(10);
}