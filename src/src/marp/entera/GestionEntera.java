package marp.entera;

public class GestionEntera {
	
	public MochilaEntera mochilaLlena(ObjetoMochilaEntera[] obj, int volumenMax){
		
		MochilaEntera mochila = new MochilaEntera(volumenMax);
		//TODO Aquí se hace la ramificación
		mochila = ramificacion();
		
		return mochila;
	}
	
	
	private MochilaEntera ramificacion(){
		return null;
		
	}
}
