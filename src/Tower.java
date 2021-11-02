public abstract class Tower {
    private boolean destroyed;

    abstract void attackEnemy(Enemy enemy);

    abstract void setHealth(int newHealth);

    abstract int getHealth();

    abstract String getName();

    abstract String getDescription();

    abstract double getBuyCost();

    abstract double getUpgradeCost();

    /**
     * Getter for destroyed.
     *
     * @return boolean indicating whether tower is removed.
     */
    public boolean isDestroyed() {
        if (this == null) {
            return false;
        } else if (this.getHealth() != 0) {
            return false;
        }
        return true;
    }
}

