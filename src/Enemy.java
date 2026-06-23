public class Enemy {

    private String name;
    private int health;
    private int attackPower;

    public Enemy(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public void receiveDamage(int damage) {
        health -= damage;

        if (health < 0) {
            health = 0;
        }
    }

    public boolean isDefeated() {
        return health <= 0;
    }

    public void showStatus() {
        if (isDefeated()) {
            System.out.println(name + " - HP: " + health + " - Defeated");
        } else {
            System.out.println(name + " - HP: " + health + " - Alive");
        }
    }
}