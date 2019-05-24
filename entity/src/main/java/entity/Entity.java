package entity;

import contract.IGravity;
import contract.ISliding;
import contract.IMovable;
import contract.IDestroyable;

/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Entity {

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