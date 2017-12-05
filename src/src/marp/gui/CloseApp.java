package marp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
/**
 * Cierra el programa
 */
public class CloseApp implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		int seleccion = JOptionPane.showOptionDialog(null, "Selecciona una opción",
				"Salir de la aplicacion", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, // null para icono por
													// defecto.
				null, // null para YES, NO y CANCEL, si no: new Object[] {
						// "opcion 1", "opcion 2", "opcion 3" }
				"null");

		if (seleccion == -1 || seleccion == 0)
			System.exit(0);

		else
			System.out.println("seleccionada opcion " + (seleccion + 1));

	}

	public static void requestQuit(String quitReason) {
		JOptionPane.showMessageDialog(null, quitReason, "End of the game",
				JOptionPane.OK_OPTION,
				null);
		System.exit(0);

	}
	
	public static void quitApp(){
		int seleccion = JOptionPane.showOptionDialog(null,"Desea salir del programa?",
				 null,
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, 
					new Object[] { "SÍ", "NO"},"null");

		if (seleccion == -1 || seleccion == 0) System.exit(0);
	}

}
