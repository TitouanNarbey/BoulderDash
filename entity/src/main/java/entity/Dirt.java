package entity;

public class Dirt extends Block implements IDestroyable{

	private static final Sprite SPRITE = new Sprite('P',"Dirt.png");
	
	public Dirt() {
		super(SPRITE);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
