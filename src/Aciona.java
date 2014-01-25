import javax.swing.JOptionPane;


public class Aciona{

	
	public static void main(String[] args) {
				
		Movimenta movimenta = new Movimenta();

		Thread t = new Thread(movimenta);
		t.start();
	}
}
