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
}
