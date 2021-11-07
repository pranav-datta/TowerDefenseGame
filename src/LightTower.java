public class LightTower extends Tower {
    private int health;
    private int damage;
    private String name;
    private String description;
    private double buyCost;
    private double upgradeCost;
    private int row;
    private int col;

    public LightTower(Level level) {
        this.health = 100;
        this.damage = 50;
        this.name = "Light Tower";
        this.upgradeCost = 30;
        this.description = "Your smallest tower, cheap but gets the job done";
        this.row = 0;
        this.col = 0;
        if (level == Level.EASY) {
            this.buyCost = 25;
        }
        if (level == Level.INTERMEDIATE) {
            this.buyCost = 50;
        }
        if (level == Level.HARD) {
            this.buyCost = 75;
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
