package entity;

import java.awt.Point;

public class Map {
	private int width;
	private int height;
	private int diamondToWin;
	private int diamondNow;
	boolean open = false;
	private Entity[][] content;// [x][y]

	public Map()
	{
		width = 1;
		height = 1;
		content = new Entity[width][height];
		content[0][0] = new Air();
	}
	public Map(int height_, int width_)
	{
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
	public Entity getLeftEntity(int x, int y) {
		return this.getEntity(x-1, y);
	}
	public Entity getRightEntity(int x, int y) {
		return this.getEntity(x+1, y);
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
			}
			if(getBotEntity(x, y) instanceof Exit && isOpen())
			{
				System.out.println("Win !");
			}
			moveTop(x, y);
			updateMap();
			return true;
		}
		else
		{
			updateMap();
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
			}
			if(getBotEntity(x, y) instanceof Exit && isOpen())
			{
				System.out.println("Win !");
			}
			moveBot(x, y);
			updateMap();
			return true;
		}
		else
		{
			updateMap();
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
			}
			if(getLeftEntity(x, y) instanceof Exit && isOpen())
			{
				System.out.println("Win !");
			}
			moveLeft(x, y);
			updateMap();
			return true;
		}
		else
		{
			updateMap();
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
			}
			if(getRightEntity(x, y) instanceof Exit && isOpen())
			{
				System.out.println("Win !");
			}
			moveRight(x, y);
			updateMap();
			return true;
		}
		else
		{
			updateMap();
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
				if(content[y][x].getClass() == /*Player.class*/SpawnPoint.class)
				{
					pnt = new Point(y,x);
					System.out.println("SpawnPoint found : " + x + " " + y);
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
		for(int y=height-1; y > 0; y--)
		{
			for(int x=width-1; x > 0; x--)
			{
				if(getEntity(x, y) instanceof IGravity)
				{
					if(getBotEntity(x, y) instanceof Air)
					{
						moveBot(x, y);
						
					}
				}
			}
		}

//		printMapConsol();
		notifyAll();
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
					if(content[x][y].getClass() == Exit.class)
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
}
