package marp;

/**
 * Lanza el programa
 */
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

import marp.gui.MenuPrincipal;

public class Main {

	public static void main(String[] args) throws IOException {	
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			// .setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		MenuPrincipal window = new MenuPrincipal();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
