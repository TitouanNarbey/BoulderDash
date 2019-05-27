package entity;


public class Air extends Block implements IDestroyable{
	
	private static final Sprite SPRITE = new Sprite(' ',"Air.png");
	
	public Air() {
		super(SPRITE);
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
