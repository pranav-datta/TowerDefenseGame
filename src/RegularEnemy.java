public class RegularEnemy extends Enemy {
    private boolean isKilled;
    private int health;
    private int damage;

    @Override
    String getName() {
        return null;
    }

    @Override
    String getDescription() {
        return null;
    }

    @Override
    int getDamage() {
        return 0;
    }

    @Override
    void setHealth(int newHealth) {
        this.health = newHealth;
    }

    @Override
    int getHealth() {
        return this.health;
    }

}
