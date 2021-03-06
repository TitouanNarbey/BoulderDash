package entity;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * The Map
 * 
 * @author 1850743 Titouan Narbey
 *
 */
public class Map extends Observable {
	private int width;
	private int height;
	private int diamondToWin;
	private int diamondNow;
	boolean open = false;
	private Entity[][] content;// [x][y]
	Direction nextPlayerDirection = Direction.NOTHING;
	Random rand = new Random();
	int time;// second / 5
	private boolean loose = false;
	private boolean win = false;
	
	//timer
    // creating timer task, timer
	TimerTask task = new TimerTask() {
        public void run() {
            updateMap();
        }
    };
    Timer timer;
    
    /**
     * Default map to counter outOfBoundException
     */
    public Map()
    {
    	timer = new Timer();
    	// scheduling the task at interval
		width = 1;
		height = 1;
		time = 150 *5;
		content = new Entity[width][height];
		content[0][0] = new Air();
	}
    
    /**
     * Map constructor 
     * 
     * @param height_
     * 		height
     * @param width_
     * 		width
     */
	public Map(int height_, int width_)
	{
		timer = new Timer();
    	timer.schedule(task,200, 200);
		width = width_;
		height = height_;
		time = 150 *5;
		content = new Entity[height][width];
	}
	
	/**
	 * Return the number of diamond required to open the exit.
	 * 
	 * @return diamondToWin
     * 		number of diamond to win
	 */
	public int getDiamondToWin() {
		return diamondToWin;
	}
	
	/**
	 * Return the number of diamond that the player have.
	 * 
	 * @return diamondNow
     * 		number of diamond that have the player now
     * 		
	 */
	public int getDiamondNow() {
		return diamondNow;
	}
	
	/**
	 * Return map's width
	 * 
	 * @return width
     * 		width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Return map's height
	 * 
	 * @return height
     * 		height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @deprecated
	 * 
	 * Return map's content
	 * Should never be use
	 * 
	 * @return content
     * 		Entity[][]
	 */
	public Entity[][] getContent() {
		return content;
	}
	
	/**
	 * set the number of diamond required to win
	 * 
	 * @param mbdiamond
	 * 		nb od diamond to win
	 */
	public void setDiamondToWin(int mbdiamond){
		if (mbdiamond >= 0) 
		{
			diamondToWin = mbdiamond;
		}
		else 
		{
			System.out.println("error : diamondToWin < 0");
		}
	}
	
	/**
	 * set map's width
	 * 
	 * @param width
	 * 		future width of the map
	 */
	public void setWidth(int width){
		if (width >= 0) 
		{
			width = getWidth();
		}
		else 
		{
			System.out.println("error : width < 0");
		}
	}
	
