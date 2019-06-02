package entity;

public class Exit extends Block implements IDestroyable{

	private static final Sprite SPRITE = new Sprite('E',"Exit.png");
	
	public Exit() {
		super(SPRITE);
	}

}
