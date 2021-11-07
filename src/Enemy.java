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

    private int health;
    private int damage;
    private int row;
    private int col;
    abstract int getRow();
    abstract int getCol();
    abstract void setRow(int newRow);
    abstract void setCol(int newCol);
    abstract void setHealth(int newHealth);
    abstract int getHealth();

}
