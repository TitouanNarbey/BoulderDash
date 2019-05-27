package entity;

public class Player extends Alive{

	private static final Sprite SPRITE = new Sprite('P',"Pouple.png");
	
	public Player() {
		super(SPRITE);
	}
}
