package welcomeScreen;
/**
 * Monument class to encapsulate monument's data.
 * @author Olaolu Dada
 * @version 1.0
 */
public class Monument {
    private int health;
    private Level level;

    /**
     * Constructor for Monument Class.
     * @param level represents level
     */
    public Monument(Level level) {
        if (level == level.EASY) {
            health = 500;
        } else if (level == level.INTERMEDIATE) {
            health = 250;
        } else {
            health = 150;
        }
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
