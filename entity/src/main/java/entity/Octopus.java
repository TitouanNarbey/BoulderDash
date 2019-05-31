package entity;

public class Octopus extends Monster{
	
	private static final Sprite SPRITE = new Sprite('O',"Octopus.png");
	private Direction direction; // can get only TOP or BOT
	
	public Octopus() {
		super(SPRITE);
		direction = Direction.BOT;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction_) {
		if(direction_ == Direction.TOP || direction_ == Direction.BOT)
		{
			this.direction = direction_;
		}
	}
	public void switchDirection() {
		if(this.direction == Direction.TOP)
		{
			this.direction = Direction.BOT;
		}
		else
		{
			this.direction = Direction.TOP;
		}
	}
	
	
}
