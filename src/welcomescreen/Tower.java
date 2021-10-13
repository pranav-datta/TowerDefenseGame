package welcomescreen;

public abstract class Tower {

    abstract void attackEnemy();
    abstract void setHealth(int newHealth);
    abstract int getHealth();
    abstract String getName();
    abstract String getDescription();
    abstract double getCost();
}
