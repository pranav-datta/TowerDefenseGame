public class MediumTower extends Tower {
    private int health;
    private int damage;
    private String name;
    private String description;
    private double buyCost;
    private double upgradeCost;
    private int row;
    private int col;

    public MediumTower(Level level) {
        this.health = 100;
        this.damage = 100;
        this.name = "Medium Tower";
        this.description = "The average tower, packs a punch but not too much punch";
        this.upgradeCost = 40;
        this.row = 0;
        this.col = 0;
        if (level == Level.EASY) {
            this.buyCost = 50;
        }
        if (level == Level.INTERMEDIATE) {
            this.buyCost = 75;
        }
        if (level == Level.HARD) {
            this.buyCost = 100;
        }
    }

    @Override
    void attackEnemy(Enemy enemy) {
        enemy.setHealth(enemy.getHealth() - damage);
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
    double getBuyCost() {
        return this.buyCost;
    }

    @Override
    double getUpgradeCost() {
        return this.upgradeCost;
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
