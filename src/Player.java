import javafx.scene.layout.GridPane;

import java.util.ArrayList;

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
    private ArrayList<LightTower> lTowers;
    private ArrayList<MediumTower> mTowers;
    private ArrayList<HeavyTower> hTowers;
    private ArrayList<Tower> towerPlots;
    private int rows;

    private static final int CAPACITY = 12;
    private static final int PLOTCAPACITY = 36;


    /**
     * No-arg constructor for Player class.
     * Sets name to George P. Burdell, money to 0, monument to strong,
     * and difficulty to easy.
     */
    public Player() {
        this("George P. Burdell", Level.EASY);
        monument = new Monument(Level.EASY);
        lTowers = new ArrayList<>(CAPACITY);
        mTowers = new ArrayList<>(CAPACITY);
        hTowers = new ArrayList<>(CAPACITY);
        towerPlots = new ArrayList<>(PLOTCAPACITY);

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
        monument = new Monument(Level.EASY);
        lTowers = new ArrayList<>(CAPACITY);
        mTowers = new ArrayList<>(CAPACITY);
        hTowers = new ArrayList<>(CAPACITY);
        towerPlots = new ArrayList<>(PLOTCAPACITY);

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
        lTowers = new ArrayList<>(CAPACITY);
        mTowers = new ArrayList<>(CAPACITY);
        hTowers = new ArrayList<>(CAPACITY);

        lTowers.add(new LightTower(level));
        towerPlots = new ArrayList<>(PLOTCAPACITY);
        towerPlots.add(new LightTower(level));
        rows = 3;

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

    /**
     * Getter for list of light towers owned.
     *
     * @return  list of light towers owned by player.
     */
    public ArrayList<LightTower> getLTowers() {
        return lTowers;
    }

    /**
     * Getter for list of medium towers owned.
     *
     * @return  list of medium towers owned by player.
     */

    public ArrayList<MediumTower> getMTowers() {
        return mTowers;
    }
    /**
     * Getter for list of heavy towers owned.
     *
     * @return  list of heavy towers owned by player.
     */
    public ArrayList<HeavyTower> getHTowers() {
        return hTowers;
    }

    public void upgradeLTower(double cost) {
        MediumTower newTower = new MediumTower(level);
        for (int i = 0; i < towerPlots.size(); i++) {
            if (towerPlots.get(i) instanceof LightTower) {
                towerPlots.set(i, newTower);
                break;
            }
        }
        mTowers.add(newTower);
        lTowers.remove(0);
    }

    public void upgradeMTower(double cost) {
        HeavyTower newTower = new HeavyTower(level);
        for (int i = 0; i < towerPlots.size(); i++) {
            if (towerPlots.get(i) instanceof MediumTower) {
                towerPlots.set(i, newTower);
                break;
            }
        }
        hTowers.add(newTower);
        mTowers.remove(0);;
    }

    /**
     * Getter for plots.
     *
     * @return the tower plots the player has.
     */
    public ArrayList<Tower> getTowerPlots() {
        return towerPlots;
    }

    /**
     * Getter for num rows.
     *
     * @return the number of rows in the plots.
     */
    public int getRows() {
        return rows;
    }

    /**
     * Checks if all plots are full
     */
    public boolean isFull() {
        for (Tower t : towerPlots) {
            if (t == null) {
                return false;
            }
        }
        return false;
    }

    /**
     * Clears out all of the destroyed plots.
     */
    public void clear() {
        for (Tower t : towerPlots) {
            if (t.isDestroyed()) {
                t = null;
            }
        }
    }

}

