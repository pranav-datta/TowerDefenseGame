public class MediumEnemy extends Enemy {
    private int health;
    private String name;
    private String description;
    private int damage;

    public MediumEnemy() {
        this.health = 250;
        this.name = "Medium enemy";
        this.description = "The average enemy, they're pretty strong but not the strongest";
        this.damage = 50;
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
    void attack(Monument monument) {

    }

    @Override
    void attack(Tower tower) {

    }

    @Override
    void setKilled(boolean killed) {

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
    int getDamage() {
        return this.damage;
    }
}
