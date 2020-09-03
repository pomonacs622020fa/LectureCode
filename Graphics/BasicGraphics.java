import javax.swing.JFrame;

public class BasicGraphics extends JFrame{

	public BasicGraphics() {
		super("This is my awesome title");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setLocation(100,100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BasicGraphics();
	}
}
