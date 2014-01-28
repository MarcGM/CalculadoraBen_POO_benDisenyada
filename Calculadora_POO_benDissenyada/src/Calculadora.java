/*
 * Marc Grandio
 */


import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
						//Escribe por pantalla el operador.
						System.out.print(operador+" ");
					}else{
						System.exit(ABORT);
					}
				}else{
					if(!this.operador.equals("10")){
						//Escribe por pantalla el operador.
						System.out.print(" "+operador+" ");
					}
				}
			}
		}else{
			if(teclaNum1){
				num1 += teclaString;
				//Escribe por pantalla el num1.
				System.out.print(teclaString);
			}else{
				num2 += teclaString;
				//Escribe por pantalla el num2.
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
				System.out.println();
				System.out.println();
				hacerOperaciones();
			}
		}else{
			if(teclaNum1 == true){
				this.teclaNum1 = false;
			}else{
				hacerOperaciones();
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
				//Muestra el mensaje "¡Falta poner el segundo número!".
				JOptionPane.showMessageDialog(this, "¡Falta poner el segundo número!", "Adverténcia", JOptionPane.YES_NO_OPTION);
				break;
			case 2:
				//Muestra el mensaje: "¡NO puedes poner un operador, has de poner un número!".
				JOptionPane.showMessageDialog(this, "¡NO puedes poner un operador, has de poner un número!", "Adverténcia", JOptionPane.YES_NO_OPTION);
				break;
			case 3:
				//Muestra el mensaje: "¡Esta tecla no está disponible!".
				JOptionPane.showMessageDialog(this, "¡Esta tecla no está disponible!", "Adverténcia", JOptionPane.YES_NO_OPTION);
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
