package entity;

public class Player extends Alive{

	private static final Sprite SPRITE = new Sprite('P',"Personnage\\Face\\Face 1.png");
	
	public Player() {
		super(SPRITE);
	}
}
