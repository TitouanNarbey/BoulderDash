package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import entity.Air;
import entity.Bat;
import entity.Border;
import entity.Butterfly;
import entity.Diamond;
import entity.Dirt;
import entity.Entity;
import entity.Exit;
import entity.Octopus;
import entity.Player;
import entity.Rock;
import entity.SpawnPoint;

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

	Font myFont = new Font("fontFamily", Font.PLAIN, 35);
	int fontChangeColor = 4;
	
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
		loadAllImages();
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
//		Graphics2D grph = (Graphics2D) graphics;
		if(this.getViewFrame().getModel().getMap().getPlayerLocation() != null)
		{
			Point pnt = this.getViewFrame().getModel().getMap().getPlayerLocation();
			graphics.translate(-pnt.x*32 + 32*16/2 - 32, -pnt.y*32 + 32*16/2 - 32);
//			grph.scale(0.8, 0.8);
		}
		

		//		graphics.drawString(this.getViewFrame().getModel().getHelloWorld().getMessage(), 10, 20);
		//		graphics.drawString(this.getViewFrame().getModel().getHelloWorld().getMessage(), 25, 40);

		if(this.getViewFrame().getModel().getMap().getHeight() > 1 && this.getViewFrame().getModel().getMap().getWidth() > 1)
		{
			for(int y=0; y < this.getViewFrame().getModel().getMap().getHeight(); y++)
			{
				for(int x=0; x < this.getViewFrame().getModel().getMap().getWidth(); x++)
				{
					graphics.drawImage(this.getViewFrame().getModel().getMap().getEntity(y, x).getSprite().getImage(), y*32, x*32, this);
				}
			}

//			graphics.drawString("Nb diamond : " + this.getViewFrame().getModel().getMap().getDiamondNow() + "/" + this.getViewFrame().getModel().getMap().getDiamondToWin(), 1600, 650);
//			graphics.drawString("Door : " + this.getViewFrame().getModel().getMap().isOpen(), 100, 100);
//			System.out.println("Nb diamond : " + this.getViewFrame().getModel().getMap().getDiamondNow() + "/" + this.getViewFrame().getModel().getMap().getDiamondToWin());
//			System.out.println("Door : " + this.getViewFrame().getModel().getMap().isOpen());
			
			if(this.getViewFrame().getModel().getMap().getPlayerLocation() != null)
			{
				Point pnt = this.getViewFrame().getModel().getMap().getPlayerLocation();
				graphics.setFont(myFont);
				if(fontChangeColor < 0)
				{
					graphics.setColor(Color.WHITE);
					fontChangeColor++;
				}
				else if(fontChangeColor >= 0)
				{
					graphics.setColor(Color.BLACK);
					fontChangeColor++;
				}
				if(fontChangeColor > 4)
				{
					fontChangeColor = -4;
				}
					
				
				graphics.drawString("" + this.getViewFrame().getModel().getMap().getTime(), pnt.x*32 - 32*16/2 + 50 , pnt.y*32 - 32*16/2 + 65);
				graphics.drawString(this.getViewFrame().getModel().getMap().getDiamondNow() + "/" + this.getViewFrame().getModel().getMap().getDiamondToWin(), pnt.x*32 - 32*16/2 + 50 , pnt.y*32 - 32*16/2 + 100);
				
			}
			
			viewFrame.getModel().getMap().addObserver(this);
		}

	}
	
	private void loadAllImages() {
		Entity temp_entity;
		
		temp_entity = new Air();
		try {
			temp_entity.getSprite().loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp_entity = new Border();
		try {
			temp_entity.getSprite().loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp_entity = new Diamond();
		try {
			temp_entity.getSprite().loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp_entity = new Dirt();
		try {
			temp_entity.getSprite().loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp_entity = new Exit();
		try {
			temp_entity.getSprite().loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp_entity = new Octopus();
		try {
			temp_entity.getSprite().loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp_entity = new Bat();
		try {
			temp_entity.getSprite().loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp_entity = new Butterfly();
		try {
			temp_entity.getSprite().loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp_entity = new Player();
		try {
			temp_entity.getSprite().loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp_entity = new Rock();
		try {
			temp_entity.getSprite().loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp_entity = new SpawnPoint();
		try {
			temp_entity.getSprite().loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
