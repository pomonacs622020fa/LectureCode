import javax.swing.JFrame;

public class BasicGraphics2 extends JFrame{
	public BasicGraphics2() {
		super("This is my awesome title");
	}
	
	public static void main(String[] args) {
		BasicGraphics2 window = new BasicGraphics2();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 300);
		window.setLocation(100,100);
		window.setVisible(true);
	}
}
