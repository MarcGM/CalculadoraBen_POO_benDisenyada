import java.awt.event.KeyEvent;
import java.util.HashMap;


public class Teclado {
	HashMap<String, String> teclas = new HashMap<String, String>();
	Calculadora calculadora;
	
	
	public Teclado(Calculadora calculadora){
		this.calculadora = calculadora;
	}
	
	public void KeyPressed(KeyEvent e){
		operacionesTecla(e);
	}
	public void operacionesTecla(KeyEvent e) {
		boolean teclaExistente = teclas.containsKey(e);
		String teclaEnString = null;
		
		if(teclaExistente){
			teclaEnString = teclas.get(e);
			calculadora.operacionesConTeclaString(teclaEnString);
		}else{
			//Llamar a método que diga que esta tecla no sirve (Ese método ha de estar dentro de la clase "Calculadora".)
			
		}
	}
}