	/**
	 * set map's height
	 * 
	 * @param height
	 * 		future height of the map
	 */
	public void setHeight(int height){
		if (height >= 0) 
		{
			height = getHeight();
		}
		else 
		{
			System.out.println("error : height < 0");
		}
	}
	
	
	/**
	 * Return the Entity on the map relative to a given position
	 * 
	 * @param x
	 * 		x
	 * @param y
	 * 		y
	 * @return Entity
     * 		Entity
	 */
	public Entity getTopEntity(int x, int y) {
		return this.getEntity(x, y-1);
	}
	/**
	 * Return the Entity on the map relative to a given position
	 * 
	 * @param x
	 * 		x
	 * @param y
	 * 		y
	 * @return Entity
     * 		Entity
	 */
	public Entity getBotEntity(int x, int y) {
		return this.getEntity(x, y+1);
	}
	/**
	 * Return the Entity on the map relative to a given position
	 * 
	 * @param x
	 * 		x
	 * @param y
	 * 		y
	 * @return Entity
     * 		Entity
	 */
	public Entity getBotBotEntity(int x, int y) {
		return this.getEntity(x, y+2);
	}
	/**
	 * Return the Entity on the map relative to a given position
	 * 
	 * @param x
	 * 		x
	 * @param y
	 * 		y
	 * @return Entity
     * 		Entity
	 */
	public Entity getLeftEntity(int x, int y) {
		return this.getEntity(x-1, y);
	}
	/**
	 * Return the Entity on the map relative to a given position
	 * 
	 * @param x
	 * 		x
	 * @param y
	 * 		y
	 * @return Entity
     * 		Entity
	 */
	public Entity getLeftLeftEntity(int x, int y) {
		return this.getEntity(x-2, y);
	}
	/**
	 * Return the Entity on the map relative to a given position
	 * 
	 * @param x
	 * 		x
	 * @param y
	 * 		y
	 * @return Entity
     * 		Entity
	 */
	public Entity getRightRightEntity(int x, int y) {
		return this.getEntity(x+2, y);
	}
	/**
	 * Return the Entity on the map relative to a given position
	 * 
	 * @param x
	 * 		x
	 * @param y
	 * 		y
	 * @return Entity
     * 		Entity
	 */
	public Entity getRightEntity(int x, int y) {
		return this.getEntity(x+1, y);
	}
	/**
	 * Return the Entity on the map relative to a given position
	 * 
	 * @param x
	 * 		x
	 * @param y
	 * 		y
	 * @return Entity
     * 		Entity
	 */
	public Entity getLeftBotEntity(int x, int y) {
		return this.getEntity(x-1, y+1);
	}
	/**
	 * Return the Entity on the map relative to a given position
	 * 
	 * @param x
	 * 		x
	 * @param y
	 * 		y
	 * @return Entity
     * 		Entity
	 */
	public Entity getRightBotEntity(int x, int y) {
		return this.getEntity(x+1, y+1);
	}
	/**
	 * Return the Entity on the map relative to a given position
	 * 
	 * @param x
	 * 		x
	 * @param y
	 * 		y
	 * @return Entity
     * 		Entity
	 */
	public Entity getEntity(int x, int y) {
		if( (x <= height) && (y <= width) )
		{
			return this.content[x][y];
		}
		else 
		{
			return null;
		}
	}
	
	
	/**
	 * Move the element from a given position
	 * 
	 * @param x
	 * 		x
	 * @param y
	 * 		y
	 */
	public void moveTop(int x, int y) {
//		this.content[x][y-1].destroy();
		this.content[x][y-1] = this.content[x][y];
//		this.content[x][y].destroy();
		this.content[x][y] = new Air();
		System.out.println("Go UP");
	}
	/**
	 * Move the element from a given position
	 * 
	 * @param x
	 * 		x
	 * @param y
	 * 		y
	 */
	public void moveLeft(int x, int y) {
		this.content[x-1][y] = this.content[x][y];
		this.content[x][y] = new Air();
		System.out.println("Go LEFT");
	}
	/**
	 * Move the element from a given position
	 * 
	 * @param x
	 * 		x
	 * @param y
	 * 		y
	 */
	public void moveBot(int x, int y) {
		this.content[x][y+1] = this.content[x][y];
		this.content[x][y] = new Air();
		
		/**
		 * Move the element from a given position
		 * 
		 * @param x
	 * 		x
		 * @param y
	 * 		y
		 */System.out.println("Go DOWN");
	}
	public void moveRight(int x, int y) {
		this.content[x+1][y] = this.content[x][y];
		this.content[x][y] = new Air();
		System.out.println("Go RIGHT");
	}
	
