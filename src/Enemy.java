public abstract class Enemy {
    abstract String getName();

    abstract String getDescription();

    abstract int getDamage();
    /**
     * Getter for destroyed.
     * @return  boolean indicating whether enemy is dead.
     */
    public boolean checkIfDestroyed() {
        if (this.getHealth() <= 0) {
            return true;
        }
        return false;
    }
  
    private boolean isKilled;
    private int health;
    private int damage;
    abstract void setHealth(int newHealth);
    abstract int getHealth();
    abstract void attack(Monument monument);
    abstract void attack(Tower tower);
    abstract void setKilled(boolean killed);

}
