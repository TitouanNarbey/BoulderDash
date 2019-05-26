package entity;

/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Entity {
	private Sprite sprite;
	
    public Entity(final Sprite sprite_) {
        this.setSprite(sprite_);
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
	
}

/*

Roch = R
Air = espace
Diamond = D
Border = B
Exit = E
Dirt = P
Player = P
Monster = M
SpawnPoint = _
*/

/*
Pour la MAP:
On aura 20 lignes en verticale et 20 en horizontale 
Voici un exemple de la MAP sans avoir inseré les objets dedans.
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
:11 D
Il faudra donc inserer tout les objets ainsi que le joueur et les monstres. 


*/