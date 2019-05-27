package entity;

public class Monster extends Alive{

	private static final Sprite SPRITE = new Sprite('M',"Papillon.png");
	
	public Monster() {
		super(SPRITE);
	}
}
