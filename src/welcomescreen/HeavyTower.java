package welcomescreen;

public class HeavyTower extends Tower {
    private int health;
    private int damage;
    private String name;
    private String description;
    private double cost;

    public HeavyTower(Level level) {
        this.health = 100;
        this.damage = 100;
        this.name = "Medium Tower";
        this.description = "The big behemoth";
        if (level == Level.EASY) {
            this.cost = 75;
        }
        if (level == Level.INTERMEDIATE) {
            this.cost = 100;
        }
        if (level == Level.HARD) {
            this.cost = 150;
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
