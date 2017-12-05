package marp.fraccionada;

public class ObjetoMochilaDivision implements Comparable<ObjetoMochilaDivision>{
	public ObjetoMochilaDivision(double densidadValor, double volumen,String nombre){
		this.densidadValor = densidadValor;
		this.nombre = nombre;
		this.volumen = volumen;
		 //Es valor por unidad de volumen
	}
	

	public double getDensidadValor() {
		return densidadValor;
	}
	public ObjetoMochilaDivision() {
		this.nombre = null;
		this.volumen = -1;
		this.densidadValor = -1;
	}

	public String getName(){
		return nombre;
	}
	public double getVolumen() {
		return volumen;
	}

	public String toString(){
		return nombre;
	}
	
	//Vamos a ordenarlos por valor;
	@Override
	public int compareTo(ObjetoMochilaDivision obj) {
		if (this.densidadValor > obj.getDensidadValor())
			return 1;
		else if (this.densidadValor < obj.getDensidadValor())
			return -1;
		else
			return 0;
	}
	
	public void mostrarObjeto() {
			System.out.println(
					"	Nombre: " + this.getName() +
					".	Volumen: " + this.getVolumen() +
					".	Valor: " + this.getDensidadValor());
		
	}
	
	private double densidadValor;
	private String nombre;
	private double volumen;

}
