public class HeavyEnemy extends Enemy {
    private int health;
    private String name;
    private String description;
    private int damage;
    private int row;
    private int col;

    public HeavyEnemy() {
        this.health = 300;
        this.name = "Heavy enemy";
        this.description = "Strongest of 'em all. It's gonna take a lot to get rid of him";
        this.damage = 60;
        this.row = 0;
        this.col = 0;
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
    String getName() {
        return this.name;
    }

    @Override
    String getDescription() {
        return this.description;
    }

    @Override
    int getDamage() {
        return this.damage;
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
