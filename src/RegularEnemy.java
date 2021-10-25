public class RegularEnemy extends Enemy {
    private boolean isKilled;
    private int health;
    private int damage;

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
        monument.setHealth(monument.getHealth() - this.damage);
    }

    @Override
    void attack(Tower tower) {
        tower.setHealth(tower.getHealth() - this.damage);
    }

    @Override
    void setKilled(boolean killed) {
        this.isKilled = killed;
    }


}
