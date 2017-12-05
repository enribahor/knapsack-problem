package marp.entera;


public class ObjetoMochilaEntera {

	public ObjetoMochilaEntera(int valorTotal, int volumen,String nombre){
		this.valorTotal = valorTotal;
		this.nombre = nombre;
		this.volumen = volumen;
		 //Es valor por unidad de volumen
	}
	

	public double getDensidadValor() {
		return valorTotal*1.0/volumen;
	}
	public ObjetoMochilaEntera() {
		this.nombre = null;
		this.volumen = -1;
		this.valorTotal = -1;
	}

	public String getName(){
		return nombre;
	}
	public int getVolumen() {
		return volumen;
	}
	
	public int getValorTotal(){
		return this.valorTotal;
	}

	public String toString(){
		return nombre;
	}
	
	//Vamos a ordenarlos por valor;
	
	public int compareTo(ObjetoMochilaEntera obj) {
		if (this.getDensidadValor() > obj.getDensidadValor())
			return 1;
		else if (this.getDensidadValor() < obj.getDensidadValor())
			return -1;
		else
			return 0;
	}
	
	public void mostrarObjeto() {
			System.out.println(
					"	Nombre: " + this.getName() +
					".	Volumen: " + this.getVolumen() +
					".	Valor: " + this.getValorTotal());
		
	}
	
	private int valorTotal;
	private String nombre;
	private int volumen;

}
