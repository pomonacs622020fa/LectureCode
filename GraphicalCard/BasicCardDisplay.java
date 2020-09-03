import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class BasicCardDisplay extends JFrame{
	private static final int X = 10;
	private static final int Y = 50;
	private static final int WIDTH = 40;
	private GraphicalCard jack;
	
	public BasicCardDisplay() {
		super("Jack of diamonds");
		Card card = new Card(11, "diamonds");
		jack = new GraphicalCard(card, X, Y, WIDTH);
				
		setSize(500, 300);
		setLocation(100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // this should happen at the end of the constructor
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setPaint(jack.getColor());
		g2.fill(jack);
	}
	
	public static void main(String[] args) {
		new BasicCardDisplay();
	}
}
