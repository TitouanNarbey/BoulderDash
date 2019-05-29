package view;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		viewFrame.getModel().getMap().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
		
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());

		//		graphics.drawString(this.getViewFrame().getModel().getHelloWorld().getMessage(), 10, 20);
		//		graphics.drawString(this.getViewFrame().getModel().getHelloWorld().getMessage(), 25, 40);

		if(this.getViewFrame().getModel().getMap().getHeight() > 1 && this.getViewFrame().getModel().getMap().getWidth() > 1)
		{
			for(int y=0; y < this.getViewFrame().getModel().getMap().getHeight(); y++)
			{
				for(int x=0; x < this.getViewFrame().getModel().getMap().getWidth(); x++)
				{
//					System.out.println(y + " : " + x);
//					System.out.println(y*this.getViewFrame().getModel().getMap().getWidth() + x);
//					System.out.println(this.getViewFrame().getModel().getMap().getHeight());
//					System.out.println(this.getViewFrame().getModel().getMap().getWidth());
//					System.out.println(this.getViewFrame().getModel().getMap().getEntity(y, x).getSprite().getImageName());	
					try {
						this.getViewFrame().getModel().getMap().getEntity(y, x).getSprite().loadImage();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			for(int x=0; x < this.getViewFrame().getModel().getMap().getHeight(); x++)
			{
				for(int y=0; y < this.getViewFrame().getModel().getMap().getWidth(); y++)
				{
					graphics.drawImage(this.getViewFrame().getModel().getMap().getEntity(x, y).getSprite().getImage(), x*16, y*16, this);
				}
			}
		}
		

		System.out.println("Nb diamond : " + this.getViewFrame().getModel().getMap().getDiamondNow() + "/" + this.getViewFrame().getModel().getMap().getDiamondToWin());
		System.out.println("Door : " + this.getViewFrame().getModel().getMap().isOpen());
		viewFrame.getModel().getMap().addObserver(this);
	}
	
}
