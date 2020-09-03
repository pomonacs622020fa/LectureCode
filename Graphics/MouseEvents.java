import java.awt.event.*;
import javax.swing.*;

/**
 * A class highlighting the different mouse events that can fire
 * in MouseListener and MouseMotionListener
 * 
 * @author dave
 * @date January 27, 2010
 */
public class MouseEvents extends JFrame{
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 400;

	public static void main(String[] s){
		// setup the frame/window
		MouseEvents f = new MouseEvents("Mouse Events Demo");
	}

	public MouseEvents(String title){
		super(title);

		// listen to mouse events using our private class
		MouseEventsHelper helper = new MouseEventsHelper();
		addMouseListener(helper);
		addMouseMotionListener(helper);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setVisible(true);
	}

	/**
	 * A helper class that actually handles all of the mouse events
	 * 
	 * @author dave
	 */
	private class MouseEventsHelper implements MouseListener, MouseMotionListener{

		public void mouseClicked(MouseEvent arg0){
			int x = arg0.getX();
			int y = arg0.getY();

			System.out.println("Mouse clicked at: (" + x + ", " + y + ")");			
		}

		public void mouseEntered(MouseEvent arg0) {
			int x = arg0.getX();
			int y = arg0.getY();

			System.out.println("Mouse entered at: (" + x + ", " + y + ")");
		}

		public void mouseExited(MouseEvent arg0) {
			int x = arg0.getX();
			int y = arg0.getY();

			System.out.println("Mouse exited at: (" + x + ", " + y + ")");
		}

		public void mousePressed(MouseEvent arg0) {
			int x = arg0.getX();
			int y = arg0.getY();

			System.out.println("Mouse pressed at: (" + x + ", " + y + ")");
		}

		public void mouseReleased(MouseEvent arg0) {
			int x = arg0.getX();
			int y = arg0.getY();

			System.out.println("Mouse released at: (" + x + ", " + y + ")");
		}

		public void mouseDragged(MouseEvent arg0) {
			int x = arg0.getX();
			int y = arg0.getY();

			System.out.println("Mouse dragged at: (" + x + ", " + y + ")");
		}

		public void mouseMoved(MouseEvent arg0) {
			int x = arg0.getX();
			int y = arg0.getY();

			System.out.println("Mouse moved at: (" + x + ", " + y + ")");
		}
	}
}