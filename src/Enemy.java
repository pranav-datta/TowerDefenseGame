public abstract class Enemy {
    abstract void setHealth(int newHealth);

    abstract int getHealth();

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
}
