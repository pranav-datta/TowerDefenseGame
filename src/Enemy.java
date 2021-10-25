public abstract class Enemy {
    private boolean isKilled;
    private int health;
    private int damage;
    abstract void setHealth(int newHealth);
    abstract int getHealth();
    abstract void attack(Monument monument);
    abstract void attack(Tower tower);
    abstract void setKilled(boolean killed);

}
