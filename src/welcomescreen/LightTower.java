package welcomescreen;

public class LightTower extends Tower {
    private int health;
    private int damage;
    private String name;
    private String description;
    private double cost;

    public LightTower(Level level) {
        this.health = 100;
        this.damage = 25;
        this.name = "Light Tower";
        this.description = "Your smallest tower, cheap but gets the job done";
        if (level == Level.EASY) {
            this.cost = 25;
        }
        if (level == Level.INTERMEDIATE) {
            this.cost = 50;
        }
        if (level == Level.HARD) {
            this.cost = 75;
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
