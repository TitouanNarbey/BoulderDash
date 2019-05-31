package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.text.View;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import entity.Direction;

/**
 * The Class Controller.
 */
public final class Controller implements IController{

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/**
     * Control.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
	}

	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case English:
				this.model.loadHelloWorld("GB");
				break;
			case Francais:
				this.model.loadHelloWorld("FR");
				break;
			case Deutsch:
				this.model.loadHelloWorld("DE");
				break;
			case Indonesia:
				this.model.loadHelloWorld("ID");
				break;
			case Z:
//				System.out.println("Z");//debug
				this.model.getMap().setNextPlayerDirection(Direction.TOP);
				break;
			case Q:
//				System.out.println("Q");
				this.model.getMap().setNextPlayerDirection(Direction.LEFT);
				break;
			case S:
//				System.out.println("S");
				this.model.getMap().setNextPlayerDirection(Direction.BOT);
				break;
			case D:
//				System.out.println("D");
				this.model.getMap().setNextPlayerDirection(Direction.RIGHT);
				break;
			case mapUN:
				this.model.loadMap(1);
				break;
			case mapDEUX:
				this.model.loadMap(2);
				break;
			case mapTROIS:
				this.model.loadMap(3);
				break;
			case mapQUATRE:
				this.model.loadMap(4);
				break;
			case mapCINQ:
				this.model.loadMap(5);
				break;
				

			default:
				break;
		}

	}


}
