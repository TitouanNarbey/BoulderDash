package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View implements IView, Runnable{

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_G:
				return ControllerOrder.English;
			case KeyEvent.VK_F:
				return ControllerOrder.Francais;
			case KeyEvent.VK_J:
				return ControllerOrder.Deutsch;
			case KeyEvent.VK_I:
				return ControllerOrder.Indonesia;
			case KeyEvent.VK_Z:
				return ControllerOrder.Z;
			case KeyEvent.VK_Q:
				return ControllerOrder.Q;
			case KeyEvent.VK_S:
				return ControllerOrder.S;
			case KeyEvent.VK_D:
				return ControllerOrder.D;
			case KeyEvent.VK_1:
				return ControllerOrder.mapONE;
			case KeyEvent.VK_2:
				return ControllerOrder.mapTWO;
			case KeyEvent.VK_3:
				return ControllerOrder.mapTHREE;
			case KeyEvent.VK_4:
				return ControllerOrder.mapFOUR;
			case KeyEvent.VK_5:
				return ControllerOrder.mapFIVE;
				

			default:
				return ControllerOrder.English;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
		this.viewFrame.repaint();
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}

