public class LightEnemy extends Enemy {
    private int health;
    private String name;
    private String description;

    public LightEnemy() {
        this.health = 150;
        this.name = "Light enemy";
        this.description = "Your weakest enemy, easy to kill";
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
