package entity;

public class Map {
	private int width;
	private int height;
	private int diamondToWin;
	private Entity[][] content;

	public int getDiamondToWin() {
		return diamondToWin;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
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
	
	
	public Entity getTopEntity(int x, int y) {
		return this.getEntity(x, y+1);
	}

	public Entity getBotEntity(int x, int y) {
		return this.getEntity(x, y-1);
	}

	public Entity getEntity(int x, int y) {
		return this.content[x][y];
	}

}
