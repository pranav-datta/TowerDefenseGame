package welcomescreen;

public class MediumTower extends Tower {
    private int health;
    private int damage;
    private String name;
    private String description;
    private double cost;

    public MediumTower(Level level) {
        this.health = 100;
        this.damage = 50;
        this.name = "Medium Tower";
        this.description = "The average tower, packs a punch but not too much punch";
        if (level == Level.EASY) {
            this.cost = 50;
        }
        if (level == Level.INTERMEDIATE) {
            this.cost = 75;
        }
        if (level == Level.HARD) {
            this.cost = 100;
        }
    }

    @Override
    void attackEnemy() {
        //decrease enemy health by damage
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
    double getCost() {
        return this.cost;
    }
}
