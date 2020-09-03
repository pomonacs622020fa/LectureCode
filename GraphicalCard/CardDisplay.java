import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;

public class CardDisplay extends JFrame{
	private static final int X = 10;
	private static final int Y = 50;
	private static final int WIDTH = 40;
	private static final int SPACING = 10;
	private static final int NUM_CARDS = 9;

	private ArrayList<GraphicalCard> cards = new ArrayList<GraphicalCard>();

	public CardDisplay() {
		super("Random cards");
		
		CardDealer dealer = new CardDealer(1);
		
		for( int i = 0; i < NUM_CARDS; i++ ) {
			Card nextCard = dealer.next();
			GraphicalCard card = new GraphicalCard(nextCard, X + (WIDTH + SPACING) * i , Y, WIDTH );
			cards.add(card);
		}
						
		setSize(500, 300);
		setLocation(100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // this should happen at the end of the constructor
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		for( GraphicalCard card: cards ) {
			g2.setPaint(card.getColor());
			g2.fill(card);

			// just to double check, print them out
			System.out.println(card.getCard());
		}
	}
	
	public static void main(String[] args) {
		new CardDisplay();
	}
}
