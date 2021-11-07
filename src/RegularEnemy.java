public class RegularEnemy extends Enemy {
    private boolean isKilled;
    private int health;
    private int damage;
    private int row;
    private int col;

    @Override
    String getName() {
        return null;
    }

    @Override
    String getDescription() {
        return null;
    }

    @Override
    int getDamage() {
        return 0;
    }

    @Override
    void setHealth(int newHealth) {
        this.health = newHealth;
    }

    @Override
    int getHealth() {
        return this.health;
    }

    @Override
    int getRow() {
        return this.row;
    }

    @Override
    int getCol() {
        return this.col;
    }

    @Override
    void setRow(int newRow) {
        this.row = newRow;
    }

    @Override
    void setCol(int newCol) {
        this.col = newCol;
    }
}
