package entity;

// TODO: Auto-generated Javadoc
/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Entity {
	
	/** The sprite. */
	private Sprite sprite;
	
	/** The has do action. */
	boolean hasDoAction;
	
    /**
     * Instantiates a new entity.
     *
     * @param sprite_ the sprite
     */
    public Entity(final Sprite sprite_) {
        this.setSprite(sprite_);
        hasDoAction = false;
    }
	
    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    public final Sprite getSprite() {
        return this.sprite;
    }

    /**
     * Sets the sprite.
     *
     * @param sprite
     *            the new sprite
     */
    private void setSprite(final Sprite sprite) {
        this.sprite = sprite;
    }
    
    /**
     * Sets the checks for do action.
     *
     * @param act_ the new checks for do action
     */
    public void setHasDoAction(boolean act_) {
    	hasDoAction = act_;
//		System.out.println("action set to :" + hasDoAction);
    }
    
    /**
     * Gets the checks for do action.
     *
     * @return the checks for do action
     */
    public boolean getHasDoAction() {
//		System.out.println("return hasDoAction : " + hasDoAction);
    	return hasDoAction;
    }
	
}

/*

Rock = R
Air = space
Diamond = D
Border = B
Exit = E
Dirt = P
Player = P //finally, we decided to move the spawnpoint
Monster = M
SpawnPoint = _
*/

/*
For the MAP:
MAP exemple :
BBBBBBBBBBBBBBBBBBBB
BPPPPPPPPPP RD R PPB
BPP_PPPPPPP  RR  PPB
B                  B
B                  B
B        RR        B
BRRR   RRDDR       B
BDD                B
B             RR   B
B    RR       D    B
B    D             B
B        RR        B
B        RD        B
B                  B
B             RD   B
B  RR         RR   B
B   D              B
B        RR      E B
B        D         B
BBBBBBBBBBBBBBBBBBBB
:20x20
:11 DiamondToWin

\r\n need at the end of each line


*/