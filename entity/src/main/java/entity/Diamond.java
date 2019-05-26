package entity;

public class Diamond extends Block implements IGravity, ISliding, IDestroyable{

	private static final Sprite SPRITE = new Sprite('D',"Rock.png");
	
	public Diamond() {
		super(SPRITE);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fall() {
		// TODO Auto-generated method stub
		
	}

}
