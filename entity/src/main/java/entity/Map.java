package entity;

import java.awt.Point;

public class Map {
	private int width;
	private int height;
	private int diamondToWin;
	private Entity[][] content;

	public Map()
	{
		content = new Entity[1][1];
	}
	public Map(int width_, int height_)
	{
		width = width_;
		height = height_;
		content = new Entity[height_][width_];
	}
	
	public int getDiamondToWin() {
		return diamondToWin;
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
		this.content[x][y] = new Air();;
		System.out.println("Go UP");
	}
	public void moveLeft(int x, int y) {
		this.content[x-1][y] = this.content[x][y];
		this.content[x][y] = new Air();;
		System.out.println("Go LEFT");
	}
	public void moveBot(int x, int y) {
		this.content[x][y+1] = this.content[x][y];
		this.content[x][y] = new Air();;
		System.out.println("Go DOWN");
	}
	public void moveRight(int x, int y) {
		this.content[x+1][y] = this.content[x][y];
		this.content[x][y] = new Air();;
		System.out.println("Go RIGHT");
	}
	//move the player
	public boolean moveTopPlayer(int x, int y) {
		Entity enti = this.getTopEntity(x, y);
		if(enti.getClass() == IDestroyable.class)
		{
			moveTop(x, y);
			printMapConsol();
			return true;
		}
		else
		{
			printMapConsol();
			return false;
		}
	}
	public boolean moveBotPlayer(int x, int y) {
		Entity enti = this.getBotEntity(x, y);
		if(enti.getClass() == IDestroyable.class)
		{
			moveBot(x, y);
			printMapConsol();
			return true;
		}
		else
		{
			printMapConsol();
			return false;
		}
	}
	public boolean moveLeftPlayer(int x, int y) {
		Entity enti = this.getLeftEntity(x, y);
		if(enti.getClass() == IDestroyable.class)
		{
			moveLeft(x, y);
			printMapConsol();
			return true;
		}
		else
		{
			printMapConsol();
			return false;
		}
	}
	public boolean moveRightPlayer(int x, int y) {
		Entity enti = this.getRightEntity(x, y);
		if(enti.getClass() == IDestroyable.class)
		{
			moveRight(x, y);
			printMapConsol();
			return true;
		}
		else
		{
			printMapConsol();
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
	
	
	
	public Point getPlayerLocation() {
		Point pnt = null;
		for(int y=0; y < height; y++)
		{
			for(int x=0; x < width; x++)
			{
				if(content[x][y].getClass() == Player.class)
				{
					pnt = new Point(x,y);
				}
			}
		}
		return pnt;
	}
	
	public void setEntityOnTheMap(int x_, int y_, Entity entity_) {
		content[x_][y_] = entity_;
	}
	
	//temp Titouan le 26.05.2019 15:58
	public void printMapConsol() {
		System.out.println();
		for(int y=0; y < height; y++)
		{
			for(int x=0; x < width; x++)
			{
				System.out.print(content[x][y].getSprite().getConsoleImage());
			}
			System.out.println();
		}
	}
	
	
}
