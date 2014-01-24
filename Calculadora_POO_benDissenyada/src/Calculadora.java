import javax.swing.JFrame;
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
	boolean acabaDePonerOperador = true;
	
	
	public Calculadora(){
		//System.out.println("3");
		addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("8");
				//teclado.KeyPressed(e);
				//System.out.println("9");
				System.out.println(e.getKeyCode()+"==> "+e.getKeyChar());
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyTyped(KeyEvent e) {
			}	
		});
		//System.out.println("4");
		setFocusable(true);
		//System.out.println("5");
	}
	
	public static void main(String[] args) throws InterruptedException{
		//System.out.println("1");
		JFrame frame = new JFrame("");
		Calculadora calculadora = new Calculadora();
		frame.add(calculadora);
		frame.setVisible(true);
		//System.out.println("2");
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
				operador = teclaString;
				acabaDePonerOperador = true;
				comprovarIgual(operador);
			}
		}else{
			if(teclaNum1){
				num1 += teclaString;
				//Escribir por pantalla el num1.
			}else{
				num2 += teclaString;
				//Escribir por pantalla el num2.
			}
			acabaDePonerOperador = false;
		}
	}
	private void comprovarIgual(String operador) {
		if(operador.equals("=")){
			if(teclaNum1 == true){
				acabaDePonerOperador = false;
				mostrarMensaje(1);
			}else{
				//Escribir por pantalla el símbolo "=".
				//La instrucción de abajo no sé si está bién. Mirarmela bien y con detenimiento, más adelante.
				teclaNum1 = false;
				hacerOperaciones();
				//Poner resultado operación.
			}
		}
	}
	public void operacionesConTeclaString(String teclaEnString) {
		boolean teclaEsOperador = false;
		
		teclaEsOperador = comprovarTeclaOperador(teclaEnString);
		ponerTeclasEnMemoria(teclaEsOperador, teclaEnString);
	}
	public boolean comprovarTeclaOperador(String teclaEnString) {
		if(teclaEnString != "+" && teclaEnString != "-" && teclaEnString != "*" && teclaEnString != "/" && teclaEnString != "="){
			return false;
		}else{
			return true;
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
		switch(this.operador){
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
	}
}
