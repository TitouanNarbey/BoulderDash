package entity;

public class Exit extends Block implements IDestroyable{

	private static final Sprite SPRITE = new Sprite('E',"Exit.png");
	
	
	public Exit() {
		super(SPRITE);
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	

}
