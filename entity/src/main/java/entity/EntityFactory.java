package entity;

public class EntityFactory {

    /** The Constant air. */
    private static final Air          AIR          = new Air();

    /** The Constant border. */
    private static final Border           BORDER           = new Border();

    /** The Constant diamond. */
    private static final Diamond   DIAMOND   = new Diamond();

    /** The Constant dirt. */
    private static final Dirt  DIRT  = new Dirt();

    /** The Constant exit. */
    private static final Exit  EXIT  = new Exit();

    /** The Constant octopus. */
    private static final Octopus                OCTOPUS                 = new Octopus();
    /** The Constant bat. */
    private static final Bat               		BAT                		= new Bat();
    /** The Constant butterfly. */
    private static final Butterfly              BUTTERFLY               = new Butterfly();

    /** The Constant player. */
    private static final Player             PLAYER             = new Player();

    /** The Constant rock. */
    private static final Rock            ROCK            = new Rock();
    
    /** The Constant spawn point. */
    private static final SpawnPoint            SPAWNPOINT            = new SpawnPoint();

    /**
     * The entities elements is an array of all possible entities.
     */
    private static Entity[]       entities  = {
    		AIR,
    		BORDER,
    		DIAMOND,
    		DIRT,
    		EXIT,
    		OCTOPUS,
    		BAT,
    		BUTTERFLY,
    		PLAYER,
    		ROCK, 
    		SPAWNPOINT};

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Entity createAir() {
        return AIR;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Entity createBorder() {
        return BORDER;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Entity createDiamond() {
        return DIAMOND;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Entity createDirt() {
        return DIRT;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Entity createExit() {
        return EXIT;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Entity createBat() {
        return BAT;
    }
    public static Entity createButterfly() {
        return BUTTERFLY;
    }

    public static Entity createOctopus() {
        return OCTOPUS;
    }


    /**
     * Creates a new macadam object.
     *
     * @return the motionless element
     */
    public static Entity createPlayer() {
        return PLAYER;
    }

    /**
     * Creates a new obstacle object.
     *
     * @return the motionless element
     */
    public static Entity createRock() {
        return ROCK;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Entity createSpawnPoint() {
        return SPAWNPOINT;
    }

    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static Entity getFromSymbol(final char fileSymbol) {
        for (final Entity entityElement : entities) {
            if (entityElement.getSprite().getConsoleImage() == fileSymbol) {
                return entityElement;
            }
        }
        return AIR;
    }

}

