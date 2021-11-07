public class LightEnemy extends Enemy {
    private int health;
    private String name;
    private String description;
    private int damage;
    private int row;
    private int col;

    public LightEnemy() {
        this.health = 150;
        this.name = "Light enemy";
        this.description = "Your weakest enemy, easy to kill";
        this.damage = 40;
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
