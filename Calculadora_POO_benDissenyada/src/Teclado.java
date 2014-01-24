import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class Teclado {
	ArrayList<String> teclas = new ArrayList<String>();
	private Calculadora calculadora;
	
	
	public Teclado(Calculadora calculadora){
		//System.out.println("6");
		this.calculadora = calculadora;
		//System.out.println("7");
		ponerTeclasArray();
	}

	public void KeyPressed(KeyEvent e){
		operacionesTecla(e);
	}
	private void ponerTeclasArray() {
		for(int i=0; i<10; i++){
			teclas.add(String.valueOf(i));
		}
		teclas.add("+");
		teclas.add("-");
		teclas.add("*");
		teclas.add("/");
	}
	public void operacionesTecla(KeyEvent e) {
		boolean teclaExistente = teclas.contains(String.valueOf(e.getKeyChar()));
		
		if(teclaExistente){
			calculadora.operacionesConTeclaString(String.valueOf(e.getKeyChar()));
		}else{
			//Llamar a método que diga que esta tecla no sirve (Ese método ha de estar dentro de la clase "Calculadora".)
			
		}
	}
}