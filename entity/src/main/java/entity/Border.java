package entity;

public class Border extends Block implements ISliding{

	private static final Sprite SPRITE = new Sprite('B',"Rock.png");
	
	public Border() {
		super(SPRITE);
	}
}
