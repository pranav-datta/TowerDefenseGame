package welcomescreen;

public class HeavyTower extends Tower {
    private int health;
    private int damage;
    private String name;
    private String description;
    private double buyCost;
    private double upgradeCost;

    public HeavyTower(Level level) {
        this.health = 100;
        this.damage = 100;
        this.name = "Medium Tower";
        this.description = "The big behemoth";
        this.upgradeCost = 0;
        if (level == Level.EASY) {
            this.buyCost = 75;
        }
        if (level == Level.INTERMEDIATE) {
            this.buyCost = 100;
        }
        if (level == Level.HARD) {
            this.buyCost = 150;
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
    double getBuyCost() {
        return this.buyCost;
    }

    @Override
    double getUpgradeCost() {
        return this.upgradeCost;
    }

}
