package welcomescreen;

/**
 * Player class to encapsulate player's data.
 *
 * @author Olaolu Dada
 * @version 1.0
 */
public class Player {
    private String name;
    private double money;
    private Level level;
    private Monument monument;

    /**
     * No-arg constructor for Player class.
     * Sets name to George P. Burdell, money to 0, monument to strong,
     * and difficulty to easy.
     */
    public Player() {
        this("George P. Burdell", Level.EASY);
        this.monument = new Monument(Level.EASY);
    }

    /**
     * One-arg constructor for name.
     * Automatically sets money to 0, monument to strong,
     * and difficulty to easy.
     *
     * @param name name of player
     */
    public Player(String name) {
        this(name, Level.EASY);
        this.monument = new Monument(Level.EASY);
    }

    /**
     * Constructor for the Player class.
     *
     * @param name  represents the player's name.
     * @param level    represents the difficulty the player is playing
     *                      the game at.
     */
    public Player(String name,  Level level) {
        this.name = name;
        if (level == Level.EASY || level == null) {
            money = 500;
            this.monument = new Monument(Level.EASY);
        } else if (level == Level.INTERMEDIATE) {
            money = 250;
            this.monument = new Monument(Level.INTERMEDIATE);
        } else {
            money = 150;
            this.monument = new Monument(Level.HARD);
        }
        this.level = level;
    }

    /**
     * Getter for name.
     *
     * @return  player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for money.
     *
     * @return  player's money.
     */
    public double getMoney() {
        return money;
    }

    public void setMoney(double newMoney) {
        this.money = newMoney;
    }

    /**
     * Getter for level.
     *
     * @return  player's level.
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Getter for monument.
     * @return  player's monument object.
     */
    public Monument getMonument() {
        return monument;
    }

}
