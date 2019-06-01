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

public class Map extends Observable {
	private int width;
	private int height;
	private int diamondToWin;
	private int diamondNow;
	boolean open = false;
	private Entity[][] content;// [x][y]
	Direction nextPlayerDirection = Direction.NOTHING;
	Random rand = new Random();
	
	//timer
    // creating timer task, timer
	TimerTask task = new TimerTask() {
        public void run() {
            updateMap();
        }
    };
    Timer timer;
    
    public Map()
    {
    	timer = new Timer();
    	// scheduling the task at interval


		width = 1;
		height = 1;
		content = new Entity[width][height];
		content[0][0] = new Air();
	}
	public Map(int height_, int width_)
	{
		timer = new Timer();
    	timer.schedule(task,200, 200);
		width = width_;
		height = height_;
		content = new Entity[height][width];
	}
	
	public int getDiamondToWin() {
		return diamondToWin;
	}
	public int getDiamondNow() {
		return diamondNow;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public Entity[][] getContent() {
		return content;
	}
	
	public void setDiamondToWin(int mbdiamond){
		if (mbdiamond >= 0) 
		{
			diamondToWin = mbdiamond;
		}
		else 
		{
			System.out.println("error:diamondToWin < 0");
		}
	}
	public void setWidth(int width){
		if (width >= 0) 
		{
			width = getWidth();
		}
		else 
		{
			System.out.println("error:width < 0");
		}
	}
	public void setHeight(int height){
		if (height >= 0) 
		{
			height = getHeight();
		}
		else 
		{
			System.out.println("error:height < 0");
		}
	}
	
	
	// by x,y
	public Entity getTopEntity(int x, int y) {
		return this.getEntity(x, y-1);
	}
	public Entity getBotEntity(int x, int y) {
		return this.getEntity(x, y+1);
	}
	public Entity getBotBotEntity(int x, int y) {
		return this.getEntity(x, y+2);
	}
	public Entity getLeftEntity(int x, int y) {
		return this.getEntity(x-1, y);
	}
	public Entity getLeftLeftEntity(int x, int y) {
		return this.getEntity(x-2, y);
	}
	public Entity getRightRightEntity(int x, int y) {
		return this.getEntity(x+2, y);
	}
	public Entity getRightEntity(int x, int y) {
		return this.getEntity(x+1, y);
	}
	public Entity getLeftBotEntity(int x, int y) {
		return this.getEntity(x-1, y+1);
	}
	public Entity getRightBotEntity(int x, int y) {
		return this.getEntity(x+1, y+1);
	}
	public Entity getEntity(int x, int y) {
		return this.content[x][y];
	}
	
	//MOVE
	public void moveTop(int x, int y) {
//		this.content[x][y-1].destroy();
		this.content[x][y-1] = this.content[x][y];
//		this.content[x][y].destroy();
		this.content[x][y] = new Air();
		System.out.println("Go UP");
	}
	public void moveLeft(int x, int y) {
		this.content[x-1][y] = this.content[x][y];
		this.content[x][y] = new Air();
		System.out.println("Go LEFT");
	}
	public void moveBot(int x, int y) {
		this.content[x][y+1] = this.content[x][y];
		this.content[x][y] = new Air();
		System.out.println("Go DOWN");
	}
	public void moveRight(int x, int y) {
		this.content[x+1][y] = this.content[x][y];
		this.content[x][y] = new Air();
		System.out.println("Go RIGHT");
	}
	//move the player
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

	
	
	// by point
	public void moveTop(Point pnt) {
		moveTop(pnt.x,pnt.y);
	}
	public void moveLeft(Point pnt) {
		moveLeft(pnt.x,pnt.y);
	}
	public void moveBot(Point pnt) {
		moveBot(pnt.x,pnt.y);
	}
	public void moveRight(Point pnt) {
		moveRight(pnt.x,pnt.y);
	}
	public void moveTopPlayer(Point pnt) {
		moveTopPlayer(pnt.x,pnt.y);
	}
	public void moveLeftPlayer(Point pnt) {
		moveLeftPlayer(pnt.x,pnt.y);
	}
	public void moveBotPlayer(Point pnt) {
		moveBotPlayer(pnt.x,pnt.y);
	}
	public void moveRightPlayer(Point pnt) {
		moveRightPlayer(pnt.x,pnt.y);
	}
	
	
	
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
	
	public void setEntityOnTheMap(int x_, int y_, Entity entity_) {
		content[x_][y_] = entity_;
	}
	
//	//temp Titouan le 26.05.2019 15:58
//	public void printMapConsol() {
//		System.out.println();
//		for(int y=0; y < height; y++)
//		{
//			for(int x=0; x < width; x++)
//			{
//				System.out.print(content[x][y].getSprite().getConsoleImage());
//			}
//			System.out.println();
//		}
//		System.out.println("Nb diamond : " + diamondNow + "/" + diamondToWin);
//		System.out.println("Door : " + isOpen());
//	}

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
//		try {
//			TimeUnit.MILLISECONDS.sleep(500);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		//reset des hasDoAction
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
							//						IGravity diam = (IGravity) content[y][x];//debug
							//						System.out.println("isFalling ? : " + diam.isFalling());//debug
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


 
		setChanged();
		notifyObservers();

	}


	private void addDiamondNow(){
		diamondNow++;
		updateExit();
		
	}
	
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
	
	//door
	public void setOpen() {
		open = true;
	}
	public void setClose() {
		open = false;
	}
	public boolean isOpen() {
		return open;
	}
	
	public void killPlayer() {
		System.out.println("Player is dead !");
		explode(getPlayerLocation());
		setChanged();
		notifyObservers();
		
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
	public void explode(Point pnt) {
		explode(pnt.x,pnt.y);
	}
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
	public void explodeDiamond(Point pnt) {
		explodeDiamond(pnt.x,pnt.y);
	}

	public void setNextPlayerDirection(Direction dir_) {
		nextPlayerDirection = dir_;
	}
}
