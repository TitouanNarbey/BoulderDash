package entity;

public class Dirt extends Block implements IDestroyable{

	private static final Sprite SPRITE = new Sprite('P',"Dirt.png");
	
	public Dirt() {
		super(SPRITE);
	}

}
