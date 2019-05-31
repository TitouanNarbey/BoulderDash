package entity;

public class Butterfly extends Monster{

private static final Sprite SPRITE = new Sprite('T',"Butterfly.png");
	
	private Direction lastWallTouched = Direction.BOT;

	public Butterfly() {
		super(SPRITE);
	}

	public Direction getLastWallTouched() {
		return lastWallTouched;
	}

	public void setLastWallTouched(Direction lastWallTouched_) {
		this.lastWallTouched = lastWallTouched_;
	}
	
	public void cycleLastWallTouched() {
		switch (lastWallTouched)
		{
		case TOP:
			lastWallTouched = Direction.LEFT;
			break;
		case LEFT:
			lastWallTouched = Direction.BOT;
			break;
		case BOT:
			lastWallTouched = Direction.RIGHT;
			break;
		case RIGHT:
			lastWallTouched = Direction.TOP;
			break;

		default:
			break;
		}
	}
	
	public void cycleReverseLastWallTouched() {
		switch (lastWallTouched)
		{
		case TOP:
			lastWallTouched = Direction.RIGHT;
			break;
		case LEFT:
			lastWallTouched = Direction.TOP;
			break;
		case BOT:
			lastWallTouched = Direction.LEFT;
			break;
		case RIGHT:
			lastWallTouched = Direction.BOT;
			break;

		default:
			break;
		}
	}
	
}
