package entity;

public class Map {
	private int width;
	private int height;
	private int diamondToWin;
	private Entity[][] content;
	
	
	public Entity getTopEntity(int x, int y) {
		return this.getEntity(x, y+1);
	}
	
	public Entity getBotEntity(int x, int y) {
		return this.getEntity(x, y-1);
	}
	
	public Entity getEntity(int x, int y) {
		return this.content[x][y];
	}
	/*
	 BBBB
	 B _B
	 BE B
	 BBBB
	 */
}
