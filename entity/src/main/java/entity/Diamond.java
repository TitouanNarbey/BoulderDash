package entity;

public class Diamond extends Block implements IGravity, ISliding, IDestroyable{

	private static final Sprite SPRITE = new Sprite('D',"Diamond.png");

	boolean inFall = false;
	
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

	@Override
	public void setFalling(boolean bool) {
		inFall = bool;
		
	}

	@Override
	public boolean isFalling() {
		return inFall;
	}
}
