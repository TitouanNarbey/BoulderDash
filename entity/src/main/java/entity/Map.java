package entity;

public class Map {
	private int width;
	private int height;
	private int diamondToWin;
	private Entity[][] content;
	
	
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
	
	public void moveTop(int x, int y) {
		
	}

	
}
