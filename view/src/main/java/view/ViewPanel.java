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

	// custom font for text
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
//		Graphics2D grph = (Graphics2D) graphics; //cast to use some function, don't need now
		
		//move the render view position depending of player position
		if(this.getViewFrame().getModel().getMap().getPlayerLocation() != null)
		{
			Point pnt = this.getViewFrame().getModel().getMap().getPlayerLocation();
			graphics.translate(-pnt.x*32 + 32*16/2 - 32, -pnt.y*32 + 32*16/2 - 32);
//			grph.scale(0.8, 0.8);
		}

		if(this.getViewFrame().getModel().getMap().getHeight() > 1 && this.getViewFrame().getModel().getMap().getWidth() > 1)
		{
			for(int y=0; y < this.getViewFrame().getModel().getMap().getHeight(); y++)
			{
				for(int x=0; x < this.getViewFrame().getModel().getMap().getWidth(); x++)
				{
					graphics.drawImage(this.getViewFrame().getModel().getMap().getEntity(y, x).getSprite().getImage(), y*32, x*32, this);
				}
			}

			// display time remaining and diamond left ( with a black and white switcher)
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
				if(fontChangeColor > 8)
				{
					fontChangeColor = -8;
				}
				graphics.drawString("" + this.getViewFrame().getModel().getMap().getTime(), pnt.x*32 - 32*16/2 + 50 , pnt.y*32 - 32*16/2 + 65);
				graphics.drawString(this.getViewFrame().getModel().getMap().getDiamondNow() + "/" + this.getViewFrame().getModel().getMap().getDiamondToWin(), pnt.x*32 - 32*16/2 + 50 , pnt.y*32 - 32*16/2 + 100);
				
				
				if(this.getViewFrame().getModel().getMap().isWin())
				{
					graphics.setFont(myFont);
					graphics.setColor(Color.WHITE);
					graphics.drawString("WIN !", pnt.x*32 -32/2 , pnt.y*32 );
				}
				
			}
			
			if(this.getViewFrame().getModel().getMap().isLoose())
			{
				graphics.setFont(myFont);
				graphics.setColor(Color.WHITE);
				graphics.drawString("LOOSE", 32*16/2 -32*2/2 , 32*16/2);
			}

			
			// re-add the observer, may be only use the first time to set the observer on the good map (thanks to hello world)
			viewFrame.getModel().getMap().addObserver(this);
		}

	}
	
	/**
	 * To load images in memory
	 */
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