	/**
	 *  Move the player top depending of his environment
	 * 
	 * @param x
	 * 		x
	 * @param y
	 * 		y
	 * 
	 * @return boolean
	 * 		return true if the player move
	 * 
	 */
	public boolean moveTopPlayer(int x, int y) {
		Entity enti = this.getTopEntity(x, y);
		if(enti instanceof IDestroyable)
		{
			if(getTopEntity(x, y) instanceof Diamond)
			{
				addDiamondNow();
				moveTop(x, y);
			}
			else if(getTopEntity(x, y) instanceof Exit && isOpen())
			{
				System.out.println("Win !");
				win = true;
				moveTop(x, y);
			}
			else if(getTopEntity(x, y) instanceof Exit && !isOpen())
			{
				System.out.println("Door is not Open !");
				return false;
			}
			else
			{
				moveTop(x, y);
			}
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 *  Move the player bot depending of his environment
	 * 
	 * @param x
	 * 		x
	 * @param y
	 * 		y
	 * 
	 * @return boolean
	 * 		return true if the player move
	 * 
	 */
	public boolean moveBotPlayer(int x, int y) {
		Entity enti = this.getBotEntity(x, y);
		if(enti instanceof IDestroyable)
		{
			if(getBotEntity(x, y) instanceof Diamond)
			{
				addDiamondNow();
				moveBot(x, y);
			}
			else if(getBotEntity(x, y) instanceof Exit && isOpen())
			{
				System.out.println("Win !");
				win = true;
				moveBot(x, y);
			}
			else if(getBotEntity(x, y) instanceof Exit && !isOpen())
			{
				System.out.println("Door is not Open !");
				return false;
			}
			else
			{
				moveBot(x, y);
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 *  Move the player left depending of his environment
	 * 
	 * @param x
	 * 		x
	 * @param y
	 * 		y
	 * 
	 * @return boolean
	 * 		return true if the player move
	 * 
	 */
	public boolean moveLeftPlayer(int x, int y) {
		Entity enti = this.getLeftEntity(x, y);
		if(enti instanceof IDestroyable)
		{
			if(getLeftEntity(x, y) instanceof Diamond)
			{
				addDiamondNow();
				moveLeft(x, y);
			}
			else if(getLeftEntity(x, y) instanceof Exit && isOpen())
			{
				System.out.println("Win !");
				win = true;
				moveLeft(x, y);
			}
			else if(getLeftEntity(x, y) instanceof Exit && !isOpen())
			{
				System.out.println("Door is not Open !");
				return false;
			}
			else
			{
				moveLeft(x, y);
			}
			return true;
		}
		else if( (getLeftEntity(x, y) instanceof IMovable) && (getLeftLeftEntity(x, y) instanceof Air) )
		{
			moveLeft(x-1, y);
			System.out.println("Move Left IMovable");
			moveLeft(x, y);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 *  Move the player right depending of his environment
	 * 
	 * @param x
	 * 		x
	 * @param y
	 * 		y
	 * 
	 * @return boolean
	 * 		return true if the player move
	 * 
	 */
	public boolean moveRightPlayer(int x, int y) {
		Entity enti = this.getRightEntity(x, y);
		if(enti instanceof IDestroyable)
		{
			if(getRightEntity(x, y) instanceof Diamond)
			{
				addDiamondNow();
				moveRight(x, y);
			}
			else if(getRightEntity(x, y) instanceof Exit && isOpen())
			{
				System.out.println("Win !");
				win = true;
				moveRight(x, y);
			}
			else if(getRightEntity(x, y) instanceof Exit && !isOpen())
			{
				System.out.println("Door is not Open !");
				return false;
			}
			else
			{
				moveRight(x, y);
			}
			return true;
		}
		else if( (getRightEntity(x, y) instanceof IMovable) && (getRightRightEntity(x, y) instanceof Air) )
		{
			moveRight(x+1, y);
			System.out.println("Move Right IMovable");
			moveRight(x, y);
			return true;
		}
		else
		{
			return false;
		}
	}

	
	
	/**
	 * Give him a Point, and he will call moveTop with x,y
	 * 
	 * @param pnt
	 * 		Point(x,y)
	 * 
	 */
	public void moveTop(Point pnt) {
		moveTop(pnt.x,pnt.y);
	}
	
	/**
	 * Give him a Point, and he will call moveLeft with x,y
	 * 
	 * @param pnt
	 * 		Point(x,y)
	 * 
	 */
	public void moveLeft(Point pnt) {
		moveLeft(pnt.x,pnt.y);
	}
	
	/**
	 * Give him a Point, and he will call moveBot with x,y
	 * 
	 * @param pnt
	 * 		Point(x,y)
	 * 
	 */
	public void moveBot(Point pnt) {
		moveBot(pnt.x,pnt.y);
	}
	
	/**
	 * Give him a Point, and he will call moveRight with x,y
	 * 
	 * @param pnt
	 * 		Point(x,y)
	 * 
	 */
	public void moveRight(Point pnt) {
		moveRight(pnt.x,pnt.y);
	}
	
	/**
	 * Give him a Point, and he will call moveTopPlayer with x,y
	 * 
	 * @param pnt
	 * 		Point(x,y)
	 * 
	 */
	public void moveTopPlayer(Point pnt) {
		moveTopPlayer(pnt.x,pnt.y);
	}
	
	/**
	 * Give him a Point, and he will call moveLeftPlayer with x,y
	 * 
	 * @param pnt
	 * 		Point(x,y)
	 * 
	 */
	public void moveLeftPlayer(Point pnt) {
		moveLeftPlayer(pnt.x,pnt.y);
	}
	
	/**
	 * Give him a Point, and he will call moveBotPlayer with x,y
	 * 
	 * @param pnt
	 * 		Point(x,y)
	 * 
	 */
	public void moveBotPlayer(Point pnt) {
		moveBotPlayer(pnt.x,pnt.y);
	}
	
	/**
	 * Give him a Point, and he will call moveRightPlayer with x,y
	 * 
	 * @param pnt
	 * 		Point(x,y)
	 * 
	 */
	public void moveRightPlayer(Point pnt) {
		moveRightPlayer(pnt.x,pnt.y);
	}
	
	
	/**
	 * Retrun the player location (only on player on the map pls)
	 * 
	 * @return Point
	 * 		Point(x,y)
	 */
	public Point getPlayerLocation() {
		Point pnt = null;
		for(int y=0; y < height; y++)
		{
			for(int x=0; x < width; x++)
			{
				if(content[y][x].getClass() == SpawnPoint.class)
				{
					pnt = new Point(y,x);
//					System.out.println("SpawnPoint found : " + x + " " + y);
				}
			}
		}
		return pnt;
	}
	
	/**
	 * Set an entity on the map at a specific location
	 * 
	 * @param x_
	 * 		x
	 * @param y_
	 * 		y
	 * @param entity_
	 * 		Entity
	 */
	public void setEntityOnTheMap(int x_, int y_, Entity entity_) {
		content[x_][y_] = entity_;
	}

	/**
	 * Update the map (called every 200 mill by task)
	 * 
	 * @author 1850743 Titouan Narbey
	 */
	public void updateMap() {
		/////   Player   /////
		switch (nextPlayerDirection) 
		{
		case RIGHT:
			System.out.println("Right");//debug
			moveRightPlayer(getPlayerLocation());
			setNextPlayerDirection(Direction.NOTHING);
			break;
		case LEFT:
			System.out.println("Left");//debug
			moveLeftPlayer(getPlayerLocation());
			setNextPlayerDirection(Direction.NOTHING);
			break;
		case TOP:
			System.out.println("Top");//debug
			moveTopPlayer(getPlayerLocation());
			setNextPlayerDirection(Direction.NOTHING);
			break;
		case BOT:
			System.out.println("Bot");//debug
			moveBotPlayer(getPlayerLocation());
			setNextPlayerDirection(Direction.NOTHING);
			break;
			
		case NOTHING:
//			System.out.println("Nothing to do");//debug
			break;

		default:
			break;
		}
		//////////////////////

		
		//reset hasDoAction
		for(int y=height-1; y >= 0; y--)
		{
			for(int x=width-1; x >= 0; x--)
			{
				getEntity(y, x).setHasDoAction(false);
			}
		}
		
		for(int y=height-1; y >= 0; y--)
		{
			for(int x=width-1; x >= 0; x--)
			{
//				System.out.println(y*height + x);//debug
				
//				if( (getEntity(y, x).getHasDoAction()) == false )
				{
					/////   Rock   /////
//					System.out.println("HasDoAction : " + getEntity(y, x).getHasDoAction());
					if( (getEntity(y, x) instanceof IGravity) && !(getEntity(y, x).getHasDoAction()) )
					{
						IGravity subject = (IGravity) getEntity(y, x);

						if(getBotEntity(y, x) instanceof Air)
						{
							System.out.println("Air");
							subject.setFalling(true);
							getEntity(y, x).setHasDoAction(true);
							moveBot(y, x);//need to do at end
							
							//death verification
							if((getBotBotEntity(y, x).getClass() == SpawnPoint.class))
							{
								killPlayer();
							}
							else if((getBotBotEntity(y, x) instanceof Monster))
							{
								explodeDiamond(y,x+2);
							}
						}
						else if( (getBotEntity(y, x).getClass() == SpawnPoint.class) && (subject.isFalling()) )
						{
							System.out.println("Kill the Player !");
							killPlayer();
							subject.setFalling(true);
							getEntity(y, x).setHasDoAction(true);
							moveBot(y, x);//need to do at end
						}
						else if( (getBotEntity(y, x) instanceof Monster) && (subject.isFalling()) )
						{
							subject.setFalling(true);
							explodeDiamond(y, x+1);
							System.out.println("Kill Monster !");
							getEntity(y, x).setHasDoAction(true);
							moveBot(y, x);//need to do at end
						}
						else if(getBotEntity(y, x) instanceof ISliding)
						{
							if( (getRightEntity(y, x) instanceof Air) && (getRightBotEntity(y, x) instanceof Air || getRightBotEntity(y, x) instanceof Monster || getRightBotEntity(y, x) instanceof SpawnPoint))
							{
								subject.setFalling(true);
								System.out.println("Slide");
								getEntity(y, x).setHasDoAction(true);
								moveRight(y, x);
								
								//death verification
								if((getRightBotEntity(y, x).getClass() == SpawnPoint.class))
								{
									killPlayer();
								}
								else if((getRightBotEntity(y, x) instanceof Monster))
								{
									explodeDiamond(y+1,x+1);
								}
							}
							else if( (getLeftEntity(y, x) instanceof Air) && (getLeftBotEntity(y, x) instanceof Air || getLeftBotEntity(y, x) instanceof Monster || getLeftBotEntity(y, x) instanceof SpawnPoint))
							{
								subject.setFalling(true);
								System.out.println("Slide");
								getEntity(y, x).setHasDoAction(true);
								moveLeft(y, x);
								
								//death verification
								if((getLeftBotEntity(y, x).getClass() == SpawnPoint.class))
								{
									killPlayer();
								}
								else if((getLeftBotEntity(y, x) instanceof Monster))
								{
									explodeDiamond(y-1,x+1);
								}
							}
						}
						else
						{
							subject.setFalling(false);
//							System.out.println("ROCK NO MOVE");
						}

					}
					/////////////////////////

					/////   Monster   /////
					if(getEntity(y, x) instanceof Monster && !(getEntity(y, x).getHasDoAction()) )
					{
						/////   Octopus   /////
						if(getEntity(y, x) instanceof Octopus)
						{
							getEntity(y, x).setHasDoAction(true);
							Octopus subject = (Octopus) getEntity(y, x);
							if(subject.getDirection() == Direction.TOP)
							{
								if(getTopEntity(y, x) instanceof Air)
								{
									moveTop(y, x);
								}
								else if(getTopEntity(y, x) instanceof SpawnPoint)
								{
									killPlayer();
								}
								else
								{
									subject.switchDirection();
								}
							}
							else if(subject.getDirection() == Direction.BOT)
							{
								if(getBotEntity(y, x) instanceof Air)
								{
									moveBot(y, x);
								}
								else if(getBotEntity(y, x) instanceof SpawnPoint)
								{
									killPlayer();
								}
								else
								{
									subject.switchDirection();
								}
							}
							else
							{
								System.out.println("ERROR MOUVEMENT OCTOPUS");
							}
						}
						/////   Bat   /////
						else if(getEntity(y, x) instanceof Bat)
						{
							getEntity(y, x).setHasDoAction(true);
							int n = rand.nextInt(4); //[0-3]
							switch (n) 
							{
							case 0://TOP
								if(getTopEntity(y, x) instanceof Air)
								{
									moveTop(y, x);
								}
								else if(getTopEntity(y, x) instanceof SpawnPoint)
								{
									killPlayer();
								}
								break;
							case 1://BOT
								if(getBotEntity(y, x) instanceof Air)
								{
									moveBot(y, x);
								}
								else if(getBotEntity(y, x) instanceof SpawnPoint)
								{
									killPlayer();
								}
								break;
							case 2://RIGHT
								if(getRightEntity(y, x) instanceof Air)
								{
									moveRight(y, x);
								}
								else if(getRightEntity(y, x) instanceof SpawnPoint)
								{
									killPlayer();
								}
								break;
							case 3://LEFT
								if(getLeftEntity(y, x) instanceof Air)
								{
									moveLeft(y, x);
								}
								else if(getLeftEntity(y, x) instanceof SpawnPoint)
								{
									killPlayer();
								}
								break;

							default:
								System.out.println("ERROR on random number for bat in map");
								break;
							}
							
						}
						/////   Butterfly   /////
						else if(getEntity(y, x) instanceof Butterfly)
						{
							getEntity(y, x).setHasDoAction(true);
							Butterfly subject = (Butterfly) getEntity(y, x);
							
							switch(subject.getLastWallTouched())
							{
							case TOP:
								if(getTopEntity(y, x) instanceof Air)
								{
									moveTop(y, x);
//									subject.cycleReverseLastWallTouched();
								}
								else if(getLeftEntity(y, x) instanceof Air)
								{
									moveLeft(y, x);
								}
								else if(getLeftEntity(y, x) instanceof SpawnPoint)
								{
									killPlayer();
								}
								else
								{
									subject.cycleLastWallTouched();
								}
								break;
							case LEFT:
								if(getLeftEntity(y, x) instanceof Air)
								{
									moveLeft(y, x);
//									subject.cycleReverseLastWallTouched();
								}
								else if(getBotEntity(y, x) instanceof Air)
								{
									moveBot(y, x);
								}
								else if(getBotEntity(y, x) instanceof SpawnPoint)
								{
									killPlayer();
								}
								else
								{
									subject.cycleLastWallTouched();
								}
								break;
							case BOT:
								if(getBotEntity(y, x) instanceof Air)
								{
									moveBot(y, x);
//									subject.cycleReverseLastWallTouched();
								}
								else if(getRightEntity(y, x) instanceof Air)
								{
									moveRight(y, x);
								}
								else if(getRightEntity(y, x) instanceof SpawnPoint)
								{
									killPlayer();
								}
								else
								{
									subject.cycleLastWallTouched();
								}
								break;
							case RIGHT:
								if(getRightEntity(y, x) instanceof Air)
								{
									moveRight(y, x);
//									subject.cycleReverseLastWallTouched();
								}
								else if(getTopEntity(y, x) instanceof Air)
								{
									moveTop(y, x);
								}
								else if(getTopEntity(y, x) instanceof SpawnPoint)
								{
									killPlayer();
								}
								else
								{
									subject.cycleLastWallTouched();
								}
								break;

							default:
								break;
							}
							
						}
					}
					/////////////////////////
					
				}

			}
		}

		if(time < 0)
		{
			System.out.println("Time out !");
			killPlayer();
		}
		else
		{
        	time--;
		}
 
		setChanged();
		notifyObservers();

	}

	/**
	 * Add diamond to player's diamond
	 * + 
	 * update the exit state by calling updateExit()
	 * 
	 */
	private void addDiamondNow(){
		diamondNow++;
		updateExit();
		
	}
	
	/**
	 * update the exit status depending of player's diamond and diamondToWin
	 * 
	 */
	private void updateExit(){
		if(diamondNow == diamondToWin)
		{
			for(int y=0; y < height; y++)
			{
				for(int x=0; x < width; x++)
				{
					if(content[y][x].getClass() == Exit.class)
					{
						setOpen();
					}
				}
			}
		}
		
	}
	
	/**
	 * Set the door open
	 * 
	 */
	public void setOpen() {
		open = true;
	}
	
	/**
	 * Set the door close
	 * 
	 */
	public void setClose() {
		open = false;
	}
	
	/**
	 * Return true if the door is open
	 * 
	 * @return open
	 * 		return true if the door is open
	 * 
	 */
	public boolean isOpen() {
		return open;
	}
	
	/**
	 * by calling this function, make a lot of action if the player is killed
	 */
	public void killPlayer() {
		System.out.println("Player is dead !");
		loose = true;
		time = 2000000000;//for background map timer
		explode(getPlayerLocation());
//		setChanged();
//		notifyObservers();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Robot r;
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_1);
			r.keyRelease(KeyEvent.VK_1);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Make an explosion at a specific location
	 * 
	 * @param y_
	 * 		x
	 * @param x_
	 * 		y
	 */
	public void explode(int y_, int x_) {
		content[y_][x_] = new Air();
		content[y_+1][x_] = new Air();
		content[y_-1][x_] = new Air();
		content[y_][x_+1] = new Air();
		content[y_][x_-1] = new Air();
		content[y_+1][x_+1] = new Air();
		content[y_+1][x_-1] = new Air();
		content[y_-1][x_+1] = new Air();
		content[y_-1][x_-1] = new Air();
	}
	
	/**
	 * Call explode(int y_, int x_) but with Point
	 * 
	 * @param pnt
	 * 		Point(x,y)
	 * 
	 */
	public void explode(Point pnt) {
		explode(pnt.x,pnt.y);
	}
	
	/**
	 * Make an explosion of diamond at a specific location.
	 *
	 * @param x_
	 * 		x
	 * @param y_
	 * 		y
	 */
	public void explodeDiamond(int x_, int y_) {
		content[x_][y_] = new Diamond();
		content[x_+1][y_] = new Diamond();
		content[x_-1][y_] = new Diamond();
		content[x_][y_+1] = new Diamond();
		content[x_][y_-1] = new Diamond();
		content[x_+1][y_+1] = new Diamond();
		content[x_+1][y_-1] = new Diamond();
		content[x_-1][y_+1] = new Diamond();
		content[x_-1][y_-1] = new Diamond();
	}
	
	/**
	 * Call explodeDiamond(int y_, int x_) but with Point
	 * 
	 * @param pnt
	 * 		Point(x,y)
	 * 
	 */
	public void explodeDiamond(Point pnt) {
		explodeDiamond(pnt.x,pnt.y);
	}

	/**
	 * Used to specify the location where player will move in updateMap()
	 * 
	 * @param dir_
	 * 		Direction.
	 * 
	 */
	public void setNextPlayerDirection(Direction dir_) {
		nextPlayerDirection = dir_;
	}
	
	/**
	 * Get remaining time in second
	 * 
	 * @return time
	 * 		time in second
	 * 
	 */
	public int getTime() {
		return time/5;
	}
	
	/**
	 * Set remaining time in second
	 * 
	 * @param sec_
	 * 		time in second
	 * 
	 */
	public void setTime(int sec_) {
		time = sec_ *5;
	}
	
	/**
	 * Return true if the game is loose
	 * 
	 * @return loose
	 * 		return true if game is loose
	 */
	public boolean isLoose() {
		return loose;
	}
	
	/**
	 * Return true if the game is win
	 * 
	 * @return win
	 * 		return true if game is win
	 */
	public boolean isWin() {
		return win;
	}
}
