import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


@SuppressWarnings("serial")
public class Calculadora extends JPanel{
	Teclado teclado = new Teclado(this);
	String num1 = "";
	String num2 = "";
	double resultado;
	String operador;
	String operadorViejo;
	boolean dosNumsPuestos = false;
	boolean teclaNum1 = true;
	boolean acabaDePonerOperador = true;
	
	
	public Calculadora(){
		addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent e) {
				teclado.KeyPressed(e);
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
	
	public static void main(String[] args) throws InterruptedException{
		JFrame frame = new JFrame("");
		Calculadora calculadora = new Calculadora();
		frame.add(calculadora);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while (true) {
			Thread.sleep(10);
		}
	}
	public void ponerTeclasEnMemoria(boolean teclaEsOperador, String teclaString){
		if(teclaEsOperador){
			if(acabaDePonerOperador){
				mostrarMensaje(2);
			}else{
				operadorViejo = operador;
				operador = teclaString;
				acabaDePonerOperador = true;
				comprovarIgual(operador);
				if(dosNumsPuestos){
					System.out.println(" = "+resultado);
					if(!this.operador.equals("10")){
						//Escribir por pantalla el operador.
						System.out.print(operador+" ");
					}else{
						System.exit(ABORT);
					}
				}else{
					if(!this.operador.equals("10")){
						//Escribir por pantalla el operador.
						System.out.print(" "+operador+" ");
					}
				}
			}
		}else{
			if(teclaNum1){
				num1 += teclaString;
				//Escribir por pantalla el num1.
				System.out.print(teclaString);
			}else{
				num2 += teclaString;
				//Escribir por pantalla el num2.
				System.out.print(teclaString);
				dosNumsPuestos = true;
			}
			acabaDePonerOperador = false;
		}
	}
	private void comprovarIgual(String operador) {
		if(operador.equals("10")){
			if(teclaNum1 == true){
				acabaDePonerOperador = false;
				mostrarMensaje(1);
			}else{
				//Escribir por pantalla el símbolo "=".
				System.out.println();
				System.out.println();
				hacerOperaciones();
			}
		}else{
			if(teclaNum1 == true){
				//Escribir por pantalla el símbolo de la operación correspondiente.
				this.teclaNum1 = false;
			}else{
				//La instrucción de abajo no sé si está bién. Mirarmela bien y con detenimiento, más adelante.
				//Escribir por pantalla el símbolo de la operación correspondiente.
				hacerOperaciones();
				//Poner resultado operación.
			}
		}
	}
	public void operacionesConTeclaString(String teclaEnString) {
		boolean teclaEsOperador = false;
		
		//Llama al método que comprueva si la tecla pulsada es un operador.
		teclaEsOperador = comprovarTeclaOperador(teclaEnString);
		ponerTeclasEnMemoria(teclaEsOperador, teclaEnString);
	}
	public boolean comprovarTeclaOperador(String teclaEnString) {
		if(teclaEnString.equals("+") || teclaEnString.equals("-") || teclaEnString.equals("*") || teclaEnString.equals("/") || teclaEnString.equals("10")){
			return true;
		}else{
			return false;
		}
	}
	public void mostrarMensaje(int numMensaje){
		switch (numMensaje){
			case 1:
				//Mostrar mensaje: "Falta el segundo número...".
				break;
			case 2:
				//Mostrar mensaje: "Ahora, no puedes poner un operador. Has de poner un número. Etc.".
				break;
		}
	}
	public void hacerOperaciones(){
		switch(this.operadorViejo){
			case "+":
				resultado = Double.parseDouble(num1) + Double.parseDouble(num2);
				break;
			case "-":
				resultado = Double.parseDouble(num1) - Double.parseDouble(num2);
				break;
			case "*":
				resultado = Double.parseDouble(num1) * Double.parseDouble(num2);
				break;
			case "/":
				resultado = Double.parseDouble(num1) / Double.parseDouble(num2);
				break;
		}
		this.num1 = String.valueOf(resultado);
		this.num2 = "";
	}
}
