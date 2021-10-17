package welcomescreen;

import java.lang.reflect.Array;
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
    private int plotCapacity;

    private static final int CAPACITY = 4;


    /**
     * No-arg constructor for Player class.
     * Sets name to George P. Burdell, money to 0, monument to strong,
     * and difficulty to easy.
     */
    public Player() {
        this("George P. Burdell", Level.EASY);
        this.monument = new Monument(Level.EASY);
        this.lTowers = new ArrayList<>();
        this.mTowers = new ArrayList<>();
        this.hTowers = new ArrayList<>();

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
        this.lTowers = new ArrayList<>(CAPACITY);
        this.mTowers = new ArrayList<>(CAPACITY);
        this.hTowers = new ArrayList<>(CAPACITY);

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
        this.lTowers = new ArrayList<>(CAPACITY);
        this.mTowers = new ArrayList<>(CAPACITY);
        this.hTowers = new ArrayList<>(CAPACITY);

        lTowers.add(new LightTower(level));
        plotCapacity = 12;
        towerPlots = new ArrayList<>(plotCapacity);
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
        if (lTowers.size() == 0) {
            throw new IllegalArgumentException("You have no more light towers to upgrade");
        } else {
            MediumTower newTower = new MediumTower(level);
            mTowers.add(mTowers.size(), newTower);
            lTowers.remove(0);
            money -= cost;
        }
    }

    public void upgradeMTower(double cost) {
        if (mTowers.size() == 0) {
            throw new IllegalArgumentException("You have no more medium towers to upgrade");
        } else {
            HeavyTower newTower = new HeavyTower(level);
            hTowers.add(hTowers.size(), newTower);
            mTowers.remove(0);
            money -= cost;
        }
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
     * Method to place a tower in the plots.
     *
     */
    public void placeTower(Tower tower) {
        if (this.isFull()) {
            AlertBox.display("Not Enough Space!", "Either clear your destroyed towers or upgrade them!");
        } else {
            for (int i = 0; i < towerPlots.size(); i++) {
                if (towerPlots.get(i) == null) {
                    towerPlots.set(i, tower);
                    break;
                }
            }
            money -= tower.getBuyCost();
            AlertBox.display("New Balance", "You now have $"
                    + money);
        }
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
        return true;
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

