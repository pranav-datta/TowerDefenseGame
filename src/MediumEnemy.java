public class MediumEnemy extends Enemy {
    private int health;
    private String name;
    private String description;

    public MediumEnemy() {
        this.health = 250;
        this.name = "Medium enemy";
        this.description = "The average enemy, they're pretty strong but not the strongest";
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
