public class HeavyEnemy extends Enemy {
    private int health;
    private String name;
    private String description;

    public HeavyEnemy() {
        this.health = 500;
        this.name = "Heavy enemy";
        this.description = "Strongest of 'em all. It's gonna take a lot to get rid of him";
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
}
