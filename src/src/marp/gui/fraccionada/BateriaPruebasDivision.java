package marp.gui.fraccionada;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import marp.fraccionada.BateriaOrdenaciones;
import marp.fraccionada.ModoObjetos;

@SuppressWarnings("serial")
public class BateriaPruebasDivision extends JFrame{
	public BateriaPruebasDivision(){
		super("Simulando");
		this.setSize(1000, 500);

			this.setVisible(true);
		
		JTabbedPane panelGeneral = new JTabbedPane();
		this.add(panelGeneral);
		
		BateriaOrdenaciones llena = new BateriaOrdenaciones(20, ModoObjetos.SIN_ORDEN);
		panelGeneral.add("Todos", llena.executeBateria());
		
		BateriaOrdenaciones dostercios = new BateriaOrdenaciones(40,  ModoObjetos.SIN_ORDEN);
		panelGeneral.add("Dos tercios", dostercios.executeBateria());
				
		BateriaOrdenaciones mitad = new BateriaOrdenaciones(47, ModoObjetos.SIN_ORDEN);
		panelGeneral.add("Mitad", mitad.executeBateria());
		
		BateriaOrdenaciones untercio = new BateriaOrdenaciones(60, ModoObjetos.SIN_ORDEN);
		panelGeneral.add("Un tercio", untercio.executeBateria());
		
		BateriaOrdenaciones doble = new BateriaOrdenaciones(500,  ModoObjetos.SIN_ORDEN);
		panelGeneral.add("Pocos", doble.executeBateria());
		
		BateriaOrdenaciones ordenados = new BateriaOrdenaciones(20,  ModoObjetos.ORDENADOS);
		panelGeneral.add("Objetos ya ordenados", ordenados.executeBateria());
		
		BateriaOrdenaciones ordenadosInverso = new BateriaOrdenaciones(20,  ModoObjetos.ORDENADOS_INVERSO);
		panelGeneral.add("Ordenados inverso", ordenadosInverso.executeBateria());
		
		this.setTitle("Batería de pruebas");
	}
	
	//Crea la imagen para la espera.
	
	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
