package welcomescreen;
/**
 * Monument class to encapsulate monument's data.
 * @author Olaolu Dada
 * @version 1.0
 */
public class Monument {
    private int health;

    /**
     * Constructor for Monument Class.
     * @param level represents level
     */
    public Monument(Level level) {
        if (level == Level.EASY || level == null) {
            this.health = 500;
        } else if (level == Level.INTERMEDIATE) {
            health = 250;
        } else {
            health = 150;
        }
    }

    /**
     * Constructor for Monument Class with no construcotr.
     */
    public Monument() {
        this.health = 500;
    }

    /**
     * Getter for health.
     *
     * @return  monuments health.
     */
    public int getHealth() {
        return health;
    }

}
