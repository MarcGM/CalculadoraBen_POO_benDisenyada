import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


@SuppressWarnings("serial")
public class Calculadora extends JPanel{
	Teclado teclado = new Teclado(this);
	String num1;
	String num2;
	double resultado;
	String operador;
	boolean teclaNum1 = true;
	
	
	public Calculadora(){
		addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent e) {
				teclado.KeyPressed(e);;
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			@Override
			public void keyTyped(KeyEvent e) {
			}	
		});
		setFocusable(true);
	}
	
	public static void main(String[] args) {
		
	}
	public void ponerTeclasEnMemoria(boolean teclaEsOperador, String teclaString){
		if(teclaEsOperador){
			comprovarIgual(teclaString);
			operador = teclaString;
			teclaNum1 = false;
		}else{
			if(teclaNum1){
				num1 += teclaString;
			}else{
				num2 += teclaString;
			}
		}
	}
	private void comprovarIgual(String operador) {
		if(operador.equals("=")){
			if(teclaNum1 == true){
				mostrarMensaje(1);
			}else{
				//Llamar a los métodos para hacer las operaciones.
			}
		}
	}
	public void operacionesConTeclaString(String teclaEnString) {
		boolean teclaEsOperador;
		
		teclaEsOperador = comprovarTeclaOperador(teclaEnString);
		ponerTeclasEnMemoria(teclaEsOperador, teclaEnString);
	}
	public boolean comprovarTeclaOperador(String teclaEnString) {
		if(teclaEnString != "+" && teclaEnString != "-" &&teclaEnString != "*" &&teclaEnString != "/"){
			return false;
		}else{
			return true;
		}
	}
	public void mostrarMensaje(int numMensaje){
		switch (numMensaje){
			case 1:
				//Mostrar mensaje: "Falta el segundo operador...".
				break;
			case 2:
				
				break;
		}
	}
}
