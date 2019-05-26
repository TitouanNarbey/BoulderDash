package entity;

public class Player extends Alive{

	private static final Sprite SPRITE = new Sprite('P',"Rock.png");
	
	public Player() {
		super(SPRITE);
	}
}
