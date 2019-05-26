package entity;

public class Rock extends Block implements IGravity, ISliding, IMovable{

	private static final Sprite SPRITE = new Sprite('R',"Rock.png");
	
	public Rock() {
		super(SPRITE);
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fall() {
		// TODO Auto-generated method stub
		
	}

}
